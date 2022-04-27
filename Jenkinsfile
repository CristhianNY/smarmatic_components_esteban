pipeline {
  agent {
    label 'mobile'
  }
  
  parameters {
    choice(name: 'BUILD_TYPE',
      choices:['Debug', 'Release'],
      description: 'Type of build, ***Required***')
  }

  stages {
    stage('Compile') {
      steps {
        sh 'echo "Compiling library..."'
        sh 'chmod u+x gradlew'
        sh './gradlew compile${BUILD_TYPE}Sources'
      }
    }
    
    stage('Build') {
      steps {
        sh 'echo "Building library..."'
        sh './gradlew assemble${BUILD_TYPE}'
      }
    }

    stage('Local publish') {
      steps {
        sh './gradlew publish'
      }
    }
    
    stage('Publish to Artifactory') {
      steps {
        sh 'echo "Publishing library..."'
        rtUpload (
          serverId: "artifactory-proxmox",
          spec:
            """{
              "files": [
                {
                  "pattern": "smarteco-components/build/repo/**/*",
                  "target": "mobile-gradle-develop-local"
                }
              ]
            }"""
        )
      }
    }
  }
}
