pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                    git branch: 'khaled',
                        url : 'https://github.com/louatisahar/DevOps',
                        credentialsId: '14d06552-df58-407d-bd31-71164c94aae9';
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
       
             
           stage('Nexus') {
             
             
            steps {
               
                script {

                        sh 'mvn deploy'
		}
               
            }
        }
             
        stage('Code Quality Check via SonarQube') {
             
             
            steps {
               
                script {

                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin.'
}
               
            }
        }
        
             
    }