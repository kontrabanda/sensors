FROM openjdk:11.0.2

RUN mkdir app
WORKDIR app
COPY ./build/libs/*.jar app.jar


EXPOSE 4000
CMD ["ls", "-a"]

CMD ["java","-jar","sensors-backend-0.0.1-SNAPSHOT.jar"]
