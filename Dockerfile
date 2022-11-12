FROM maven:3.8.2-jdk-11
ADD target/tpachatproject-1.0.jar tpachatproject-1.0.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "tpachatproject-1.0.jar"]