pipeline{
    agent none

    stages{
        stage("build jars"){
            agent{
                docker {
                    image 'maven:3.9.3-eclipse-temurin-17-focal'
                    args '-u root -v //tmp/m2:/root/.m2'
                }
            }
            steps{
                sh "mvn clean package -DskipTests"
            }
        }
        stage("build image"){
            steps{
                script {
                        app = docker.build('sid0701/java-selenium-cucumber-docker-1')
                }
            }
        }
        stage("push image"){
            steps{
                script {
                docker.withRegistry('','mydocker-credentials') {
                    app.push("latest")
                }
            }    
            }
        }
        }
}