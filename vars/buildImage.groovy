#!/usr/bin/env groovy

def call(){
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'af5367d3-fa1c-4d74-8d24-89f3e39aa3c8', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]){
        sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
        sh 'docker build -t ankitraz/myapp:ank-1.0 .'
        sh 'docker push ankitraz/myapp:ank-1.0'
    }
}