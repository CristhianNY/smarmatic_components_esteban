pipeline {
  agent {
    label 'mobile'
  }

  stages {
    stage('Compile') {
      steps {
        sh 'echo "Compiling library..."'
        sh 'chmod u+x gradlew'
        sh './gradlew compileDebugSources'
      }
    }
    
    stage('Build') {
      steps {
        sh 'echo "Building library..."'
        sh './gradlew assembleDebug'
      }
    }
    
    stage('Publish') {
      steps {
        sh 'echo "Publishing library..."'
        rtUpload (
          serverId: "artifactory-proxmox",
          spec:
            """{
              "files": [
                {
                  "pattern": "*.aar",
                  "target": "mobile-gradle-develop-local"
                }
              ]
            }"""
        )
      }
    }
  }
}
