#!/bin/bash
git clone https://github.com/Radiomani/greenboard.git
cd greenboard
docker-compose -f src/main/resources/docker-compose.yaml up -d
mvn spring-boot:run
