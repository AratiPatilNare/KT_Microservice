FROM openjdk:8
ADD target/simple-docker.jar simple-docker.jar
EXPOSE 8120
ENTRYPOINT ["java", "-jar", "simple-docker.jar"]