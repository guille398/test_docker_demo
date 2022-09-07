FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/guille398/test_docker_demo.git

FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY --from=0 app/test_docker_demo /app
RUN mvn compile

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=1 app/target/test-project-java-cucumber-1.0-SNAPSHOT.jar /app
CMD ["java -jar test-project-java-cucumber-1.0-SNAPSHOT.jar"]