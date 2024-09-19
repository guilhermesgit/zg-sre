FROM openjdk:8

COPY build/libs/*.war app-ps-sre.war

CMD java $JAVA_OPTS -Dgrails.env=prod  -jar *.war