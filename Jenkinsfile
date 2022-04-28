pipeline {
  agent {
    label 'mobile'
  }
  
  parameters {
    choice(name: 'BUILD_TYPE',
      choices:['Debug', 'Release'],
      description: 'Type of build')
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
    
    stage('Publish') {
      steps {
        sh 'echo "Publishing library..."'
        ws("${WORKSPACE}/smarteco-components/build/repo") {
          rtUpload (
            serverId: "artifactory-proxmox",
            spec:
              """{
                "files": [
                  {
                    "pattern": "*.aar",
                    "target": "mobile-gradle-develop-local/",
                    "flat": "false"
                  },
                  {
                    "pattern": "*.pom",
                    "target": "mobile-gradle-develop-local/",
                    "flat": "false"
                  }
                ]
              }"""
          )
        }
      }
    }
  }
}
