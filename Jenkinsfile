pipeline {
    agent any

    environment {
        DB_PASSWORD = credentials('DB_PASSWORD_SECRET')
    }

    parameters {
        choice(
            name: 'CHOICE_IP',
            choices: ['192.168.1.186', '192.168.1.136'],
            description: 'Chọn IP từ danh sách (hoặc để trống nếu muốn nhập IP thủ công)'
        )
        string(
            name: 'CUSTOM_IP',
            defaultValue: '',
            description: 'Nhập IP nếu không dùng danh sách trên (để trống nếu đã chọn ở trên)'
        )
    }

    stages {
        stage('Chọn IP') {
            steps {
                script {
                    if (params.CUSTOM_IP?.trim()) {
                        env.TARGET_IP = params.CUSTOM_IP.trim()
                    } else {
                        env.TARGET_IP = params.CHOICE_IP
                    }
                    echo "Sử dụng IP: ${env.TARGET_IP}"
                }
            }
        }

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
                sh "scp target/aws-demo-0.0.1-SNAPSHOT.jar vm1@${env.TARGET_IP}:/home/vm1/aws-demo.jar"
            }
        }

        stage('Restart remote service') {
            steps {
                sshagent(['jenkins-ssh-key']) {
                    sh """
                        ssh vm1@${env.TARGET_IP} <<EOF
                        echo "Restarting aws-demo.service ..."
                        sudo systemctl restart aws-demo.service
                        echo "Service restarted."
EOF
                    """
                }
            }
        }

        stage('Health Check') {
            steps {
                sshagent(['jenkins-ssh-key']) {
                    script {
                        echo "Chờ 10 giây cho service khởi động..."
                        sleep time: 10, unit: 'SECONDS'

                        echo "Thực hiện kiểm tra sức khỏe..."
                        def health = sh(
                            script: """
                                ssh vm1@${env.TARGET_IP} \\
                                'curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/actuator/health'
                            """,
                            returnStdout: true
                        ).trim()

                        if (health != "200") {
                            error "⚠️ Health check thất bại! Service trả về mã HTTP: ${health}"
                        } else {
                            echo "✅ Health check thành công!"
                        }
                    }
                }
            }
        }
    }
}
