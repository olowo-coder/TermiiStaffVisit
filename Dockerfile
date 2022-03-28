FROM openjdk:11
ADD target/Termii-Visit-App.jar Termii-Visit-App.jar
ENTRYPOINT ["java", "-jar", "Termii-Visit-App.jar"]