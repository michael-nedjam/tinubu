FROM eclipse-temurin:17-jdk-focal

RUN apt-get update && \
    apt-get install -y maven

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/assurance-app-1.0-SNAPSHOT.jar"]