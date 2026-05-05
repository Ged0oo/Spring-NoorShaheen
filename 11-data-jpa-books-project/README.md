# 11-data-jpa-books-project

This module is an evolved Spring Boot and Spring Data JPA books demo. It keeps the same core books domain, then adds more realistic JPA behavior around relationships, loading strategy, and derived data.

## Demo Idea

The idea is to show how a small books system can be modeled with Spring Data JPA while still covering more than the basic CRUD flow:

Request -> Controller -> Service -> Repository -> Database

The domain is based on two entities:

- `Author` is the parent side.
- `Book` belongs to one `Author` through a many-to-one relationship.

This version goes a bit further than the earlier books demo by showing how to work with a full author -> books graph, how to avoid lazy-loading surprises, and how to expose only the response shape you want from an API.

## What Was Added In This Version

Compared with the earlier books module, this one adds:

- An `Author.books` one-to-many collection with helper methods to add and remove books.
- A `bookCount` formula on `Author` that reflects the number of books in the database.
- A `bookCount` formula on `Book` as an example of a computed database-backed field.
- A `discount` field on `Book` that is calculated after loading with `@PostLoad`.
- A named entity graph on `Book` so book reads can fetch the linked author cleanly.
- A custom `findAll()` implementation in `AuthorRepo` that loads books with `@EntityGraph`.
- A `GET /books/{id}` response that returns a `BookDto` instead of the full entity.
- A `DELETE /books/author/{id}` endpoint for removing all books for one author.
- Partial update behavior in `BookService`, where only provided fields are changed.
- Basic service-level validation for missing author names and not-found records.

## Domain Model

### Author

- Table: `author`
- Fields: `id`, `name`
- Extra: `bookCount`, `books`

### Book

- Table: `book`
- Fields: `id`, `name`, `price`
- Relationship: each book points to one author using `author_id`
- Extra: `bookCount`, `discount`

## How the JPA Mapping Works

- `Author` uses `@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)` to represent the collection of books.
- `Book` uses `@ManyToOne(fetch = FetchType.LAZY)` with `@JoinColumn(name = "author_id")`.
- `AuthorRepo.findAll()` uses `@EntityGraph(attributePaths = {"books"})` so authors are returned with their books when needed.
- `BookRepo.findAll()` and `BookRepo.findById()` use the `loadAuthor` entity graph so the linked author is loaded when reading books.

## REST Endpoints

### Authors

- `GET /authors` - list all authors with their books
- `GET /authors/{id}` - get one author by id
- `POST /authors` - create a new author
- `PUT /authors/{id}` - update an author
- `DELETE /authors/{id}` - delete an author

### Books

- `GET /books` - list all books with their authors
- `GET /books/{id}` - get one book by id as a DTO
- `POST /books` - create a new book
- `PUT /books/{id}` - update a book partially
- `DELETE /books/{id}` - delete a book
- `DELETE /books/author/{id}` - delete all books for one author

## Services

- `AuthorService` handles author lookup, insert, bulk insert, update, and delete rules.
- `BookService` handles book lookup, insert, partial update, delete, and bulk delete by author.
- Both services throw runtime errors when an expected record is missing so the API behavior stays explicit.

## Configuration

The module uses MySQL and is configured in `src/main/resources/application.properties`.

Important values:

- Database URL: `jdbc:mysql://localhost:3306/books?createDatabaseIfNotExist=true`
- Username: `root`
- Password: `root`
- JPA DDL mode: `update`
- Server port: `9090`

## Run The Module

From `11-data-jpa-books-project`:

```bash
./mvnw spring-boot:run
```

Or build then run:

```bash
./mvnw clean package
java -jar target/data-jpa-books-project-0.0.1-SNAPSHOT.jar
```

## Learning Focus

This demo is useful for learning:

- JPA relationship mapping in both directions.
- How `@EntityGraph` changes loading behavior.
- The difference between entity responses and DTO responses.
- How computed fields and `@PostLoad` can enrich API data.
- How to structure a small Spring Boot app with controller, service, repository, and entity layers.
