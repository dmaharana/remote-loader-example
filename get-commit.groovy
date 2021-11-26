node('master') {
    lastShaId = get_commit_id()
    println (lastShaId) 
}

def get_commit_id() {
    def jobUrl = "$env.JOB_URL/api/json?tree=actions[lastBuiltRevision[SHA1]]&depth=3"
    // def jobUrl = "http://localhost:8080/job/Test/job/remote-loader-example/lastSuccessfulBuild/api/json?tree=actions[lastBuiltRevision[SHA1]]&depth=3"

    def getResp = httpRequest httpMode: 'GET', url: jobUrl
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
