

# Step 1: Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine


# Step 3: Create a directory for the app and copy the JAR file
# Set the location of the app inside the container
WORKDIR /app

# Copy the JAR file from your local machine to the container
COPY target/Movie-Management-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your application will run on
EXPOSE 8000:8080

# Step 5: Define the command to run your application
CMD ["java", "-jar", "app.jar"]