FROM openjdk
VOLUME /tmp
ADD microservice-simple-provider-user-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=provider1"]