FROM bellsoft/liberica-openjdk-alpine:17

EXPOSE 8081

COPY build/libs/Module_1-REST-Task_1_1_1-Conditional_application-0.0.1-SNAPSHOT.jar netology-homework-testcontainers-prod.jar
ENTRYPOINT ["java", "-jar", "/netology-homework-testcontainers-prod.jar"]