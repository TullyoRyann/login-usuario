FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/sc-api-gateway-zuul-0.0.1-SNAPSHOT.jar sc-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/sc-api-gateway-zuul.jar"]