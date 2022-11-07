pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
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
       
             
             
        stage('Code Quality Check via SonarQube') {
             
             
            steps {
               
                script {

                        sh  'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.css.node=. -Dsonar.java.binaries=. -Dsonar.host.url=http://172.10.0.140:9000/ -Dsonar.login=admin   -Dsonar.password=admina'

 
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