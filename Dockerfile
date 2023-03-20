FROM openjdk:11
COPY ./target/spe-mini-project_calculator-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "spe-mini-project_calculator-1.0-SNAPSHOT.jar"]

# Start with a base image
# FROM openjdk:11

# # Set the working directory
# WORKDIR /app

# # Copy the JAR file into the container
# COPY target/my-app.jar /app

# # Expose the port that the application will listen on
# EXPOSE 8080

# # Define the command to run the application
# CMD ["java", "-jar", "my-app.jar"]