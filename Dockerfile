# ---------- Build stage ----------
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Maven files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies (cached layer)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests


# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# JVM tuning for Render free tier
ENV JAVA_OPTS="-Xms128m -Xmx384m -XX:+UseG1GC -XX:MaxMetaspaceSize=128m"

EXPOSE 8080

# Start the application
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
