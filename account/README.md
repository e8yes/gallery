# Account Service
This module provides APIs to help estasblish the identity of a human user. The JWT identification this module prodouced encodes necessary information for other e8Gallery services to make crucial access control decisions.

## API Usages
### Account Registration by Email & Password
- path ```/account/registration/email-password```
- method ```POST```
- content-type ```application/json```
- request 
```json
{
  "email": "string",
  "password": "string",
}
```
- response
```json
{
  "errorType": "string",
}
```
errorType can be one of ```["NONE", "INVALID_EMAIL", "INVALID_PASSWORD", "EMAIL_ALREADY_EXISTED"]```

### Email Verification via Token
- path ```/account/registration/verify```
- method ```POST```
- content-type ```application/json```
- request 
```json
{
  "token": "string",
}
```
- response
```json
{
  "errorType": "string",
}
```
errorType can be one of ```["NONE", "INVALID_TOKEN"]```

### Resend Verification Email
- path ```/account/registration/resend-verification-email```
- method ```POST```
- content-type ```application/json```
- request 
```json
{
  "email": "string",
}
```
- response
```json
{
  "errorType": "string",
}
```
errorType can be one of ```["NONE", "UNKNOWN_EMAIL", "RATE_LIMITED"]```


### Identity Authentication via Email & Password
- path ```/account/authentication/email-password```
- method ```PUT```
- content-type ```application/json```
- request
```json
{
  "email": "string",
  "password": "string",
}
```
- response
```json
{
  "jwtToken": "string",
  "errorType": "string",
}
```
The jwtToken is valid for a maximum of 10 minutes.
errorType can be one of ```["NONE", "UNKNOWN_EMAIL", "INCORRECT_PASSWORD"]```

### Renew Identity Authentication
- path ```/account/authentication/renew```
- method ```PUT```
- content-type ```application/json```
- request
```json
{
  "outdatedJwtToken": "string",
}
```
The outdatedJwtToken can only be renewed within 5 minutes after expiry.
- response
```json
{
  "jwtToken": "string",
  "errorType": "string",
}
```
errorType can be one of ```["NONE", "TOKEN_TOO_OLD", "TOKEN_INCORRECT"]```

### Health Check
- path ```/health/check```
- method ```GET```
- content-type ```application/json```
- request ```None```
- response
```json
{
  "healthCheckerId": "string",
  "checkedAt": "datetime",
}
```

## Development Setup
It uses docker for building, testing and running the e8 gallery account server. The commands below were tested on Docker version 23.0.5. 
1. To build the docker image, you can use the command ```docker build -t e8galleryaccount:latest .``` under this directory.
2. To run a docker container using the built image, you can use the command ```docker run -p 8000:8000 -it e8galleryaccount:latest```. This command automatically runs all the tests before starting the account server. Additionally, it maps port 8000 to that of the host machine so that the APIs can be accessed from outside the container.
