
node {
 def flavorCombination='ccc33c3'

 stage 'checkout'
  checkout scm


 stage 'lint'
  try {
   sh "./gradlew lint${flavorCombination}Release"
  } catch(err) {
   currentBuild.result = FAILURE
  } finally {
   androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '', unHealthy: ''
  }

 stage 'test'
  try {
   sh "./gradlew test${flavorCombination}DebugUnitTest"
  } catch(err) {
   currentBuild.result = FAILURE
  } finally {
   step([$class: 'JUnitResultArchiver', testResults: 'app/build/test-results/*/*.xml'])
   publishHTML(target:[allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'app/build/reports/tests/', reportFiles: "*/*/index.html", reportName: 'UnitTest'])
  }
  
 stage 'assemble'
  sh "./gradlew assemble${flavorCombination}Release"
  archive 'app/build/outputs/apk/*'
  archive 'app/build/outputs/mapping/*/release/mapping.txt'
     
}