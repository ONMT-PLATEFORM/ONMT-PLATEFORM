FROM openjdk:17

LABEL maintainer="ELMAHDI ELHJOUJYE <elhajuojye@gmail.com>


# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/configserver-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8071

# Starting the application
CMD ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]