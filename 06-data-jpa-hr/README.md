# 06-data-jpa-hr

A practical Spring Boot module that demonstrates how to build a small HR REST API using Spring Data JPA and MySQL.

## Learning Goals

- Understand how JPA entities map to database tables.
- See how Spring Data repositories reduce boilerplate CRUD code.
- Use a service layer to keep business logic out of controllers.
- Build simple REST endpoints for insert, update, and query operations.
- Work with entity relationships (`Department` <-> `Employee`).

## Tech Stack

- Java 17
- Spring Boot 4.0.4
- Spring Web MVC
- Spring Data JPA
- MySQL (via mysql-connector-j)
- Maven Wrapper

## Project Structure

```text
src/main/java/com/global/hr
  DataJpaHrApplication.java
  controller/
    DepartmentController.java
    EmployeeController.java
  entity/
    Department.java
    Employee.java
  repo/
    DepartmentRepo.java
    EmployeeRepo.java
  service/
    DepartmentService.java
    EmployeeService.java
src/main/resources
  application.properties
```

## Architecture Flow

Request -> Controller -> Service -> Repository -> Database

- Controllers handle HTTP requests and response objects.
- Services handle update logic and fetch checks.
- Repositories provide CRUD and query methods.
- Entities define how Java objects map to SQL tables.

## Entity Mapping

### Department

- Table: `department`
- Primary key: `dnum`
- Name column: `dname`
- Relationship: one department has many employees

### Employee

- Table: `employee`
- Primary key: `ssn`
- Name column: `fname`
- Salary column: `salary`
- Foreign key: `dno` references department
- Relationship: many employees belong to one department

## Repository Layer

### DepartmentRepo

- Extends `CrudRepository<Department, Long>`
- Provides ready-to-use methods such as `save`, `findById`, and `findAll`

### EmployeeRepo

- Extends `CrudRepository<Employee, Long>`
- Includes derived query methods:
  - `findByName(String name)`
  - `findByDepartmentId(Long id)`
- Includes custom queries:
  - JPQL query in `filter(...)`
  - Native SQL query in `filterNative(...)`

Note: the native query currently points to `hr_employees`. If your table is `employee`, update that query accordingly before using it.

## Service Layer Responsibilities

### DepartmentService

- `findById(Long id)`
- `insert(Department dep)`
- `update(Department dep)` with existence check
- `findAll()`

### EmployeeService

- `findById(Long id)`
- `insert(Employee emp)`
- `update(Employee emp)` with existence check
- `findByDepartmentId(Long id)`
- `findAll()`

## REST Endpoints

### Department API

- `GET /department/{id}`: get department by id
- `GET /department`: list all departments
- `POST /department`: create department
- `PUT /department`: update department

### Employee API

- `GET /employee/{id}`: get employee by id
- `GET /employee`: list all employees
- `POST /employee`: create employee
- `PUT /employee`: update employee
- `GET /employee/department/{id}`: list employees by department id

## Configuration

Important values in `src/main/resources/application.properties`:

- `spring.datasource.url=jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true`
- `spring.datasource.username=root`
- `spring.datasource.password=root`
- `spring.jpa.hibernate.ddl-auto=update`
- SQL logging is enabled for learning/debugging.

If your MySQL runs on a different port or credentials, change these values.

## Run the Module

From `06-data-jpa-hr`:

```bash
./mvnw spring-boot:run
```

Or build then run:

```bash
./mvnw clean package
java -jar target/data-jpa-hr-0.0.1-SNAPSHOT.jar
```

## Quick Example Requests

Create a department:

```bash
curl -X POST http://localhost:8080/department \
  -H "Content-Type: application/json" \
  -d '{"name":"IT"}'
```

Create an employee in department 1:

```bash
curl -X POST http://localhost:8080/employee \
  -H "Content-Type: application/json" \
  -d '{"name":"Ali","salary":9000,"department":{"id":1}}'
```

Get all employees in department 1:

```bash
curl http://localhost:8080/employee/department/1
```

## Notes for Understanding

- Start from `DataJpaHrApplication` to see how Spring Boot starts the app.
- Track one request end-to-end (Controller -> Service -> Repository).
- Read entity annotations first (`@Entity`, `@Table`, `@OneToMany`, `@ManyToOne`).
- Focus on how Spring Data derives methods like `findByDepartmentId` from naming.

## Suggested Next Improvements

- Add validation annotations (`@NotBlank`, `@Min`, etc.).
- Add DTOs to avoid exposing entity internals directly.
- Add exception handlers with `@ControllerAdvice`.
- Add integration tests for controller and repository layers.
