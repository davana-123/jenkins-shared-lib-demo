def call(String imageName = "demo-image:latest") {
    pipeline {
        agent any

        stages {
            stage('Build Container') {
                steps {
                    echo "Building container image with Podman..."
                    sh """
                    podman build -t ${imageName} .
                    """
                }
            }

            stage('Run Container') {
                steps {
                    echo "Running container with Podman..."
                    sh """
                    podman rm -f demo-container || true
                    podman run -d --name demo-container -p 8080:8080 ${imageName}
                    """
                }
            }
        }

        post {
            success {
                echo "Deploy pipeline completed successfully."
            }
            failure {
                echo "Deploy pipeline failed."
            }
        }
    }
}
