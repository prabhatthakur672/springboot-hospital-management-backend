# ---------- Runtime image ----------
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy the Spring Boot fat jar
COPY target/*.jar app.jar

# JVM tuning for Render free tier (512MB RAM)
ENV JAVA_OPTS="-Xms128m -Xmx384m -XX:+UseG1GC -XX:MaxMetaspaceSize=128m"

# Start the application
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
