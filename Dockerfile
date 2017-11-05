FROM openjdk:8

ADD target/SpringRabbitMqConsumer-0.0.1.jar /rabbitconsumerapp.jar

RUN sh -c 'touch /rabbitconsumerapp.jar'

#EXPOSE 8140
EXPOSE 80

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rabbitconsumerapp.jar"]