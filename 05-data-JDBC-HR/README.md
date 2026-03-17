# 05-data-JDBC-HR

A Spring Boot demo project that builds a simple HR REST API using **Spring Data JDBC** and **MySQL**.

## What this module demonstrates

- Using `CrudRepository` for database access with minimal boilerplate.
- Mapping Java entity fields to existing database columns using `@Table` and `@Column`.
- Exposing basic REST endpoints for create and read operations.
- Query derivation with Spring Data JDBC (`findByName`).

## Tech Stack

- Java 17+
- Spring Boot 4
- Spring Data JDBC
- MySQL Connector/J
- Maven Wrapper (`./mvnw`)

## Project Structure

- `src/main/java/com/global/hr/entity/Employee.java` → entity mapped to table `employee`
- `src/main/java/com/global/hr/repo/EmployeeRepo.java` → repository interface
- `src/main/java/com/global/hr/controller/EmployeeController.java` → REST endpoints
- `src/main/resources/application.properties` → DB connection config

## Database Configuration

Current configuration in `application.properties`:

- `spring.datasource.url=jdbc:mysql://localhost:3306/iti`
- `spring.datasource.username=root`
- `spring.datasource.password=root`

Update these values if your local MySQL setup is different.

## Data Model Mapping

`Employee` is mapped as:

- Table: `employee`
- Primary key: Java `id` ↔ DB column `ssn`
- Name: Java `name` ↔ DB column `fname`
- Salary: Java `salary` ↔ DB column `salary`

## API Endpoints

Base path: `/employee`

- `GET /employee/count` → total number of employees
- `GET /employee/{id}` → employee by id (mapped to `ssn`)
- `GET /employee/` → all employees
- `POST /employee/new` → create employee
- `GET /employee/name/{name}` → search by name using path variable
- `GET /employee/search?name=...` → search by name using query parameter

### Example create request

```http
POST /employee/new
Content-Type: application/json

{
  "id": 12,
  "name": "Noor",
  "salary": 7000
}
```

## Run the project

From module root (`05-data-JDBC-HR`):

```bash
./mvnw spring-boot:run
```

Or package first:

```bash
./mvnw clean package
java -jar target/data-jdbc-hr-demo-0.0.1-SNAPSHOT.jar
```

## Notes

- Ensure MySQL is running and database `iti` exists.
- Ensure table `employee` exists with columns compatible with the mapping (`ssn`, `fname`, `salary`).
