FROM ubuntu:22.04

RUN apt update
RUN apt upgrade
RUN apt install -y vim
RUN apt install -y git
RUN apt install -y openjdk-17-jdk
RUN apt install -y openjdk-17-jre 
RUN apt install -y maven
WORKDIR /root/project
ADD ./run.sh /root/project

ENTRYPOINT [ "/bin/bash" ]
EXPOSE 8080