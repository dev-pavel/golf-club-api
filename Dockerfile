FROM openjdk:22-slim AS build

WORKDIR /app

COPY gradlew /app/gradlew
COPY gradle /app/gradle
COPY build.gradle /app/build.gradle
COPY settings.gradle /app/settings.gradle
COPY src /app/src

RUN chmod +x /app/gradlew

RUN ./gradlew build --no-daemon
FROM openjdk:22-slim

WORKDIR /app

COPY --from=build /app/build/libs/golf-club-api-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
