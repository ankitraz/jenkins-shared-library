#!/usr/bin/env groovy

def call(){
    def dockerCmd = 'docker run -d -p 8080:8080 ankitraz/myapp:1:0'
    sshagent(['ec2-server-key']){
        sh "ssh -o StrictHostkeyChecking=no ec2-user@43.204.211.220 ${dockerCmd}"
    }
}