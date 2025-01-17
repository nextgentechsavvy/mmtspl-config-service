pipeline{
    agent any
    tools {
        maven 'maven3.6.3'
    }

    stages{
        stage('Build maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'd8a7d834-0955-4bfe-a691-25bbca4ab26b', url: 'https://nextgentechsavvy@github.com/nextgentechsavvy/mmtspl-config-service.git']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                         // Docker image name ::  mmtspl-employee-service
                         bat 'docker build -t mmtspl-config-service-1.0.0-snapshot .'
            }
        }
        stage('Login to DockerHub'){
            steps{
                    withCredentials([string(credentialsId: 'nextgentechsavvy-docker-hub-pwd', variable: 'nextgentechsavvy-docker-hub-pwd')]) {
                        bat 'type nextgentechsavvy-docker-hub-token.txt | docker login --username nextgentechsavvy --password-stdin'
                    //withCredentials([string(credentialsId: 'mmtspldockerhub-pwd', variable: 'mmtspldockerhub-pwd')]) {                        //C:\Users\mmser\.jenkins\workspace\devops-integration\password.txt
                        //bat 'type mmtspl-docker-hub-token.txt | docker login --username mmtspldockerhub --password-stdin'

                        //bat 'docker login --username mmtspldockerhub --password ${dockerhubpwd}'
                    }
            }
        }
        stage('Tag docker image to the DockerHub image'){
            steps{
                    // docker image tag SOURCE_IMAGE[:TAG] TARGET_IMAGE[:TAG]
                    // docker image tag <image_name>:<tag_name>  <repository_name>/<new_image_name>:<tag_name>
                    bat 'docker image tag mmtspl-config-service-1.0.0-snapshot:latest nextgentechsavvy/mmtspl-config-service-1.0.0-snapshot:latest-hub-image'
                    //bat 'docker image tag mmtspl-employee-service-1.0.0-snapshot:latest mmtspldockerhub/mmtspl-employee-service-1.0.0-snapshot:latest-hub-image'
            }
        }
        stage('Push docker hub image to the DockerHub'){
            steps{
                    // docker push <repository_name>/<new_image_name>:<tag_name>
                    bat 'docker push nextgentechsavvy/mmtspl-config-service-1.0.0-snapshot:latest-hub-image'
                    //bat 'docker push mmtspldockerhub/mmtspl-employee-service-1.0.0-snapshot:latest-hub-image'
            }
        }

        stage('Deploy to k8s'){
            steps{
                    bat 'kubectl apply -f deploymentservice.yaml'
            }
        }


    }
}