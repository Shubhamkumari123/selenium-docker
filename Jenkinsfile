pipeline {
    agent none
    stages {
        stage('Build Jar') {
            steps {
               docker {
                 image 'maven:3-alpine'
               }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	sh 'docker build -t shubh4321/selenium-docker-sample .'
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    	sh 'docker login --username=${user} --password=${pass}'
                    	sh 'docker push shubh4321/selenium-docker-sample:latest'
			        }
                }
            }
        }
    }
}
