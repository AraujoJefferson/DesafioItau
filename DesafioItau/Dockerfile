FROM ubuntu
RUN apt-get -y update
RUN apt-get -y install openjdk-8-jdk
EXPOSE 8080
ADD classes/artifacts/desafioitau.java /
CMD ["java", "-jar", "/desafioitau.java"]
