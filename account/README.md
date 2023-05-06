# Account Service
This module provides APIs to help estasblish the identity of a human user. The JWT identification this module prodouced encodes necessary information for other e8Gallery services to make crucial access control decisions.

## API Usages

## Development Setup
It uses docker for the building, testing and running of the e8 gallery account server. The commands below was tested on Docker version 23.0.5. 
1. To build the docker image, you can use the command ```docker build -t e8galleryaccount:latest .``` under this directory.
2. To run the docker image, you can use the command ```docker run -it e8galleryaccount:latest```. This command automatically runs all the tests before starting the account server.
