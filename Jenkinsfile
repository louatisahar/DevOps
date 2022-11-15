pipeline {
    agent any
    
    environment {
    		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    		}

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                    git branch: 'hamza',
                        url : 'https://github.com/louatisahar/DevOps',
                        credentialsId: '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';
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
        	sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        	}
        }
        
   
        
       
        
        stage ('Docker push'){
        	steps {
        	sh 'docker push khaledkhm/achatback:latest'
        	}
        }
        
        stage('docker compose ') {
              steps {
                  sh "docker compose -f docker-compose.yml up -d  "
              }
        }
        
       /* stage("Send Email"){
           steps{
               emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'khmthe@gmail.com'
               emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'kridhamzaa@gmail.com'
           }
       }*/
        
     
      }
      
      post {
      	always {
      		sh 'docker logout'
      		emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'khmthe@gmail.com'
      		emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'kridhamzaa@gmail.com'
          	emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
  		//
      	}
      }
}
