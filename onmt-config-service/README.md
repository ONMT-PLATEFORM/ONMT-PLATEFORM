# CONFIG SERVER

## INTRODUCTION 

CONFIG SERVER is a microservice that provides configuration to other microservices. It is a central place to manage external properties for applications across all environments. It is a Spring Boot application that uses Spring Cloud Config Server to serve the configuration of other applications.

## PRE-REQUISITES

- DOCKER
- JAVA 17 or higher
- MAVEN 3.8.2 or higher

## BUILDING AND RUNNING THE APPLICATION VIA DOCKER 

```bash
mvn clean package
```
```bash
docker build -t config-server/dockerspringboot .
```
```bash
docker run -d -p 8071:8071 --name config-container config-server/dockerspringboot
```

## retrieving configuration from config server

`profile : dev, prod, test , default`

`application.name : name of the application` : project-service , chat-service , ...

```bash
     curl http://localhost:8071/{{application.name}}/{{profile}}
```

## CONTACT

- [LinkedIn](https://www.linkedin.com/in/elmahdi-elhjoujy/)
- [email](mailto:elhajuojye@gmail.com)