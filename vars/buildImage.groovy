#!/usr/bin/env groovy

def call(){
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'gitlab-id-pass', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]){
        sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
        sh 'docker build -t ankitraz/myapp:ank-1.0 .'
        sh 'docker push ankitraz/myapp:ank-1.0'
    }
}