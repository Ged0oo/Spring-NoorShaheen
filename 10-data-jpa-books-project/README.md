# 10-data-jpa-books-project

A small Spring Boot demo that shows the total idea of a Spring Data JPA application by modeling a books domain with authors and books.

## Project Idea

This project is built to demonstrate the complete flow of a typical JPA-based REST application:

Request -> Controller -> Service -> Repository -> Database

The domain is intentionally simple so the focus stays on the Spring concepts:

- `Author` is the parent entity.
- `Book` belongs to one `Author` through a many-to-one relationship.
- REST endpoints expose CRUD operations for both entities.
- Spring Data JPA handles persistence with very little boilerplate.

## What This Demo Covers

- JPA entity mapping with `@Entity` and `@Table`.
- Primary key generation with `@GeneratedValue`.
- Relationship mapping with `@ManyToOne` and `@JoinColumn`.
- Repository-based CRUD using `JpaRepository`.
- Service-layer update and delete logic.
- REST controllers for JSON request and response handling.

## Domain Model

### Author

- Table: `author`
- Fields: `id`, `name`

### Book

- Table: `book`
- Fields: `id`, `name`, `price`
- Relationship: each book points to one author using `author_id`

## Package Structure

```text
src/main/java/com/global/book
  DataJpaBooksProjectApplication.java
  controller/
    AuthorController.java
    BookController.java
  entity/
    Author.java
    Book.java
  repository/
    AuthorRepo.java
    BookRepo.java
  service/
    AuthorService.java
    BookService.java
src/main/resources
  application.properties
```

## REST Endpoints

### Authors

- `GET /authors` - list all authors
- `GET /authors/{id}` - get one author by id
- `POST /authors` - create a new author
- `PUT /authors/{id}` - update an author
- `DELETE /authors/{id}` - delete an author

### Books

- `GET /books` - list all books
- `GET /books/{id}` - get one book by id
- `POST /books` - create a new book
- `PUT /books/{id}` - update a book
- `DELETE /books/{id}` - delete a book

## Configuration

The module uses MySQL and is configured through `src/main/resources/application.properties`.

Important values:

- Database URL: `jdbc:mysql://localhost:3306/books?createDatabaseIfNotExist=true`
- Username: `root`
- Password: `root`
- JPA DDL mode: `update`
- Server port: `9090`

## How the App Works

- Controllers accept JSON requests and return JSON responses.
- Services contain the main update/delete rules.
- Repositories provide persistence operations through Spring Data JPA.
- Entities describe how Java objects map to database tables.

## Run the Module

From `10-data-jpa-books-project`:

```bash
./mvnw spring-boot:run
```

Or build then run:

```bash
./mvnw clean package
java -jar target/data-jpa-books-project-0.0.1-SNAPSHOT.jar
```

## Suggested Learning Path

- Start with `Author` and `Book` entities.
- Follow one request from controller to repository.
- Compare the books module with `06-data-jpa-hr` to see the same Spring Data JPA ideas in a different model.