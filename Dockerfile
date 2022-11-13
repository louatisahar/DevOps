FROM maven:3.8.2-jdk-8
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} achat-1.0.jar

ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
EXPOSE 8089