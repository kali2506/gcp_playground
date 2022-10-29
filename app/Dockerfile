FROM openjdk:11.0.7-jre-slim
COPY target/* /usr/src/app/app.jar
EXPOSE 8888 8081 8082
ENTRYPOINT [ "java", "-jar", "/usr/src/app/app.jar" ]
