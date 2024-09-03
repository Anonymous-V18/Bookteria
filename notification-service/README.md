# Notification service

## Prerequisites

### Mongodb

Install Mongodb from Docker Hub

`docker pull bitnami/mongodb:7.0.12`

Start Mongodb server at port 27017 with root username and password: root/8082

`docker run --name mongodb-7.0.12 -p 27017:27017 -e MONGODB_ROOT_USER=root -e MONGODB_ROOT_PASSWORD=8082 -d bitnami/mongodb:7.0.12`