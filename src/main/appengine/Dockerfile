FROM gcr.io/google_appengine/openjdk8:githubheadasync
VOLUME /tmp
ADD lookalike-dashboard-0.0.1-SNAPSHOT.jar app.jar
#RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

