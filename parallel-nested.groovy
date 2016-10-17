// Demonstrates a nested parallel case here
echo 'first'

stage 'nested parallel'
def steps = [:]
steps['1'] = {
    echo 'do 1 stuff'
}

steps['2'] = {
    echo '2a'
    def nested = [:]
    nested['2-1'] = {
        echo 'do 2-1'
    } 
    nested['2-2'] = {
        sleep 1
        echo '2 section 2'
    }
    echo '2b'
    parallel nested
}
parallel steps

stage 'final'
echo 'final'
error("Fail here")

stage 'never runs'
echo 'This should not execute because we threw an error"