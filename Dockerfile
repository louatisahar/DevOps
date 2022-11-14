FROM maven:3.8.2-jdk-8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tpachatproject-1.0.jar
ENTRYPOINT ["java", "-jar" ,"/tpachatproject-1.0.jar"]
EXPOSE 8089