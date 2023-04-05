FROM ubuntu:22.04

# Update and install necessary packages
RUN apt update && \
    apt upgrade -y && \
    apt install -y vim git openjdk-17-jdk openjdk-17-jre maven

RUN apt install -y software-properties-common gnupg apt-transport-https ca-certificates \
    apt install -y wget \
    wget -qO - https://www.mongodb.org/static/pgp/server-6.0.asc | apt-key add - \
    echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/6.0 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-6.0.list \
    apt update \
    apt install -y libssl1.1 \
    apt install -y mongodb-org

RUN mkdir /data && mkdir /data/db
WORKDIR /root/project
ADD ./run.sh /root/project

ENTRYPOINT [ "/bin/bash" ]
EXPOSE 8080