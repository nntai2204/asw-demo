pipeline {
    agent any

    stages {
        stage('Checkout code') {
            steps {
                git branch: 'main', url: 'git@github.com:nntai2204/asw-demo.git'
            }
        }

        stage('Build project') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Copy .jar to remote') {
            steps {
                sh 'scp target/aws-demo-0.0.1-SNAPSHOT.jar vm1@192.168.1.186:/home/vm1/aws-demo.jar'
            }
        }

        stage('Restart remote server') {
            steps {
                sshagent(['jenkins-ssh-key']) {
                    sh '''
                        ssh vm1@192.168.1.186 <<EOF
                        echo "=== Killing old process..."
                        pkill -f aws-demo.jar || true

                        echo "=== Starting new process..."
                        nohup java -jar /home/vm1/aws-demo.jar > /home/vm1/aws-demo.log 2>&1 &
                        echo "=== Process started ==="
EOF
                    '''
                }
            }
        }
    }
}
