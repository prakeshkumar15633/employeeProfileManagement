pipeline {
    agent any

    environment {
        // Uncomment below if pushing to DockerHub
        // DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials')
        DOCKER_IMAGE = "employeeprofilemanagement_image"
    }

    // Various stages in the Pipeline Process:
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/prakeshkumar15633/employeeProfileManagement.git'
            }
        }

        stage('Build') {
            steps {
                // Build docker image using Dockerfile
                bat "docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} -f Dockerfile ."
            }
        }

        stage('Run Container') {
            steps {
                script {
                    bat "docker run -d --add-host=host.docker.internal:host-gateway --name employeeprofilemanagement -p 8200:8200 ${DOCKER_IMAGE}:${BUILD_NUMBER}"
                }
            }
        }
    }

    post {
        success {
            echo "✅ Checkout, Build, Dockerize & Deploy completed successfully!"
        }
        failure {
            echo "❌ Build failed!"
        }
    }
}