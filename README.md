Application Spring mongo reactive
==========================

This is application based on SPRING MONGO REACTIVE and also contains spring security for endpoint's.

endpoint security: /api/**
	
 For get the token Authorization, execute the project jwt-spring-security(Example in : https://github.com/lgomezs/jwt-spring-security).
 
 
![Screenshot from running application](img/listHospital.png?raw=true "Screenshot List Hospital")


# Requirements

  This application is build with maven 3, Java 8 and MongoDB (in this demo for mongo connection, I used mlab). 

# Dependency

  - For connection with mongo require the artifactId mongodb:
  
  	GitHub (compile y generate artifact): 
  
  	https://github.com/lgomezs/appcore-mongodb 	
  	
  - For security applications endpoint's and get JWT:
  	
  	https://github.com/lgomezs/jwt-spring-security
	
# Configuration

 - Configure mongdb -> config-default.properties
  	
 - Configure data for generate jwt encrypt and port for the application. -> application.yml	

# Generate Library

   mvn clean install -Dmaven.test.skip=true -Dfindbugs.skip=true -Dpmd.skip=true

# Running

   Just start the application with the Spring Boot maven plugin (mvn spring-boot:run) o execute class AppHospitalApplication.	
   The application is running at http://localhost:8200
   
# Docker


   

