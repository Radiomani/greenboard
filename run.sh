#!/bin/bash
git clone https://github.com/Radiomani/greenboard.git
cd greenboard
mkdir /log
mongod --fork --logpath /log/file.log
mvn spring-boot:run
