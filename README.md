# Spring Framework Learning Tasks

This repository contains a set of Spring learning projects that move from servlet basics to Spring IoC and JDBC integration.

## Tasks Overview

### 1. [01-Cookies](./01-Cookies) — Cookie Management with Servlets
Demonstrates creating, reading, and deleting HTTP cookies in a Java servlet endpoint.

### 2. [02-Ioc](./02-Ioc) — Inversion of Control (XML Configuration)
Shows bean creation and dependency management using Spring IoC with XML, including `ApplicationContext` vs `BeanFactory` behavior.

### 3. [03-bean-scope](./03-bean-scope) — Bean Scope Demo
Demonstrates Spring bean scopes (singleton and prototype), dependency injection, and basic bean lifecycle behavior in Spring Boot.

### 4. [04-JDBC-Hr-Demo](./04-JDBC-Hr-Demo) — Spring JDBC + REST Demo
Builds a small HR employee API using Spring Boot, `JdbcTemplate`, MySQL, and repository abstraction.

---

## How to Use This Repository

- Open any task folder and follow its README file.
- Build each module independently using Maven Wrapper (`./mvnw`).
- Start with `01-Cookies` and continue in order for a gradual learning path.

## Prerequisites

- Java 17+ (Java 21 recommended for servlet modules)
- Maven (or use each module's Maven Wrapper)
- MySQL (required for `04-JDBC-Hr-Demo`)
