pipeline{
    agent any

//      tools{
//         maven 'MAVEN'
//     }

    environment{
        PATH = "/opt/homebrew/bin:$PATH"
        DOCKER_IMAGE = 'chhajed7890/scientific_calculator:latest'
        CONTAINER_NAME = 'scientific_calculator'
        PORTS = '8080:80'
    }

    stages{
        stage('Clone Git'){
            steps{
//                 git 'https://github.com/chhajed-ajay/spe-project-calculator.git'
                   checkout scm
            }
        }

        stage('Build'){
            steps {
                sh "mvn clean package"
                // def jarFilePath = sh(returnStdout: true, script: 'find $WORKSPACE -name "*.jar"').trim()
        }
            }

        stage('Test'){
            steps{
                 dir('/Users/ajaychhajed/Desktop/spe-mini-project-calculator/spe-mini-project_calculator') {
                    /* execute commands in the scripts directory */
                    // sh "javac CalculatorTest.java"
                    // sh "java CalculatorTest"
                    // sh "javac -cp lib/junit-4.13.jar:lib/hamcrest-core-1.3.jar -d bin src/*.java test/*.java"
                    // sh "java -cp lib/junit-4.13.jar:lib/hamcrest-core-1.3.jar:bin org.junit.runner.JUnitCore CalculatorTest"
                    sh "mvn test"
                }

            }
        }
        stage('Containerize (Push to Dockerhub and pull from Dockerhub)') {
            steps {
                // sh "export PATH=$PATH:/usr/local/bin/docker"

                sh "/usr/local/bin/docker build -t chhajed7890/scientific_calculator ."
                withCredentials([usernamePassword(credentialsId: 'docker_hub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh '/usr/local/bin/docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
//                     sh '/usr/local/bin/docker tag scientific_calculator chhajed7890/scientific_calculator:latest'
                    sh '/usr/local/bin/docker push chhajed7890/scientific_calculator'
                }
//                 sh '/usr/local/bin/docker pull chhajed7890/scientific_calculator'

            }
        }
        stage('Ansible Deployment') {
            steps {
                script {
                    sh 'ansible-playbook -i inventory deploy.yml'
                }
            }
        }
    }
}