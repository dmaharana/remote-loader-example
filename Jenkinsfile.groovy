node('master') {
    cleanWs()
    sh 'git clone --depth 1 https://github.com/dmaharana/remote-loader-example.git .'
    
    // Load file from the current directory:
    def externalMethod = load("externalMethod.groovy")
    externalMethod.getLastSuccessfulCommitId()
    externalMethod.lookAtThis("Steve")

    def externalCall = load("externalCall.groovy")
    externalCall("Steve")
}