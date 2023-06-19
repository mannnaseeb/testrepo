FROM maven:3.8.4-jdk-11-slim AS build
COPY src /usr/src/app/src
#RUN sed -i 's/localhost/192.168.80.88/g;s/admin/netsmart/g;s/adc_product_catalogue/product_catalogue/g' /usr/src/app/src/main/resources/application.properties
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jdk-slim
COPY --from=build /usr/src/app/target/productcatalogue-0.0.1-SNAPSHOT.jar /usr/app/productcatalogue-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/app/productcatalogue-0.0.1-SNAPSHOT.jar"]
