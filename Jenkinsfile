pipeline {
    agent any

//     environment {
//         ANDROID_HOME = "/path/to/android/sdk" // Ganti dengan SDK kamu
//         PATH = "$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH"
//     }
//
//     tools {
//         maven 'Maven_3'     // Sesuaikan dengan nama Maven di Jenkins
//         jdk 'JDK_11'        // Sesuaikan juga dengan JDK kamu
//     }

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

        stage('Publish Cucumber HTML Report') {
            steps {
                echo 'Publishing HTML report...'
                publishHTML([
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html',
                    reportName: 'Cucumber HTML Report',
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