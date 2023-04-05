FROM openjdk:11
COPY ./target/spe-mini-project_calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "spe-mini-project_calculator-1.0-SNAPSHOT-jar-with-dependencies.jar"]
