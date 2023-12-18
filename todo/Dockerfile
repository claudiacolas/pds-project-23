FROM openjdk:17

WORKDIR /app

COPY target/todo-0.0.1-SNAPSHOT.jar app.jar

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .

EXPOSE 8080

ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"

CMD ["java", "-jar", "app.jar"]
