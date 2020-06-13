FROM openjdk:11-jre
MAINTAINER Maxim Palashevskiy <palashevskiymaxim@gmail.com>
CMD mkdir /app


COPY backend/IES/target/ies.jar /app/IES.jar

ENTRYPOINT ["java", "-jar", "/app/IES.jar"]
