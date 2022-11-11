pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                    git branch: 'sahar',
                        url : 'https://github.com/louatisahar/DevOps',
                        credentialsId: 'd6ff7a98-2a40-49d0-b15b-408198b39b88';
            }
        }

        stage('Cleaning the project') {
             
             
            steps {
                echo 'cleaning project ...'
                sh 'mvn clean'
            }
        }
        
        stage('Compiling the artifact') {
             
            steps {
                echo "compiling"
                sh 'mvn compile'
               
            }
        } 
        stage('Code Quality Check via SonarQube') {
            steps {
                script {
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin.'
						}
               
            }
        }
        stage('Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }     
     stage ('Mockito/Junit') {
             steps {
            sh 'mvn test -Dtest="FactureServiceImplMock" '
            sh 'mvn test -Dtest="ReglementServiceImpTest" '
            }
        }
    }
}