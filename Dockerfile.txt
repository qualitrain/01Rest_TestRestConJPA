FROM tomcat:9.0.65-jre17-temurin-focal
WORKDIR /usr/local/tomcat/webapps
COPY target/*.war .
ENTRYPOINT ["catalina.sh","run"]