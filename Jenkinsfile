pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t shubh4321/selenium-docker-sample ."
            }
        }
        stage('Push Image') {
            steps {
			   withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
			       sh "docker login --username=${user} --password=${pass}"
			       sh "docker push shubh4321/selenium-docker-sample:latest"
			   }
            }
        }
    }
}
