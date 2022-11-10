FROM openjdk:8
RUN cp ./target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
CMD ["java","-jar","tpAchatProject-1.0.jar"]