FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY pom.xml mvnw ./
RUN chmod +x mvnw
RUN ./mvnw dependency:resolve
RUN ./mvnw clean
COPY src ./src


FROM base as test
RUN ["./mvnw", "test"]

FROM base as development
CMD ["./mvnw", "spring-boot:run","-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 9090
COPY --from=build /app/target/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]