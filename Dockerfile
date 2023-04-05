FROM ubuntu:22.04

# Update and install necessary packages
RUN apt update && \
    apt upgrade -y && \
    apt install -y vim git openjdk-17-jdk openjdk-17-jre maven gnupg

RUN apt update && \
    apt install -y curl && \
    apt install -y python3-pip && \
    pip3 install docker-compose

COPY --from=docker/compose:1.29.2 /usr/local/bin/docker-compose /usr/local/bin/docker-compose

WORKDIR /root/project
ADD ./run.sh /root/project

ENTRYPOINT [ "/bin/bash" ]
EXPOSE 8080