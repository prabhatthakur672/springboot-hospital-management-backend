# ---------- Build stage ----------
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Maven wrapper files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# 🔑 FIX: give execute permission
RUN chmod +x mvnw

# Download dependencies (cached layer)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests


# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENV JAVA_OPTS="-Xms128m -Xmx384m -XX:+UseG1GC -XX:MaxMetaspaceSize=128m"

EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
