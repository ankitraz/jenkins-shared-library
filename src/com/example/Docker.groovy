#!/usr/bin/env groovy
package com.example

class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-id-pass', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            script.sh "docker login -u $script.DOCKER_USER -p $script.DOCKER_PASS"
            script.sh "docker build -t $imageName ."
            script.sh "docker push $imageName"
        }
    }
}
