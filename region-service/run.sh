#!/usr/bin/env zsh

NS=cnj
IMGE_NAME=ma.yc.api/egilekom/configServer:latest

echo "Deploying to Kubernetes cluster" + ${IMGE_NAME}

#mvn clean install -DskipTests=true spring-boot:build-image -Dspring-boot.build-image.imageName=${IMGE_NAME}
#mvn clean install -DskipTests=true
mvn spring-boot:run
