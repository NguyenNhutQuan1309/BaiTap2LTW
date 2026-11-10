FROM maven:3.9.16-eclipse-temurin-17-noble AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn -B clean package -DskipTests

FROM tomcat:10.1.61-jre17-temurin-noble

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/*.war \
    /usr/local/tomcat/webapps/ROOT.war

ENV JAVA_OPTS="-Dfile.encoding=UTF-8"

EXPOSE 10000

CMD ["sh", "-c", "PORT_TO_USE=${PORT:-10000}; sed -i \"s/port=\\\"8080\\\"/port=\\\"${PORT_TO_USE}\\\"/\" \"$CATALINA_HOME/conf/server.xml\"; exec \"$CATALINA_HOME/bin/catalina.sh\" run"]
