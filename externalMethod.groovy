import com.tikal.jenkins.plugins.multijob.*
import hudson.*
import hudson.model.*
import hudson.plugins.git.*
import hudson.slaves.*
import hudson.tasks.*

// def myVar = build.getEnvironment(listener).get('myVar')

// Methods in this file will end up as object methods on the object that load returns.
def lookAtThis(String whoAreYou) {
   echo "Look at this, ${whoAreYou}! You loaded this from another file!"
}

def getLastSuccessfulCommitId(jobUrl) {
    def apiUrl = "$jobUrl/lastSuccessfulBuild/api/json?tree=actions[lastBuiltRevision[SHA1]]&depth=3"
    println("apiUrl: $apiUrl")

    def getResp = httpRequest httpMode: 'GET', url: apiUrl
    if (getResp.status != 200) {
        error ("ERROR: Could not find last successful job")
    }

    def result = getResp.content
    println("Response: $result")
    def shaBegin = result.indexOf('SHA1":"')+7
    def shaEnd = result.indexOf('"', shaBegin)
    println("shaBegin, shaEnd: $shaBegin, $shaEnd")
    shaCommitId = result.substring(shaBegin, shaEnd) 
    // println (shaCommitId) 
    return shaCommitId
}

return this;