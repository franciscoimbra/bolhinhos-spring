FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/bolhinhos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#
#docker push franciscoimbra/bolhinhos:1.5.5
#docker build -t franciscoimbra/bolhinhos:1.5.3 .