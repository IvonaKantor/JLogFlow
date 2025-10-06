FROM eclipse-temurin:17-jre-alpine

WORKDIR /work/
RUN chown 1001 /work \
    && chmod "g+rwX" /work \
    && chown 1001:root /work

COPY target/quarkus-app/lib/ /work/lib/
COPY target/quarkus-app/*.jar /work/