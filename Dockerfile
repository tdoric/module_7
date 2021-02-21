FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 8093
ARG JAR_FILE=target/m7.jar
ADD ${JAR_FILE} add_group.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar add_group.jar" ]