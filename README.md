# Spring DB Example

This repository is a Spring Boot example that saves customer data to a backend MySQL database.
When run locally, this project will use an internal H2 instance.

## Getting Started

Clone this repository.

```bash
git clone https://github.com/bernardpark/template-spring-db.git
```

## API
The following are this application's Rest API endpoints for this service.

### Add customer
1. Endpoint: /add-customer
1. Query parameters: firstName, lastName
1. GET request

### Get all customers
1. Endpoint: /get-customers
1. GET

### Delete all customer
1. Endpoint: /delete-customers
1. GET request

## Running Locally

### Prerequisites
Ensure that you have the following

1. JDK 1.8.x
1. Maven

### Build Application
Build with Maven.

```bash
mvn clean package
java -jar ./target/template-spring-db-0.0.1-SNAPSHOT.jar
```

### Verify Service
Try the following commands in your shell.

```bash
curl "localhost:8080/add-customer?firstName=John&lastName=Doe"
curl "localhost:8080/get-customers"
curl "localhost:8080/delete-customers"
```

## Running in PCF

### Prerequisites
Ensure that you have the following

1. JDK 1.8.x
1. Maven
1. CF CLI 6.40.x
1. A MySQL 5.7 instance permissing external connections
1. A Credhub Broker with credentials [url, username, password]

### Push Services
After targeting your PCF Foundation, run these commands to push your services while replacing the variables.

```bash
mvn clean package; cf push
```

### Verify Service
Try the following commands in your shell.

```bash
curl -k "$YOUR_APP_ENDPOINT/add-customer?firstName=John&lastName=Doe"
curl -k "$YOUR_APP_ENDPOINT/get-customers"
curl -k "$YOUR_APP_ENDPOINT/delete-customers"
```

## Authors
* **Bernard Park** - [Github](https://github.com/bernardpark)
