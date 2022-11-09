From openjdk:8
copy ./target/tpAchatProject-1.0.jarr tpAchatProject-1.0.jar
CMD ["java","-jar","tpAchatProject-1.0.jar"]