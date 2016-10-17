// Basic case for benchmarking pipeline & its visualization
// Exercises basic FlowNode/log/action storage, stages, node use, and shell step
// Represents a midsized-to-large pipeline (~315ish nodes), maps well to more complexish builds for normal users
// Intended to be fairly fast to run (a few seconds) but load down some of the pipeline internals like a much larger pipeline

for (int i=0; i<15; i++) {
    stage "stage $i" 
    echo "ran my stage is $i"        
    node {
        echo 'whoami';
    }
}

// Run a basic shell step
stage 'shellscript'
node {
    sh 'whoami';
}

stage 'label based'
echo 'wait for executor'
node {
    stage 'things using node'
    for (int i=0; i<200; i++) {
        echo "we waited for this $i seconds"    
    }
}
