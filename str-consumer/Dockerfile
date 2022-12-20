FROM eclipse-temurin:19-jdk-ubi9-minimal

WORKDIR /app
ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} ./app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
