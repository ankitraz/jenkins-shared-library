#!/usr/bin/env groovy

def call(){
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: '3288a708-e4b2-4491-9842-314fb3a5b3f9', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]){
        sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
        sh 'docker build -t ankitraz/myapp:ank-1.0 .'
        sh 'docker push ankitraz/myapp:ank-1.0'
    }
}