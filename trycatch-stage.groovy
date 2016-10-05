// Wacky case where you do a try-catch on a stage itself and not on its contents
try {
    stage('first') {
        error('Fail')    
    }
} catch (Exception ex) {
    
}

stage('second') {
    try {
        error('fail')
    } catch (Exception ex) {
        echo 'swallowed exception'
    }
}