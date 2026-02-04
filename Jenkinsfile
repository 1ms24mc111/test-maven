pipeline
{
	agent any
	tools {
        jdk 'JDK17'   
        maven 'maven' 
    }
	environment
	{
		DOCKER_CRED=credentials('dockerhub')
		IMG_NAME=('vivek5041/maven-app')
	}
	stages
	{
		stage('Checkout')
		{
			steps
			{

				git (url:'https://github.com/1ms24mc111/test-maven.git',branch:'main')
			}
		}
		stage('Maven Build')
		{
			steps
			{
				sh 'mvn clean package'
			}
		}
		stage('Build Docker')
		{
			steps{
			script{
				docker_img=docker.build("${IMG_NAME}:latest")
			}
		}
		}
		stage('Push Docker')
		{
			steps{
				script{
				docker.withRegistry('https://registry.hub.docker.com','dockerhubID'){
				docker_img.push()
			}
			}
			
			}
		}

	}
	post{
		success{
			echo "Success"
		}
		failure{
			echo "Failure"
		}
		always{
			echo "Cleaning up Workdir "
			deleteDir()
		}
	}
	
}
