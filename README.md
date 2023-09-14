Spring Reactive with PostgreSQL (Spring Boot WebFlux + PostgreSQL + Tomcat)

Documentation: https://www.codeburps.com/post/spring-boot-webflux-with-postgre-sql

Using Spring Boot Weblfux with embedded Tomcat

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

And test with swagger: http://localhost:8080/swagger-ui.html

![alt text](https://techburps-7.s3.ap-south-1.amazonaws.com/tech-blog/spring-web-flux-swagger-ui-open-api.png)
