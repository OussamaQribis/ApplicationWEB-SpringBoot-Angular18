
## Angular 18 Frontend with SpringBoot(Java) Backend
Application to demonstrate various a service oriented RESTfull application. 

### Technology Stack
Component         | Technology
---               | ---
Frontend          | [Angular 18](https://github.com/angular/angular)
Backend (REST)    | [SpringBoot](https://projects.spring.io/spring-boot) (Java)
Security          | Token Based (Spring Security and [JWT](https://github.com/auth0/java-jwt) )
REST Spec         | [Open API Standard](https://www.openapis.org/) 
In Memory DB      | MYSQL 
Persistence       | JPA (Using Spring Data)
Client Build Tools| [angular-cli](https://github.com/angular/angular-cli), Webpack, npm
Server Build Tools| Maven(Java) 
## Prerequisites
Ensure you have this installed before proceeding further
- Java v17.0.5
- Maven v4.0
- Node.js v20.15.1,  
- npm 5 ,   
- Angular v18
- PrimeNG v14.2.17
- my SQL
- Angular-cli v13.0.4

## About
This site is for Manages a variety of devices and generally monitors their location.

The goal of the project is to 
- Highlight techniques of making and securing a REST full app using [SpringBoot](https://projects.spring.io/spring-boot)
- How to consume an RESTfull service and make an HTML5 based many Page App using [Angular 18](https://github.com/angular/angular)

### Features of the Project
* Backend
  * Token Based Security (using Spring security)
  * API documentation and Live Try-out links with Swagger 
  * In Memory MYSQL 
  * Using JPA and JDBC template to talk to relational database
  * How to request and respond for paginated data 

* Frontend
  * Organizing Components, Services,Routing, Directives, Pages etc in an Angular App
  * How to us PrimeNG 
  * Techniques to Lazy load Data (Infinite Scroll)
  * Techniques to load large data set in a data-table but still keeping DOM footprint less
  * Routing and guarding pages that needs 
  * Basic visulaization

* Build
  * How to build all in one app that includes (database, sample data, RESTfull API, Auto generated API Docs, frontend and security)
  * Portable app, Ideal for dockers, cloud hosting.

## In Memory DB (MYSQL)
I have included an in-memory database for the application. Database schema and sample data for the app is created everytime the app starts, and gets destroyed after the app stops, so the changes made to to the database are persistent only as long as the app is running
<br/>
Creation of database schema and data are done using sql scripts that Springs runs automatically. 
To modify the database schema or the data you can modify [schema.sql](https://github.com/OussamaQribis/ApplicationWEB-SpringBoot-Angular18/blob/main/BackEnd_SG_RDT/src/main/resources/application.properties) 

## Spring security
Security is **enabled** by default, to disable, you must comment [this line](https://github.com/OussamaQribis/ApplicationWEB-SpringBoot-Angular18/blob/main/BackEnd_SG_RDT/src/main/java/com/coderdot/configuration/WebSecurityConfiguration.java) <br/>
When security is enabled, none of the REST API will be accessesble directly.

<br/>

To get a token call `POST /session` API with a valid userid and password.
for example you may you can use the folliwing curl command to get a token 
```
curl -X POST --header 'Content-Type: application/json' -d '{ "username":"demo", "password":"demo" }' 'http://localhost:9119/session'
```
the above curl command will return you a token, which should be in the format of `xxx.xxx.xxx`. This is a JSON web token format. 
You can decode and validate this token at [jwt.io wesite](https://jwt.io/). Just paste the token there and decode the information.
to validate the token you should provide the secret key which is `mrin` that i am using in this app.
<br/>
after receiving this token you must provide the token in the request-header of every API request. For instance try the ` /login` api using the below 
curl command (replace xxx.xxx.xxx with the token that you received in above command) and you should be able to access the API.
```
curl -X GET --header 'Accept: application/json' --header 'Authorization: xxx.xxx.xxx' 'http://localhost:8080/login'
``` 

### Build Frontend (optional step)
Code for frontend is allready compiled and saved under the ```webui/dist``` 
when building the backend app (using maven) it will pickup the code from ```webui/dist```. However if you modified the frontend code and want your changes to get reflected then you must build the frontend 
```bash
# Navigate to PROJECT_FOLDER/webui (should contain package.json )
npm install
# PrimeNg install go to(https://www.primefaces.org/primeng-v14-lts/setup)
npm install primeng --save
npm install primeicons --save
# build the project (this will put the files under dist folder)
ng build --prod --aot=true
#start the project
ng serve
```

### Build Backend (SpringBoot Java)
```bash
# Maven Build : Navigate to the root folder where pom.xml is present 
mvn clean install


```

### Start the API and WebUI server
```bash
# Start the server (8080)
# port and other configurations for API servere is in [./src/main/resources/application.properties](/src/main/resources/application.properties) file

#  maven jar location will be 
java -jar ./target/app-1.0.0.jar


```

### Accessing Application
Cpmponent         | URL                                         | Credentials
---               | ---                                         | ---
Frontend          |  http://localhost:4200                      | `/#/dashbord`
login             |  http://localhost:4200/login                |  by default is Email=`admin@gmail.com` password=`123`
sigin             |  http://localhost:4200/sigin                |  create new user
affectation       |  http://localhost:4200/#/admin/affectation  | `table`
Bons              |  http://localhost:4200/#/admin/Bons         | `table`


### Screenshots
#### Login
![Dashboard](/screenshots/login.png?raw=true)
---
#### Sigin
![Dashboard](/screenshots/sigin.png?raw=true)
---
####  affectation Stats
![Dashboard](/screenshots/affectation.png?raw=true)
---
#### Bons Stats
![Dashboard](/screenshots/bons.png?raw=true)
---





## Sponsors

Support this project by becoming a sponsor. Your logo will show up here with a link to your website. [[Become a sponsor](https://opencollective.com/angular-springboot-rest-jwt#sponsor)]
