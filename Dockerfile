FROM ubuntu:22.04

RUN apt update
RUN apt upgrade
RUN apt install -y vim
RUN apt install -y git
RUN apt install -y openjdk-17-jdk
RUN apt install -y openjdk-17-jre 
RUN apt install -y maven

RUN apt-get update && apt-get install -y gnupg && apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10 && \
# RUN apt-get install -y gnupg && \
    # apt-key adv
RUN echo "deb [ arch=amd64,arm64 ] http://repo.mongodb.org/apt/ubuntu jammy/mongodb-org/5.1 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-5.1.list
RUN apt-get update && apt-get install -y mongodb-server
RUN mvn clean package
RUN apt-get install -y mongodb-org
# Start MongoDB and the Java application
CMD mongod --fork --logpath /var/log/mongodb.log && java -jar target/myproject.jar

WORKDIR /root/project
ADD ./run.sh /root/project

ENTRYPOINT [ "/bin/bash" ]
EXPOSE 8080