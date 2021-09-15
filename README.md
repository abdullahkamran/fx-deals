# Fx Deals

A demo application made in Spring Boot and Angular

## Build
Do a Maven clean install. This will also run api unit tests, frontend unit tests, and frontend e2e tests.

### Spring Boot API
- Maven used for project structure
- MySQL database used
- Liquibase used for database changelog
- Field validations
- Slf4j logging
- JUnit5 unit tests
- H2 in memory database used for unit tests

### Angular UI
- Validations and formatting of input fields
- Error handling
- Jasmine unit tests
- Protractor e2e tests

### Notes:

If database is not created, create it using:

CREATE DATABASE fxDeals;

OR, use Dspring.profiles.include=dev as application VM options to use H2 in memory databse.

Username and password for MySQL server are configured to be:
username: root
password: fxDeals
These credentials can be changed from application.yaml properties.

