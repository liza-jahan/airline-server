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

## What is the impact of a successful SQL injection attack?
- A successful SQL injection attack can have severe consequences, including unauthorized access to sensitive data, such as personal information and financial records.
- Attackers may manipulate or delete critical data, compromising its integrity and causing operational disruptions.
- They can also bypass authentication mechanisms, gaining unauthorized access to user accounts, including administrative privileges.

## How Does a SQL Injection Attack Work?

A SQL Injection attack involves inserting or “injecting” a SQL query via the input data from the client to the application. A successful attack allows an attacker to manipulate the SQL queries that an application makes to its database. It typically involves the following steps:

* **Identification of vulnerable inputs**: Attackers first identify inputs within the web application that are vulnerable to SQL injection. These inputs could be text fields in a form, URL parameters, or any other input mechanisms.
* **Crafting the malicious SQL query**: Once a vulnerable input is identified, attackers craft a SQL statement intended to be inserted into the query executed by the application. This statement is designed to modify the original SQL query to perform actions unintended by the application developers.
* **Bypassing application security measures**: Attackers often have to bypass security measures like input validation or escaping special characters. They achieve this through techniques like string concatenation or utilizing SQL syntax to comment out parts of the original query.
* **Executing the malicious query**: When the application executes the SQL query, it includes the attacker’s malicious input. This modified query can perform actions such as unauthorized viewing of data, deletion of data, or even database schema alterations.
* **Extracting or manipulating data**: Depending on the attack, the outcome might be the extraction of sensitive information (like user credentials), altering existing data, adding new data, or even deleting significant portions of the database.
* **Exploiting database server vulnerabilities**: Advanced SQL injections may exploit vulnerabilities in the database server, extending the attack beyond the database to the server level. This can include executing commands on the operating system or accessing other parts of the server’s file system.
  
##  SQL Injection Types
There are different types of SQL injection attacks:

1. In-band SQL Injection
2. Error-based SQL Injection
3. Blind SQL Injection
4. Out-of-band SQL Injection
5. Inference-based SQL Injection

  

## REST API Naming Conventions

***Use Nouns for Resources***

The core concept of RESTful APIs is to manipulate resources through HTTP methods. To keep your APIs simple and easy to understand, use nouns for resources in your URLs. For example, if you have an API for managing users, the resource could be named “/users”. Using a verb in the resource name can be confusing and less intuitive.

❌Wrong:

* /createUser

* /deleteUser

✔️Correct :

* /users (GET — list all users, POST — create a new user)

* /users/{userId} (GET — get user details, PUT — update user details, DELETE — delete user)

***Use HTTP Methods for Actions***

HTTP methods are used to perform actions on resources. Use HTTP methods to indicate the type of action that is being performed on the resource. For example, to retrieve user data, use the HTTP GET method on the “/users” resource.

❌Wrong:

* /getUsers

* /fetchUsers

* /retrieveUsers

✔️Correct:

* /users (GET — list all users)

* /users/{userId} (GET — get user details)

***Use Plural Nouns for Collections***

For resources that represent collections, use plural nouns in the URL. For example, if you have an API that manages books, use “/books” to represent a collection of books.

❌Wrong:

* /book

* /user

✔️Correct:

* /books

* /users

***Use Parameters for Filtering, Sorting, and Pagination***

Use query parameters to allow users to filter, sort, and paginate through collections of resources. For example, you could use the query parameter “?page=2” to get the second page of results.

❌Wrong:

* /users?page=2&perPage=10

* /getUsers/2/10

✔️Correct:

* /users?_page=2&_limit=10

* /users?page=2&perPage=10 (for backward compatibility)

***Use Descriptive Names for Query Parameters***

When using query parameters, use descriptive names to make it clear what the parameter does. For example, instead of using “?q=keyword”, use “?search=keyword” to indicate that the parameter is used for searching.

❌Wrong:

* /users?q=John

* /books?search=history

✔️Correct:

* /users?name=John

* /books?category=history

***Use Consistent Naming Conventions***

Maintain consistency throughout your API by using the same naming conventions for resources, actions, and parameters. This makes your API easier to understand and use.

❌Wrong:

* /users (for listing all users)

* /getAllUsers

✔️Correct:

* /users (for listing all users)

* /users/{userId} (for retrieving a specific user)

***Use CamelCase or Snake Case for Multi-word Names***

When naming resources, use either CamelCase or snake case for multi-word names. For example, if you have an API that manages blog posts, use “/blogPosts” or “/blog_posts” to represent the resource.

❌Wrong:

* /blogPosts

* /blog_posts

* /BlogPosts

✔️Correct:

* /blog-posts

***Use HTTP Status Codes for Error Handling***

Use HTTP status codes to indicate the success or failure of API requests. For example, a 404 status code should be returned when a requested resource is not found.

❌Wrong:

* Returning 200 (OK) for errors

✔️Correct:

* Returning 404 (Not Found) for a non-existent resource
* Returning 400 (Bad Request) for invalid request parameters
* Returning 401 (Unauthorized) for an unauthorized request
* Returning 500 (Internal Server Error) for server-side errors

***Use Consistent Response Formats***

Use a consistent format for API responses to make it easy for developers to consume your API. Use JSON or XML for response formats, and ensure that your responses include all necessary information.

❌Wrong:

* Returning responses in different formats (JSON, XML, HTML, etc.) depending on the endpoint

✔️Correct:
* Returning responses in a consistent format, such as JSON or XML

***Document Your API***

Provide clear and concise documentation for your API, including information on the available resources, actions, and parameters. This will make it easier for developers to use and integrate with your API.

❌Wrong:

* No API documentation :)

✔️Correct:

* Providing clear and concise documentation for all API endpoints, including the available resources, actions, and parameters.

