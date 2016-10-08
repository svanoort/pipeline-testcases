// Tests visualizations of various in-progress and completed parallel cases, for timing and status

// Should show a pause for input, and timing reflecting the longest running (middle) branch
stage 'first'
parallel 'branch1' : {
        echo 'succeed'
    }, 'branch2-pause':{ 
        sleep 5; 
        input 'continue?'; 
    }, 'branch3': { 
        echo 'succeed-final';
} 

// Should show in-progress for 10 seconds and timing reflecting the longest branch
stage 'second'
parallel 'branch1' : {
        echo 'succeed'
    }, 'branch2':{ 
        sleep 10; 
    }, 'branch3': { 
        echo 'succeed-final';
}