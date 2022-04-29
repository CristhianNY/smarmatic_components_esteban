pipeline {
  agent {
    label 'testing'
  }
  
  parameters {
    choice(name: 'BUILD_TYPE',
      choices: ['Release', 'Debug'],
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
        sh './gradlew publish'
        ws("${WORKSPACE}/smarteco-components/build/repo") {
          rtUpload (
            serverId: "Artifactory",
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

    stage('Create tag') {
      steps {
        sh '''
          VERSION_NUMBER=$(cat smarteco-components/build.gradle | grep -m 1 lib_version | awk -F "'" '{print $2}')
          echo "\$VERSION_NUMBER"
          git tag -a smarteco-components-$VERSION_NUMBER -m "Tag created by user jenkins - smarteco-components-\$VERSION_NUMBER"
          git push origin smarteco-components-$VERSION_NUMBER
        '''
      }
    }
  }
}
