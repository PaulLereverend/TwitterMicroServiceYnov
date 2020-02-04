FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml -Dmaven.test.skip=true install

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/b1-v1.jar /usr/local/lib/app.jar
EXPOSE 8080:8081