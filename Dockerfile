FROM openjdk:11
ENV ENV=docker \
    database_username=root \
    database_password=Meshu@20ls
ADD target/portfolio-internal-ms.jar portfolio-internal-ms.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "portfolio-internal-ms.jar"]