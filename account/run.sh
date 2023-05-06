#!/bin/bash

# Starts the postgres development database server.
service postgresql start

# Tests the account service.
mvn clean test -Dspring-boot.run.profiles=test

# Launches the account service in development mode.
mvn spring-boot:run -Dspring-boot.run.profiles=dev
