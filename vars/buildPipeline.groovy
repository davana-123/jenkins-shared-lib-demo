def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    echo "Checking out source code..."
                    checkout scm
                }
            }

            stage('Build') {
                steps {
                    echo "Simulating build step..."
                    sh 'echo "Build step: compiling code (dummy)"'
                }
            }

            stage('Test') {
                steps {
                    echo "Running tests..."
                    sh 'echo "Test step: running tests (dummy)"'
                }
            }

            stage('Package') {
                steps {
                    echo "Packaging application..."
                    sh 'echo "Package step: creating artifact (dummy)"'
                }
            }
        }

        post {
            success {
                echo "Build pipeline completed successfully."
            }
            failure {
                echo "Build pipeline failed."
            }
        }
    }
}
