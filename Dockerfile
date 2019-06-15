FROM openjdk:8
COPY target/cekl-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8000/tcp
ENTRYPOINT ["java", "-jar", "/app.jar"]