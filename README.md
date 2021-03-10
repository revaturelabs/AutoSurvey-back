# AutoSurvey-back


## Project Description  
> Revature's Center of Excellence needed an automated way to handle transforming weekly QC Survey Data from Google Sheets (.csv files) into a persitent RDBMS for managing their system migration process from GSuites to Microsoft Teams.   
> 
> Together with our entire batch, we designed, built, and tested the Auto Survey App - a cloud hosted application through which internal Revature employees can access aggregated data from the weekly QC Surveys submitted by Revature Associates.    
> Using the ETL Process, we extracted and transformed data from a flat .csv file and loaded it into a remote Relational Database.
> Secondly, we built an interactive web application to persist new data and provide users with the ability to visualize the existing data.  


## Technologies Used  
Java, Spring Boot, PostgreSQL, Talend, Spring Test, JUnit, Selenium, Cucumber, Jenkins, AWS RDS, AWS EC2, JavaScript, AJAX, Chart.JS, JQuery, HTML, CSS, Bootstrap   


## Features
-  Internal Revature Employees can:  
    -  Log in  
    -  Upload a .csv file of survey data to be persisted to the Database  
    -  View overall analyses of all batches for all time  
    -  View analyses of all batches by week  
- Administrators have the ability to register an internal employee to have access to the QC Survey Data Analysis Page    
- Revature Associates can submit weekly QC Surveys  


## Further Development  
- Structure to be able to view aggregated survey data for an individual batch by week has been created, but not yet implemented.  
- Automate the Registration process by implementing Spring Boot Mail (like Spring Web for SMTP) to send registration links via email.  
- Add more or varied visualizations to the Analysis Page.  

## Required Dependencies  
- Spring Data JPA  
- Spring MVC  
- Spring Test  
- PostgreSQL Driver  
- GSON  
- Selenium  
- Cucumber  
- chart.js (JavaScript)  

#### Insert into pom.xml the below dependencies:  

```
<dependencies>
		<dependency>
			<groupId>com.oracle.ojdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<version>19.3.0.0</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>4.0.1</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.6</version>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.2.18</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.8.1</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<version>2.4.3</version>
		</dependency>

		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-chrome-driver</artifactId>
			<version>3.8.1</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>1.2.4</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>1.2.4</version>
		</dependency>
	</dependencies>
```

## Contributors

## Links to all associated Repositories:
[Auto Survey Front End](https://github.com/revaturelabs/AutoSurvey-front)  
[Auto Survey Back End](https://github.com/revaturelabs/AutoSurvey-back)  
[Auto Survey ETL Work](https://github.com/revaturelabs/AutoSurvey-jobs)  

