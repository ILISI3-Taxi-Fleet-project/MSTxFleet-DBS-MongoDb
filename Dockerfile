FROM openjdk:17-jdk-alpine
COPY target/MSTxFleet-DBS-MongoDb-0.0.1-SNAPSHOT.jar MSTxFleet-DBS-MongoDb.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/MSTxFleet-DBS-MongoDb.jar"]