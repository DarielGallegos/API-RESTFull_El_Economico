FROM maven:3.9.3 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:24-slim AS final
COPY --from=build /app/target/*.jar /app.jar
EXPOSE 14000
MAINTAINER "Joan Gallegos"
ENTRYPOINT ["java", "-jar", "/app.jar"]