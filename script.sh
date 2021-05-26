#!/bin/bash

sudo apt-get update -y
sudo apt-get install openjdk-8-jdk -y
sudo apt-get install maven
mvn clean package

# RUN 
# java -jar target/swingy-0.0.1.jar console
# java -jar target/swingy-0.0.1.jar gui