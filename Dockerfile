FROM openjdk:8
LABEL maintainer="jghgahee@ajou.ac.kr"
ARG JAR_FILE=build/libs/firstproject-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8088
