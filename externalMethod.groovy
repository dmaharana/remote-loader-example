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

def getLastSuccessfulCommitId() {
   def build = this.getProperty('binding').getVariable('build')
   def lastSuccesfulBuild = build.previousNotFailedBuild
   def failed = build.result != hudson.model.Result.SUCCESS

   println "Last Succesful Build: ${lastSuccesfulBuild}"
   println "Current Build Result, is failed?: ${failed}"

}

return this;