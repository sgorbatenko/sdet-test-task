FROM adoptopenjdk/openjdk11:alpine
ENV APP_HOME=/usr/app/

ARG JAR_FILE=build/libs/sdet-task.jar
COPY ${JAR_FILE} $APP_HOME/

COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
COPY src $APP_HOME/src
WORKDIR $APP_HOME

RUN apk add dos2unix
RUN dos2unix ./gradlew
