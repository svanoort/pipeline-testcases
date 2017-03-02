// This is identical to benchmark-base.groovy, but with done
// notable exception. I'm using the stage step without a block
// argument. This was shown to be the root cause of JENKINS-42026.

// Adding timestamps to the entire thing.
timestamps {

for (int i=0; i<15; i++) {

    stage "Looping Stages $i" 
        echo "My stage number is $i"        
        node {
            sh 'vmstat'
        }
    
}

// Run a basic shell step
stage "Another shell script" 
    node {
        // Are we on something unix-y?
        if (isUnix()) {
            echo "Linux or other UNIX-y system detected."
            sh 'vmstat'
        }
        // if not, we must be on windows.
        else {
            echo 'Windows system detected.'
            bat "dir /ad"
        }
    }


stage "Label-based" 
    node {
        stage ('Things using node') {
            for (int i=0; i<20; i++) {
                echo "We have done this $i times."    
            }
        }
    }


}