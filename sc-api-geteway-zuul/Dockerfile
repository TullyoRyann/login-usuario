FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/sc-api-geteway-zuul-0.0.1-SNAPSHOT.jar sc-api-geteway-zuul.jar
ENTRYPOINT ["java","-jar","/sc-api-geteway-zuul.jar"]