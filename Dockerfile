FROM openjdk:17
ADD target/MavenProjectDevOps-3.2.2.jar MavenProjectDevOps-3.2.2.jar
ENTRYPOINT [ "java", "-jar","MavenProjectDevOps-3.2.2.jar" ]
