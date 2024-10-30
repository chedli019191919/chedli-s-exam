FROM openjdk:17
EXPOSE 8089
ADD target/eventsProject-1.0.0-SNAPSHOT.jar event.jar
ENTRYPOINT ["java", "-jar", "event.jar"]
