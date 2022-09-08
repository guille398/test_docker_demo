FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/guille398/test_docker_demo.git

FROM maven:3.8.3-openjdk-17-slim
WORKDIR /app
COPY --from=0 app/test_docker_demo /app
CMD mvn compile && tail -f /dev/null