FROM amazoncorretto:11.0.15
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build/libs/simple-interest-microservice-1.jar app.jar
EXPOSE 8080
#HEALTHCHECK CMD curl --fail localhost:8080/ || exit 1
CMD ["java", "-jar", "app.jar"]
