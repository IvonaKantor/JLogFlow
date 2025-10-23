FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/quarkus-app/lib/ /app/lib/
COPY target/quarkus-app/*.jar /app/
COPY target/quarkus-app/app/ /app/app/

EXPOSE 8080

CMD ["java", "-jar", "/app/quarkus-run.jar", "-Dquarkus.http.host=0.0.0.0"]