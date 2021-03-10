# AutoSurvey-back


## Project Description  
> The Center of Excellence (CoE) was migrating from GSuites to Microsoft Teams and needed a web application to handle transforming weekly QC Survey Data from Google Sheets (.csv files) into a persitent RDBMS.  
> The QC Data Survey Application is just that - a cloud hosted application through which internal Revature employees can access the aggregated data from QC Surveys, and Revature Associates can submit weekly surveys. Together with our entire batch, we designed, built, and tested the Auto Survey App. 


## Technologies Used  
Java, Spring Boot, PostgreSQL, Talend, Spring Test, JUnit, Selenium, Cucumber, Jenkins, AWS RDS, AWS EC2, JavaScript, HTML, CSS, Bootstrap   


## Features
-  Internal Revature Employees can:  
    -  Log in  
    -  Upload a .csv file of survey data to be persisted to the Database  
    -  View overall analyses of all batches for all time  
    -  View analyses of all batches by week  
- Administrators have the ability to register an internal employee to have access to the Analyses  
- Revature Associates can submit weekly QC Surveys  


## Further Development  
- Structure to be able to view aggregated survey data for an individual batch by week has been created, but not yet implemented.  

## Required Dependencies  
- Spring Data JPA  
- Spring MVC  
- Spring Test  
- PostgreSQL Driver  
- GSON  
- Selenium  
- Cucumber  
- chart.js (JavaScript)

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

