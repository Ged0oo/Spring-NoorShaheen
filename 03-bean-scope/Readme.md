# Spring Boot IoC Container & Bean Scope Demo

This project demonstrates the **core concepts of the Spring
Framework**: - IoC (Inversion of Control) Container - Dependency
Injection (DI) - Bean Scopes - Bean Lifecycle

The goal is to understand how Spring manages objects (Beans) and how
changing the **scope** affects object creation.

------------------------------------------------------------------------

# Project Structure

    notification-system
    ├── src/main/java/com/example/notification
    │   ├── NotificationSystemApplication.java
    │   └── service
    │       ├── MessageService.java
    │       └── EmailService.java
    └── pom.xml

------------------------------------------------------------------------

# Core Concepts Demonstrated

## 1. IoC Container

Instead of creating objects manually using:

    MyService service = new MyService();

Spring creates and manages objects inside the **IoC Container**.

We retrieve objects using:

    ApplicationContext context = SpringApplication.run(App.class, args);
    MyService service = context.getBean(MyService.class);

The container handles: - Object creation - Dependency wiring - Lifecycle
management

------------------------------------------------------------------------

# 2. Dependency Injection

Spring automatically injects dependencies between beans.

Example:

    @Service
    public class EmailService implements MessageService {
        public String getMessage() {
            return "Notification sent by Email";
        }
    }

The class is registered as a **Spring Bean** using `@Service`.

------------------------------------------------------------------------

# 3. Bean Scope Demonstration

By default, Spring uses:

## Singleton Scope

Only **one instance** exists for the entire application.

    @Service
    public class EmailService implements MessageService

Output:

    Constructor called once
    service1 == service2 -> true

------------------------------------------------------------------------

## Prototype Scope

A **new instance** is created every time the bean is requested.

    @Service
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class EmailService implements MessageService

Output:

    Constructor called
    Constructor called
    service1 == service2 -> false

------------------------------------------------------------------------

# 4. Bean Lifecycle

Spring Beans follow this lifecycle:

1.  Instantiate bean (Constructor)
2.  Inject dependencies
3.  Run initialization method

Example:

    @PostConstruct
    public void init() {
        System.out.println("Bean initialized");
    }

Before application shutdown:

    @PreDestroy
    public void destroy() {
        System.out.println("Bean destroyed");
    }

Note: Spring **does not automatically destroy Prototype beans**.

------------------------------------------------------------------------

# 5. Testing Bean Scope

Main class example:

    @SpringBootApplication
    public class NotificationSystemApplication {

        public static void main(String[] args) {

            ApplicationContext context =
                SpringApplication.run(NotificationSystemApplication.class, args);

            MessageService service1 = context.getBean(MessageService.class);
            MessageService service2 = context.getBean(MessageService.class);

            System.out.println(service1 == service2);
        }
    }

------------------------------------------------------------------------

# Expected Results

Singleton:

    true

Prototype:

    false

------------------------------------------------------------------------

# Technologies Used

-   Java
-   Spring Boot
-   Spring IoC Container
-   Maven

------------------------------------------------------------------------

# How to Run

1.  Clone the project

```{=html}
<!-- -->
```
    git clone <repo-url>

2.  Build project

```{=html}
<!-- -->
```
    mvn clean install

3.  Run application

```{=html}
<!-- -->
```
    mvn spring-boot:run

------------------------------------------------------------------------

# Learning Goals

After completing this demo you should understand:

-   What the Spring IoC Container does
-   How Beans are managed
-   The difference between Singleton and Prototype scope
-   How Spring initializes beans

------------------------------------------------------------------------

Author: Mohamed Nagy
