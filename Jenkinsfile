pipeline {
    agent any
	environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerHub')
    }
    stages {
       
        stage('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                    git branch: 'Ahmed',
                        url : 'https://github.com/louatisahar/DevOps',
                        credentialsId: 'Ahmed_Personal_Git_Repo_Private';
            }
        }

		stage('database connection') {
            steps{
                sh '''
                sudo docker stop mysql || true
                sudo docker restart mysql || true
                '''
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
        
        stage('clean and package') {
            
            steps {
                sh 'mvn clean package'  
            }
     
         }
       
         //stage('Nexus') {
             
             
            //steps {
                //script {

                        //sh 'mvn deploy'
				//}
               
            //}
        //} 
          
        //stage('Code Quality Check via SonarQube') {
             
            //steps {
               
                //script {
					//sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=ahmed'
//}
               
           //}
        //}
        
        
        
      
        stage("Docker Image") {
        	steps{
           		sh ' docker build -t $DOCKERHUB_CREDENTIALS_USR/tpAchatProject-1.0:latest .'
        	}
        }
        stage ('Docker login'){
        	steps {
					sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'        
				}
        }
	   stage("Push to DockerHub") {
                steps{
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/tpAchatProject-1.0:latest'
                }
        }
        stage('Sending email'){
	           steps {
		            mail bcc: '', body: '''Hello from Jenkins,
		            Devops Pipeline returned success.
		            Best Regards''', cc: '', from: 'ahmedla9lou9@gmail.com', replyTo: '', subject: 'Devops Pipeline', to: 'bannour.ahmed@esprit.tn'
	            }
	       }
        
       stage('Run app With DockerCompose') {
              steps {
                  sh "docker-compose -f docker-compose.yml up -d  "
              }
          }
      

    }
    }
    