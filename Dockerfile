FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/diegofreda/TestProjectJavaCucumber.git
RUN git branch --contains with_docker


FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 app/TestProjectJavaCucumber /app
RUN mvn clean install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=1 app/TestProjectJavaCucumber/target/test-project-java-cucumber.jar /app
CMD ["java -jar test-project-java-cucumber.jar"]