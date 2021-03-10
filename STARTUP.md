# Getting Started - AutoSurvey
1. Download & Setup Source Code
2. Local Project
3. AWS/EC2 Project

# Download & Setup Source Code

## Finding the AutoSurvey Project
Find the main branch of the *AutoSurvey* repository hosted on the Revature Labs organization page, located [here](https://github.com/revaturelabs/AutoSurvey-back).

### Downloading the project
> Clicking on 'Code' on the upper-right hand of the **GitHub** project and clicking *Download ZIP*.

***OR***

### Cloning the repository
> Using Git in your preferred local directory, use the following command to clone the project onto your machine:
> 
``git clone https://github.com/revaturelabs/AutoSurvey-back.git``

## Establishing Application Properties

In order for your application to communicate with your RDS, you must first create an `application.properties` file under the *src/main/resources* directory. **This file will contain sensitive data about connecting to your RDS, so ensure that it is never pushed or uploaded. Verify that your `.gitignore` file is actively ignoring this file if you are using GitHub or similar version control.**

Your `application.properties` file will follow the following format:
```
spring.datasource.driver-class-name=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=
```
Fill in the credentials to your RDS as necessary. The `driver-class-name` value will be the driver specific to the engine running on the RDS (*PostgreSQL, Oracle, Amazon Aurora, etc*). The `jpa.hibernate.ddl-auto` value will depend on how you would like the project to manipulate the database schema on startup. Typically, if you have an RDS set up with the schema that matches the project already, this value should be set to *validate*.

# Local Project

### Prerequisites
> [Apache Tomcat](https://tomcat.apache.org/download-90.cgi)
>
> [Eclipse for Java EE Developers (IDE)](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers)


## Running the Project

- Right click on your project.
- Click *Run on Server..."
	- Configure your project to specifically use Tomcat to host the application

- Tomcat will host the project on your local machine, and the project will run at the url: http://localhost:8080/AutoSurvey/


# AWS/EC2 Project

### Prerequisites
You will need to make these installations on the EC2 after your intial setup by connecting via SSH.
> [Install Apache Maven & Java 11](https://docs.aws.amazon.com/neptune/latest/userguide/iam-auth-connect-prerq.html)
> 
> [Install Git](https://cloudaffaire.com/how-to-install-git-in-aws-ec2-instance/)
> 
> [Install Jenkins](https://www.jenkins.io/doc/tutorials/tutorial-for-installing-jenkins-on-AWS/)

## Running the Project

- Direct to Jenkins, found at [http://[your-ec2-url].amazonaws.com:8080/jenkins](https://aws.amazon.com/)
	- Create a new Jenkins job for your project
- Click *Configure* > *General* > Check *GitHub Project* > and provide your repository URL.
- Scroll down to **Source Code Management** and check *Git*
	- Provide your repository URL again.
	- Specify the branch to build
		- If on main branch, specify `*/main`
- Scroll down to **Build** and add the following two *Build Steps*:
	1. Invoke top-level Maven targets
	
		 ``-DskipTests clean package``
		 
	2. Execute Shell
		```
		rm -f /.../opt/tomcat/apache-tomcat-9.0.41/webapps/AutoSurvey.war
		rm -rf /.../opt/tomcat/apache-tomcat-9.0.41/webapps/AutoSurvey
		cp -f /.../.jenkins/workspace/AutoSurvey/target/AutoSurvey.war /opt/tomcat/apache-tomcat-9.0.41/webapps/AutoSurvey.war
		```
		- ***Your shell commands will need to change according to the location of your Tomcat and Jenkins directories***
		- These shell commands will be removing any existing AutoSurvey.war file, removing the unpacked war file (*none if this is the project's first build*), and copying the new build from the jenkins workspace to the Tomcat webapps folder, respectively.
		
- Tomcat will now host your project on your EC2, and the project will run at the url:
[http://[your-ec2-url].amazonaws.com:8080/AutoSurvey/](https://aws.amazon.com/)
