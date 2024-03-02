FROM openjdk:17

EXPOSE 8080

ADD target/banking-app-0.0.1-SNAPSHOT.jar banking-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "banking-app-0.0.1-SNAPSHOT.jar"]