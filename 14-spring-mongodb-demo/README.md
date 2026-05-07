# 14-spring-mongodb-demo

This module is a Spring Boot and Spring Data MongoDB demo centered on an `Author` document. It shows how to build a small REST API on top of MongoDB while reusing a generic service layer and a custom repository implementation for targeted updates.

## Demo Idea

The demo is designed to show the basic flow of a MongoDB-backed Spring application:

Request -> Controller -> Service -> Repository -> MongoDB

The domain is intentionally small so the focus stays on the Spring Data MongoDB concepts:

- `Author` is stored as a Mongo document.
- Author names are unique.
- Reads use `MongoRepository` and a custom email query.
- Updates are split between normal repository saves and a custom `MongoTemplate` update.

## What We Added In This Demo

Compared with a plain CRUD example, this module adds:

- A reusable generic `BaseService` for common Mongo CRUD operations.
- A Mongo document model with `@Document(collection = "authors")`.
- A unique index on `Author.name` with `@Indexed(unique = true)`.
- A repository query that finds an author by email and returns only selected fields.
- A custom repository implementation that updates author data using `MongoTemplate`.
- A dedicated endpoint for updating author details by email.
- A startup check that verifies the MongoDB connection and prints the current author count.

## Domain Model

### Author

- Collection: `authors`
- Fields: `id`, `name`, `phone`, `email`
- Constraint: `name` is unique

## Code Structure

```text
src/main/java/com/global/book
  SpringDataMongodbApplication.java
  ServletInitializer.java
  StartupApp.java
  controller/
    AuthorController.java
  entity/
    Author.java
  repo/
    AuthorRepo.java
    CustomeAuthorRepo.java
    CustomAuthorImplRepo.java
  service/
    BaseService.java
    AuthorService.java
src/main/resources
  application.properties
```

## How It Works

- `AuthorController` exposes REST endpoints for create, read, update, delete, lookup by email, and custom update-by-email behavior.
- `AuthorService` extends `BaseService` to reuse the common Mongo CRUD logic and adds author-specific rules.
- `BaseService` uses `MongoRepository` methods such as `insert`, `save`, `findAll`, and `deleteById`.
- `AuthorRepo` provides the standard Mongo repository plus a query method for email lookups.
- `CustomAuthorImplRepo` uses `MongoTemplate.updateFirst(...)` for the specialized update path.

## REST Endpoints

### Authors

- `GET /authors` - list all authors
- `GET /authors/{id}` - get one author by id
- `GET /authors/email/{email}` - get an author by email
- `POST /authors` - create a new author
- `PUT /authors/{id}` - update an author by id
- `PUT /authors/custome` - update an author by email using query parameters
- `DELETE /authors/{id}` - delete an author

## Repository Behavior

- `findByAuthorByEmail(email)` uses `@Query` with field projection so the lookup returns a trimmed result shape.
- `CustomAuthorImplRepo.updateEmail(...)` uses `MongoTemplate` and `updateFirst` for targeted document updates.
- `BaseService.insert(...)` uses `insert()` so new Mongo documents are created explicitly.

## Configuration

The module is configured in `src/main/resources/application.properties`.

Important values:

- MongoDB URI: Atlas connection string in `spring.mongodb.uri`
- Server port: `9090`
- Logging: Spring Data debug and root error level

## Startup Check

`StartupApp` runs on application startup and prints whether the MongoDB connection succeeded by reading the current author count.

## Run The Module

From `14-spring-mongodb-demo`:

```bash
./mvnw spring-boot:run
```

Or build then run:

```bash
./mvnw clean package
java -jar target/spring-data-mongodb-0.0.1-SNAPSHOT.jar
```

## Learning Focus

This demo is useful for learning:

- How Spring Data MongoDB differs from JPA.
- How to model a Mongo document with validation-friendly field constraints.
- When to use `MongoRepository` versus `MongoTemplate`.
- How to factor shared logic into a generic service base.
- How to wire custom repository behavior into a service and controller flow.
