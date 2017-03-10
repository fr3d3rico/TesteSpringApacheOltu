# SpringBoot + Jersey + Apache Oltu Oauth2

This project show how configure SpringBoot App that use Jersey REST Controller and OAuth2 with Apache Oltu ;)

## RFC 2616

This example apply Authorization Request flow (https://tools.ietf.org/html/rfc6749#section-4.1.1)
To learn well how OAuth2 works I recommend read RFC 2616 for The OAuth 2.0 Authorization Framework (https://tools.ietf.org/html/rfc6749)

### Ps.: This is simple app to show you how start using apache oltu. Please, improve and apply design patterns to let you app be more professional.

### References

Spring Boot > https://projects.spring.io/spring-boot/

Apache Oltu > https://oltu.apache.org/

Maven > https://maven.apache.org/

Jersey > https://jersey.java.net/

## Prerequesites

1 - This app use maven to build and download dependencies. Please, if you still not know how use, please go to https://maven.apache.org/guides/getting-started/

2 - Create a client id and secret on facebook (https://developers.facebook.com/). Configure the url of your site to facebook allow the traffic between your site and facebook.

3 - Create a client id and secret on google (https://console.developers.google.com). Configure the url of your site to google allow the traffic between your site and google. Configure too the url redirect. Google need know where go back to your site/server. ;)

4 - After steps 2 and 3, go to application.properties located in src/main/resources and update with information from each authorization site.

5 - If still not know about Spring Boot, please, I think you should know about it. Pivotal has been made a great job! (https://projects.spring.io/spring-boot/)

6 - Remember: Add Apache Oltu on pom.xml file to maven know where is the dependency.

```xml
<dependency>
    <groupId>org.apache.oltu.oauth2</groupId>
    <artifactId>org.apache.oltu.oauth2.client</artifactId>
    <version>1.0.2</version>
</dependency>
```

## Compile

If you like to use command-line terminal, go to root directory and run following command:

$ mvn compile

Or

If you use Spring Tool Suite like me, perform the follow steps:

1 - Right click on project

2 - Choose Run As...

3 - Then choose Maven Build

## Run

If you use command-line terminal, go to root directory and run following command:
(http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html)

$ mvn spring-boot:run

Or

If you use Spring Tool Suite...

1 - Right click on project

2 - Choose Run As...

3 - Then choose Spring Boot App
