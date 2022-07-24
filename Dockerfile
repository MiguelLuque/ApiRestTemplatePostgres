ARG BUILD_IMAGE=maven:3.6.3-jdk-11
ARG RUNTIME_IMAGE=openjdk:11

# Docker is pulling all maven dependencies
FROM ${BUILD_IMAGE} as dependencies

WORKDIR /build
COPY pom.xml /build/

RUN mvn -B dependency:go-offline

# Docker is building spring boot app using maven
FROM dependencies as build

WORKDIR /build
COPY src /build/src
COPY infrastructure/api/openapi.yaml /build/infrastructure/api/openapi.yaml

RUN mvn -B clean package -DskipTests

# Docker is running a java process to run a service built in previous stage
FROM ${RUNTIME_IMAGE}

WORKDIR /app
COPY --from=build /build/target/template-api-first.jar /app/template-api-first.jar

ENTRYPOINT ["java","-jar","/app/template-api-first.jar"]
