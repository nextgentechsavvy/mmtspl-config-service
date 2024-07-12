FROM openjdk:8
EXPOSE 9012
ADD target/mmtspl-config-service-1.0.0-SNAPSHOT.jar mmtspl-config-service-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/mmtspl-config-service-1.0.0-SNAPSHOT.jar"]