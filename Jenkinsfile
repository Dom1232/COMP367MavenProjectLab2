pipeline {
    agent any

    tools {
      jdk 'JDK'
      maven 'MAVEN3'
    }

    environment {
        DOCKER_IMAGE = 'dom1232/mavenwebapp'
	DOCKER_HOST = "npipe:////./pipe/docker_engine"
    }

    stages {
        stage('Checkout'){
            steps {
                git branch: 'master', url: 'https://github.com/Dom1232/COMP367MavenProjectLab2.git'
            }
        }
        stage('Build Maven Project'){
            steps {
                sh "mvn clean package"
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'e31bf634-3049-47e9-941f-4409f8ca7698', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
		    sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t %DOCKER_IMAGE% ."
            }
        }

        stage('Docker Push') {
            steps {
                sh "docker push %DOCKER_IMAGE%"
            }
        }

        stage('Deploy') {
            steps {
                sh "docker run -d -p 8080:8080 %DOCKER_IMAGE%"
            }
        }
    }
}
