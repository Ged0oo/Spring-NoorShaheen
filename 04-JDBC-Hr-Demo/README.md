# 04-JDBC-Hr-Demo: Spring JDBC HR API

## Overview

This module is a Spring Boot JDBC demo for a simple HR employee API.
It uses MySQL and `JdbcTemplate` to query and manage employee records.

## Features

- REST endpoints for employee data
- Repository abstraction through `EmployeeRepos`
- JDBC implementation using `JdbcTemplate`
- Optional named-parameter JDBC implementation (`EmployeeHDBCRepoNamedParam`)

## Project Structure

```text
04-JDBC-Hr-Demo/
├── src/main/java/com/global/hr
│   ├── controller/EmployeeController.java
│   ├── repos/EmployeeRepos.java
│   ├── repos/impl/EmployeeHDBCRepo.java
│   ├── mapper/EmployeeMapper.java
│   ├── model/Employee.java
│   └── JdbcHrDemoApplication.java
└── src/main/resources/application.properties
```

## Database Configuration

The application expects a MySQL database configured in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/iti
spring.datasource.username=root
spring.datasource.password=root
```

Create the employee table used by the app:

```sql
CREATE TABLE iti.employee (
  ssn BIGINT PRIMARY KEY,
  fname VARCHAR(100) NOT NULL,
  salary DOUBLE
);
```

## API Endpoints

Base path: `/employee`

- `GET /employee/count` → returns employee count
- `GET /employee/{id}` → returns employee by `ssn`
- `GET /employee` → returns all employees

## Run the Module

```bash
cd 04-JDBC-Hr-Demo
./mvnw spring-boot:run
```

Then test:

- `http://localhost:8080/employee/count`
- `http://localhost:8080/employee/1`
- `http://localhost:8080/employee`

## Learning Outcomes

After this module, you should understand:

- How to use Spring JDBC in a layered design
- How `RowMapper` converts SQL rows to Java objects
- How to expose repository data through Spring REST controllers
- How to switch between standard and named-parameter JDBC style

---

Back to [Main Directory](../README.md)