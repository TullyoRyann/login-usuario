FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/sc-oauth-0.0.1-SNAPSHOT.jar sc-oauth.jar
ENTRYPOINT ["java","-jar","/sc-oauth.jar"]