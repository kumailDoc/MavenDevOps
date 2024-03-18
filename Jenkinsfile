pipeline {
    agent any
    tools {
        maven "MAVEN"
    }
    environment {
        DOCKERHUB_PWD = credentials('credentialsID_dockerHub')
    }
    stages {
        stage('Build Maven') {
            steps {
                script {
                    checkout([$class: 'GitSCM',
                        branches: [[name: '*/main']],
                        userRemoteConfigs: [[url: 'https://github.com/kumailDoc/MavenDevOps.git']]])
                    echo "docker Hub Password: ${DOCKERHUB_PWD}"
                    bat 'mvn clean install jacoco:prepare-agent jacoco:report'
                    jacoco(execPattern: '**/target/jacoco.exec')
                    publishHTML(reportDir: 'target/site/jacoco', reportFiles: 'index.html', reportName: 'JaCoco Code Coverage Report', keepAll: true)
                }
            }
        }
        
        stage('Docker Login') {
            steps {
                script {
                    bat "docker login -u dkumail@my.centennialcollege.ca -p ${DOCKERHUB_PWD} https://index.docker.io/v1/"
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t kumailDoc/mavenprojectdevops .'
                }
            }
        }
    }
}
