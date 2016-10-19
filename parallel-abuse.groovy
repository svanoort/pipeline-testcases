// Pipeline script that will exhibit painful behavior if you handle parallels inefficiently
// Or don't ensure we only visit each node once when iterating.  Generates ~1100 nodes.
// If we don't avoid visiting nodes multiple times, walking through this will require ~20*150*20*3*3 visits = ~540000
stage 'before'
for (int i=0; i<150; i++) {
    echo "running the $i step before parallel here"
}

int branchCount = 20;
int branchSteps = 10; 

def branches = [:]
for (int i=0; i<branchCount; i++) {
    branches["branch-$i"] = {
        for (int j=0; j<branchSteps; j++) {
            echo "Running branch $i step $j here"   
        }
        parallel 'anotherbranch': {echo 'nested parallel'}, 'more':{echo 'nested parallel'}, 'andmore': {echo 'nested parallel'}
    }
}
parallel branches
parallel branches

stage 'canfail'
//checkpoint 'before-fail'  // Comment back in to test checkpoint restore
if (true) {
    error("Random failure")
} else {
    echo 'random pass'
}

stage 'after'
for (int i=0; i<30; i++) {
    echo "running the $i step here"
}