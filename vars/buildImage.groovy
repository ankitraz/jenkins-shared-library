#!/usr/bin/env groovy

def call(String imageName){
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-id-pass', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]){
        sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
        sh "docker build -t $imageName ."
        sh "docker push $imageName"
    }
}