pipeline {
    agent any

    tools {
      jdk 'JDK'
      maven 'MAVEN3'
    }

    environment {
        DOCKER_IMAGE = 'dom1232/mavenwebapp'
    }

    stages {
        stage('Checkout'){
            steps {
                git branch: 'master', url: 'https://github.com/Dom1232/COMP367MavenProjectLab2.git'
            }
        }
        stage('Build Maven Project'){
            steps {
                bat "mvn clean package"
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([string(credentialsId: 'docker-token', variable: 'DOCKER_TOKEN')]) {
                    echo "Logging into Docker"
                    bat "echo %DOCKER_TOKEN% | docker login -u dom1232 --password-stdin"
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t %DOCKER_IMAGE% ."
            }
        }

        stage('Docker Push') {
            steps {
                bat "docker push %DOCKER_IMAGE%"
            }
        }

        stage('Deploy') {
            steps {
                bat "docker run -d -p 8080:8080 %DOCKER_IMAGE%"
            }
        }
    }
}
