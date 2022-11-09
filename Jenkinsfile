pipeline {
    agent any

    stages {
       
        stage('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                    git branch: 'Ahmed',
                        url : 'https://github.com/louatisahar/DevOps',
                        credentialsId: 'Ahmed_Personal_Git_Repo_Private';
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

                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=ahmed'
}
               
            }
        }
       
     stage ('TEST') {
             steps {
            sh 'mvn test -Dtest="SecteurActiviteServiceImplMock" '
        	}
        }
        }

    }
