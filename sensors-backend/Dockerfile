FROM openjdk:11.0.2

RUN mkdir app
WORKDIR app
COPY ./build/libs/*.jar app.jar

EXPOSE 4000 5005

CMD ["java", \
        "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=0.0.0.0:5005", \
        "-jar", \
        "sensors-backend-0.0.1-SNAPSHOT.jar"]
