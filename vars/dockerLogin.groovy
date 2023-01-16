#!/usr/bin/env groovy
import com.example.Docker
def call(){
    withCredentials([usernamePassword(credentialsId: 'dockerhub-id-pass', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
    }
}