pipeline{
    
    tools{
        jdk 'myjava'
        maven 'mymaven'
    }
    agent any
    stages{
     stage('Checkout'){
         steps{
             git 'https://github.com/devops-trainer/DevOpsClassCodes.git'
         }
     }
     stage('Compile'){
         steps{
             sh 'mvn compile'
         }
     }
     stage('Codereview'){
         steps{
             sh 'mvn pmd:pmd'
         }
     }
     stage('UnitTest'){
         steps{
             sh 'mvn test'
         }
         post{
             always{
                 junit 'target/surefire-reports/*.xml'
             }
         }
     }
     stage('MetricCheck'){
         steps{
             sh 'mvn cobertura:cobertura -Dcobertura.report.format=xml'
         }
     }
     stage('Package'){
         steps{
             sh 'mvn package'
         }
     }
    }        
    
    
}
