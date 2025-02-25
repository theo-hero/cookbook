FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

COPY . .

RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/recipe-book-0.0.1-SNAPSHOT.jar /app/recipe-book-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "recipe-book-0.0.1-SNAPSHOT.jar"]

# recipe-book-0.0.1-SNAPSHOT.jar