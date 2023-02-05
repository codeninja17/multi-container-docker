pipeline {

  environment {
    GIT_BRANCH_NAME = "${sh(script:'echo ${GIT_BRANCH##*/}', returnStdout: true).trim()}"
  }
  agent any

  stages {
    stage('Deploy') {
     environment {
          GIT_COMMIT = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
     }
      steps {
        step([$class: "AWSEBDeploymentBuilder",
          credentialId: "aws",
          awsRegion: "us-east-1",
          applicationName: "coupon-service",
          environmentName: "Coupon-service-env",
          rootObject: ".",
          includes: "**/*",
          excludes: "",
          bucketName: "elasticbeanstalk-us-east-1-335298206423",
          keyPrefix: "docker",
          sleepTime: "10",
          checkHealth: "true",
          maxAttempts: "13",
          versionLabelFormat: "$GIT_COMMIT",
          versionDescriptionFormat: "$GIT_COMMIT",
        ])
      }
    }
  }
}
