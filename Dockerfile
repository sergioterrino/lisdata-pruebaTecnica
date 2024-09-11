FROM eclipse-temurin:17-jdk-alpine

WORKDIR /lisdata

COPY target/lisdata-0.0.1-SNAPSHOT.jar /lisdata/lisdata-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "lisdata-0.0.1-SNAPSHOT.jar"]
