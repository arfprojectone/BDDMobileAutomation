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
                sleep 10
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running Mobile Automation Tests...'
                sh 'mvn clean test'
            }
        }

        stage('Prepare HTML Report') {
            steps {
                echo 'Preparing HTML report folder...'
                sh 'mkdir -p target/html-report'
                sh 'cp target/cucumber-reports.html target/html-report/index.html'
            }
        }

        stage('Publish Cucumber HTML Report') {
            steps {
                echo 'Publishing HTML report...'
                publishHTML([
                    reportDir: 'target/html-report',
                    reportFiles: 'index.html',
                    reportName: 'Cucumber HTML Report',
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true
                ])
            }
        }

        stage('Archive JSON and XML Reports') {
            steps {
                echo 'Archiving JSON and XML reports...'
                archiveArtifacts artifacts: 'target/cucumber-report.json', fingerprint: true
                archiveArtifacts artifacts: 'target/cucumber-report.xml', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Stopping Appium server...'
            sh "pkill -f appium || true"
        }

        success {
            echo '✅ Tests passed!'
        }

        failure {
            echo '❌ Tests failed. Please check reports.'
        }
    }
}