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
                bat "mvn clean package"
            }
        }
        stage('Deploy'){
            steps {
                bat "java -jar target/MavenWebApp-0.0.1-SNAPSHOT.jar"
            }
        }
    }
}
