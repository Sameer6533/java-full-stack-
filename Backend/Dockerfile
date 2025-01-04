# Use a Java base image
FROM openjdk:20-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the JAR file built by Maven or Gradle
COPY target/booking-system.jar /app/booking-system.jar

# Expose the port the app will run on
EXPOSE 8091

# Run the JAR file
CMD ["java", "-jar", "booking-system.jar"]
