node('master') {
    cleanWs()
    sh 'git clone https://github.com/dmaharana/remote-loader-example.git .'
    
    // Load file from the current directory:
    def externalMethod = load("externalMethod.groovy")
    externalMethod.getLastSuccessfulCommitId()
    externalMethod.lookAtThis("Steve")

    def externalCall = load("externalCall.groovy")
    externalCall("Steve")
}