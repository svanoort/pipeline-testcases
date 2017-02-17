
# pipeline-testcases

Sample testcases for Jenkins pipelines

## Notes

When creating a stage, the use of parenthesis around the stage name, and curly braces around its body, as shown below,
is the *proper* way. Doing so without is  deprecated, and you'll see this message in your console log:

Using the ‘stage’ step without a block argument is deprecated

The deprecated way of writing this stage would look like this:

    stage "myFancyStageName"
    echo "I just did something awesome."
    node {
        sh 'whoami'
    }

Same stage, written the new way:

    stage ('myFancyStageName') {
        echo "I just did something awesome."
        node {
            sh 'whoami'
        }
    }