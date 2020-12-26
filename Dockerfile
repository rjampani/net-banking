FROM openjdk:8-jre-alpine
RUN apk --no-cache add curl
RUN mkdir -p /app
RUN addgroup -S netbanking && adduser -S netbanking -G netbanking
USER netbanking:netbanking
ARG WORKSPACE
ARG JAR_FILE=target/net-banking-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} /app/net-banking-0.0.1-SNAPSHOT.war
EXPOSE 8080
HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 CMD curl http://localhost:8080/actuator/health || exit 1
ENTRYPOINT [ "java", "-jar", "/app/net-banking-0.0.1-SNAPSHOT.war" ]
