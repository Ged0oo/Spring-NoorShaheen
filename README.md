# Spring Framework Learning Tasks

This repository contains a set of Spring learning projects that move from servlet basics to Spring IoC, JDBC integration, and Spring Data JPA.

## Tasks Overview

### 1. [01-Cookies](./01-Cookies) — Cookie Management with Servlets

Demonstrates creating, reading, and deleting HTTP cookies in a Java servlet endpoint.

### 2. [02-Ioc](./02-Ioc) — Inversion of Control (XML Configuration)

Shows bean creation and dependency management using Spring IoC with XML, including `ApplicationContext` vs `BeanFactory` behavior.

### 3. [03-bean-scope](./03-bean-scope) — Bean Scope Demo

Demonstrates Spring bean scopes (singleton and prototype), dependency injection, and basic bean lifecycle behavior in Spring Boot.

### 4. [04-JDBC-Hr-Demo](./04-JDBC-Hr-Demo) — Spring JDBC + REST Demo

Builds a small HR employee API using Spring Boot, `JdbcTemplate`, MySQL, and repository abstraction.

### 5. [05-data-JDBC-HR](./05-data-JDBC-HR) — Spring Data JDBC HR API

Extends the HR example using Spring Data JDBC repositories, REST controllers, and MySQL integration.

### 6. [06-data-jpa-hr](./06-data-jpa-hr) — Spring Data JPA HR API

Builds the HR API with JPA entities, repository interfaces, and relational mapping between employees and departments.

See module details: [06-data-jpa-hr/README.md](./06-data-jpa-hr/README.md)

### 7. [10-data-jpa-books-project](./10-data-jpa-books-project) — Spring Data JPA Books API

Demonstrates a simple books management API with `Author` and `Book` entities, a many-to-one relationship, and CRUD endpoints built with Spring Data JPA.

See module details: [10-data-jpa-books-project/README.md](./10-data-jpa-books-project/README.md)

### 8. [11-data-jpa-books-project](./11-data-jpa-books-project) — Spring Data JPA Books API Plus

An expanded version of the books demo that adds author-to-books collection handling, entity graphs, DTO-based book reads, calculated fields, and delete-by-author behavior.

See module details: [11-data-jpa-books-project/README.md](./11-data-jpa-books-project/README.md)

### 9. [14-spring-mongodb-demo](./14-spring-mongodb-demo) — Spring Data MongoDB Author API

Demonstrates a MongoDB-backed author service with a generic CRUD base class, unique author names, a custom `MongoTemplate` update path, and a lookup by email.

See module details: [14-spring-mongodb-demo/README.md](./14-spring-mongodb-demo/README.md)

---

## How to Use This Repository

- Open any task folder and follow its README file.
- Build each module independently using Maven Wrapper (`./mvnw`).
- Start with `01-Cookies` and continue in order for a gradual learning path.
- For the JPA demos, compare how the HR module and the books module model relationships in different business domains.

## Prerequisites

- Java 17+ (Java 21 recommended for servlet modules)
- Maven (or use each module's Maven Wrapper)
- MySQL (required for `04-JDBC-Hr-Demo`, `05-data-JDBC-HR`, and `06-data-jpa-hr`)
