pipeline {
    agent any

    tools {
      jdk 'JDK'
      maven 'MAVEN3'
    }

    stages {
        stage('Checkout'){
            steps {
                git branch: 'master', url: 'https://github.com/Dom1232/COMP367MavenProjectLab2.git'
            }
        }
        stage('Build'){
            steps {
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
                bat "mvn clean compile"
            }
        }
    }
}
