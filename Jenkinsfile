pipeline {
  agent none
  stages {
    stage('Build Jar') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v $PWD/.m2:/root/.m2'
        }
      }
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
    stage('Build Image') {
      steps {
        script {
          app = docker.build("shubh4321/selenium-docker")
        }
      }
    }
    stage('Push Image') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
          sh "docker login --username=${user} --password=${pass}"
          sh "docker push shubh4321/selenium-docker:latest"
        }
      }
    }
  }
}