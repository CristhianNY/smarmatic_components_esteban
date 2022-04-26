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
  }
}
