def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub ', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                    sh 'sudo docker build -t devopstrainer/myrepoprivate:$BUILD_NUMBER .'
                    sh 'echo $PASS | sudo docker login -u $USER --password-stdin'
                    sh 'sudo docker push devopstrainer/myrepoprivate:$BUILD_NUMBER'
} 
}
def deployApp() {
    echo 'deploying the application...'
} 

return this
