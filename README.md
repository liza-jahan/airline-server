# Lina Airline Backend

## Description
Lina Airline Backend is a Java Spring Boot application that [briefly describe what your application does]. It is designed to [highlight the key features or functionalities]. This application is built using Spring Boot, a framework for Java-based applications, and provides [mention key features like APIs, integration with databases, etc.].

---

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Configuration](#configuration)
- [Database Setup](#database-setup)
- [Running Tests](#running-tests)
- [API Documentation](#api-documentation)
- [Deployment](#deployment)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
- [Contact Information](#contact-information)

---

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java**: You need to have Java 21 (or newer) installed. You can verify your Java version by running:

  ```bash
  java -version
- **Maven**: Maven is required to build the project. You can verify your Maven installation by running:
  ```bash
  mvn -v
  ```

## Installation

- **Clone the repository**:
  ```bash
  git clone https://github.com/your-username/your-repo-name.git
  cd your-repo-name
  ```
  
- **Build the project**:

  You can use Maven to build the application:
  ```bash
  mvn clean install
  ```
  
- **Configure the application**:
  The application uses an external configuration file, ```application.yml``` or ```application.properties```. You can find it in the ```src/main/resources``` directory.

## Running the Application

**Running locally**:
- Start the database (if applicable):

  If you're using a local database, ensure it's running. Alternatively, you can start a Docker container if the database is set up via Docker:
  ```bash
  docker-compose up
  ```
  
- **Run the Spring Boot application**: You can run the application via Maven or your IDE (e.g., IntelliJ IDEA or Eclipse):
  ```bash
  mvn spring-boot:run
  ```

  Or using the generated JAR file:
 
  ```bash
  java -jar target/your-app-name.jar
  ```
- **Access the application***: The application will be available at:
  ```bash
    http://localhost:8080
  ```
## Configuration
**Environment Profiles**:
This Spring Boot application uses different profiles for different environments. The profiles can be activated by passing the ```spring.profiles.active``` property. For example:
```bash
java -jar target/your-app-name.jar --spring.profiles.active=dev
```
**The available profiles are**:

- default: Default profile with minimal configuration.
- dev: Development environment settings.
- qa: Quality Assurance environment.
- prod: Production environment settings.

**Configuration Files**:
- application.yml: Global configuration file.
- application-dev.yml: Development-specific configurations.
- application-qa.yml: QA-specific configurations.
- application-prod.yml: Production-specific configurations.

## Database Setup
- **Database Configuration**:

Configure your database settings in the ```application.yml``` or environment-specific configuration file (``application-dev.yml``, ``application-prod.yml``):

```bash
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your-database
    username: your-username
    password: your-password
```

- **Database Migrations**:

If you are using a tool like Flyway or Liquibase for database migrations, ensure that it's configured properly. You can run migrations with the following command:
```bash
mvn flyway:migrate
```

## Running Tests
The project uses JUnit and/or other testing frameworks for unit and integration tests.

To run the tests:
```bash
mvn test
```

## API Documentation
This application provides REST APIs that can be tested using tools like Postman or cURL. If you're using Swagger for API documentation, you can access it at:

```bash
http://localhost:8080/swagger-ui.html
```
## Deployment
#### Deploy using Docker
- **Build the Docker image**:
```bash
docker build -t your-app-name .
```

- **Run the Docker container**:
```bash
docker run -p 8080:8080 your-app-name
```
***Deploy on a cloud provider (AWS, Google Cloud, etc.)***:
Refer to the cloud provider’s documentation to deploy the Spring Boot application.

## Technologies Used

* **Spring Boot** - A Java framework for building enterprise applications.
* **Hibernate** - An ORM tool for database operations.
* **MySQL/PostgreSQL** - Relational databases (choose the one you're using).
* **Docker** - For containerization and deployment.
* **Maven** - For project build and dependency management.
* **Swagger** - API documentation tool.
* **JUnit** - For writing unit tests.
* **Flyway/Liquibase** - For database versioning and migrations.

## Contact Information

For any inquiries or support, please contact:

- **Email**: [your-email@example.com](mailto:your-email@example.com)
- **GitHub**: [Your GitHub Profile](https://github.com/your-username)


## SQL Injection

- SQL Injection is a web page vulnerability that lets an attacker make queries with the database.
- Attackers take advantage of web application vulnerability and inject an SQL command via the input from users to the application.
- Attackers can SQL queries like SELECT to retrieve confidential information that otherwise wouldn’t be visible.

## REST API Naming Conventions

**Use Nouns to represent resources / Not Verbs**

Always make sure that your URIs are named with nouns to specify the resource instead of using verbs. The URIs shouldn’t indicate any CRUD (Create, Read, Update, Delete) operations. Additionally avoid verb-noun combinations: hyphenated, snake_case, camelCase.

Bad examples:

```
http://api.example.com/v1/store/CreateItems/{item-id}❌
http://api.example.com/v1/store/getEmployees/{emp-id}❌
http://api.example.com/v1/store/update-prices/{price-id}❌
http://api.example.com/v1/store/deleteOrders/{order-id}❌
```

Good examples:
```
http://api.example.com/v1/store/items/{item-id}✅
http://api.example.com/v1/store/employees/{emp-id}✅
http://api.example.com/v1/store/prices/{price-id}✅
http://api.example.com/v1/store/orders/{order-id}✅
```

**Use Pluralized Nouns for resources**
Use plural when possible unless they are singleton resources.
