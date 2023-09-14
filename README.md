# Spring Reactive with PostgreSQL (Spring Boot WebFlux + PostgreSQL + Tomcat)

## Using Spring Boot Weblflux with embedded Tomcat

Replace
````
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
````
With
````
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
    <exclusions>
        <!-- Exclude the Netty dependency -->
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-reactor-netty</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<!-- Use Tomcat instead -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
</dependency>
````

### DB Setup

````
CREATE DATABASE userdb;

CREATE TABLE users (
id serial primary key,
first_name varchar(50),
last_name varchar(50)
)
````

### Test
Test with swagger: http://localhost:8080/swagger-ui.html

![alt text](https://techburps-7.s3.ap-south-1.amazonaws.com/tech-blog/spring-web-flux-swagger-ui-open-api.png)
