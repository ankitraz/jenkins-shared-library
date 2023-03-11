# Jenkins Shared Library for Docker Image Build and Deployment
This is a Jenkins Shared Library containing functions to build and deploy Docker images. The library includes the following Groovy scripts:

* `buildImage.groovy`: Builds a Docker image with the specified image name.
* `buildJar.groovy`: Builds a JAR file from the source code.
* `deploytoec2.groovy`: Deploys the Docker image to an EC2 instance.
* `dockerLogin.groovy`: Logs in to Docker Hub.
* `dockerPush.groovy`: Pushes the Docker image to Docker Hub.
## Usage
To use this shared library in your Jenkins pipeline, you can import it at the beginning of your pipeline script:

```groovy

@Library('my-shared-library') _
// You can then call the functions in your pipeline script. 
// For example:

node {
    stage('Build Image') {
        docker.buildImage('my-image')
    }

    stage('Push Image to Docker Hub') {
        docker.dockerLogin()
        docker.dockerPush('my-image')
    }

    stage('Deploy to EC2') {
        docker.deploytoec2('my-image', 'my-ec2-instance')
    }
}
```
You will need to provide the appropriate credentials and parameters for the functions to work correctly. The `deploytoec2` function requires an SSH key to connect to the EC2 instance.

## License
This shared library is licensed under the MIT License.
