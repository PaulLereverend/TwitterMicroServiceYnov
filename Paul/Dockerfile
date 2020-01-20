FROM openjdk:10-jre-slim
COPY ./target/b3-v1.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8083:8080
ENTRYPOINT ["java","-jar","b3-v1.jar"]