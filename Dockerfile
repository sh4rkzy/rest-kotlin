FROM openjdk:17-jdk-slim AS build-stage

WORKDIR /app

COPY pom.xml ./
COPY .mvn ./.mvn
COPY mvnw ./
COPY src ./src

RUN ./mvnw clean package -DskipTests

RUN ls -l target

FROM openjdk:17-jdk-slim AS production-stage

WORKDIR /app

COPY --from=build-stage /app/target/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
