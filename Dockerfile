FROM eclipse-temurin:17-jdk-focal

RUN apt-get update && \
  apt-get install -y postgresql-client

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]