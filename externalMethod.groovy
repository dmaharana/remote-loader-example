// def myVar = build.getEnvironment(listener).get('myVar')

// Methods in this file will end up as object methods on the object that load returns.
def lookAtThis(String whoAreYou) {
   echo "Look at this, ${whoAreYou}! You loaded this from another file!"
}

def getLastSuccessfulCommitId() {
    def lastSuccesfulBuild = build.previousNotFailedBuild
    def failed = build.result != hudson.model.Result.SUCCESS

    println "Last Succesful Build: ${lastSuccesfulBuild}"
    println "Current Build Result, is failed?: ${failed}"

}

return this;