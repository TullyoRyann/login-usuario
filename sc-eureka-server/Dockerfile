FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/sc-eureka-server-0.0.1-SNAPSHOT.jar sc-eureka-server.jar
ENTRYPOINT ["java","-jar","/sc-eureka-server.jar"]