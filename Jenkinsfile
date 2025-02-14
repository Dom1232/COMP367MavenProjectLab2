pipeline {
    agent any
    tools {
        maven "Maven"
    }
    stages {
        stage('Checkout') {
        	steps {
        		checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'

            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                sh 'mvn -Dmaven.test.failure.ignore=true deploy'
            }
        }
    }
}