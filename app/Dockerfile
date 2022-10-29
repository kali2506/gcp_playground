FROM maven:3.8.4-jdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11.0.7-jre-slim
# COPY target/*.jar app.jar
COPY --from=build /usr/src/app/target/*.jar /usr/src/app/app.jar
EXPOSE 8888 8081 8082
ENTRYPOINT [ "java", "-jar", "/usr/src/app/app.jar" ]

#ENTRYPOINT [ "java", "-Dspring.data.mongodb.uri=mongodb://mongo/alina", "-jar", "/usr/src/app/app.jar" ]
