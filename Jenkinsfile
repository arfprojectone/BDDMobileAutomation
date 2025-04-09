pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/arfprojectone/BDDMobileAutomation.git'
            }
        }

        stage('Start Appium Server') {
            steps {
                echo 'Starting Appium Server...'
                sh 'appium --log appium.log &'
                sleep 5
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running Mobile Automation Tests...'
                sh 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo 'Generating Allure report...'
                sh 'mvn allure:report'
            }
        }

        stage('Publish Allure Report') {
            steps {
                echo 'Publishing Allure report...'
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }

        stage('Archive Reports') {
            steps {
                echo 'Archiving reports...'
                archiveArtifacts artifacts: 'target/cucumber-reports.*', fingerprint: true
                archiveArtifacts artifacts: 'target/cucumber-report.*', fingerprint: true
                archiveArtifacts artifacts: 'target/site/allure-maven-plugin/index.html', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Stopping Appium server...'
            sh "pkill -f appium || true"
            junit allowEmptyResults: true, testResults: 'target/cucumber-report.xml'
        }

        success {
            echo '✅ Tests passed!'
        }

        failure {
            echo '❌ Tests failed. Please check reports.'
        }
    }
}
