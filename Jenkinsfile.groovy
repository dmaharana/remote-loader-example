node('master') {
    cleanWs()
    sh 'git clone --depth 1 https://github.com/dmaharana/remote-loader-example.git .'
    
    // Load file from the current directory:
    def externalMethod = load("externalMethod.groovy")
    lastShaId = externalMethod.getLastSuccessfulCommitId(env.JOB_URL)
    println("Last Successful SHA1: $lastShaId")
    externalMethod.lookAtThis("Steve")

    def externalCall = load("externalCall.groovy")
    externalCall("Steve")
}