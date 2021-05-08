FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/sc-usuario-0.0.1-SNAPSHOT.jar sc-usuario.jar
ENTRYPOINT ["java","-jar","/sc-usuario.jar"]