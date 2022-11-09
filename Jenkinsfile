pipeline {
    agent any
    
    environment {
    		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    		}

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
       
/*                stage('Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }             
  */           
        stage('Code Quality Check via SonarQube') {
            steps {
                script {
                       sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin.'
                }
               
            }
        }
        
        stage ('Mockito/Junit') {
             steps {
            sh 'mvn test -Dtest="SecteurActiviteServiceImplMock" '
            sh 'mvn test -Dtest="FournisseurServiceImplTest" '
            }
        }
        
         stage ('Docker build') {
             steps {
            sh 'docker build -t khaledkhm/achatback:latest .'
            }
        }
        
        stage ('Docker login'){
        	steps {
        	sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS USR --password-stdin'
        	}
        }
        
        stage ('Docker push'){
        	steps {
        	sh 'docker push khaledkhm/achatback:latest'
        	}
        }
        
     
      }
      
      post {
      	always {
      		sh 'docker logout'
      	}
      }
}
