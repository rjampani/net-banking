FROM openjdk:8-alpine-jre
RUN apk add -no-cache curl
RUN mkdir -p /app
RUN addgroup -S netbanking && adduser -S netbanking -G netbanking
USER netbanking:netbanking
ARG WORKSPACE
ARG JAR_FILE=${WORKSPACE}/target/net-banking-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} /app/net-banking-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java", "-jar", "/app/net-banking-0.0.1-SNAPSHOT.war" ]
