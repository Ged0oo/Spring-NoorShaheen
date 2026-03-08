# 02-Ioc: Inversion of Control with Spring Framework

## Overview

This task demonstrates the **Inversion of Control (IoC)** pattern using the Spring Framework. It shows how Spring manages object creation and dependency injection through XML configuration, allowing you to understand the core principle behind the Spring Framework.

## What This Application Does

The application demonstrates two approaches to managing beans (Spring-managed objects):

1. **ApplicationContext**: Eager loading of beans - all beans are created when the context is initialized
2. **BeanFactory**: Lazy loading of beans - beans are created only when explicitly requested

## How It Works

### Application Components

#### 1. UserBean Class
A simple POJO (Plain Old Java Object) that represents a user with a name property:

```java
public class UserBean implements Serializable {
    private String name;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public void displayInfo() {
        System.out.println("Hello From Bean => " + name);
    }
}
```

#### 2. Spring XML Configuration (beans.xml)
Defines how Spring should create and configure the UserBean:

```xml
<bean id="myUserBean" class="UserBean">
    <property name="name" value="Mohamed Nagy" />
</bean>
```

This tells Spring to:
- Create a bean with ID `myUserBean`
- Instantiate the `UserBean` class
- Set the `name` property to "Mohamed Nagy"

#### 3. MainApp - The Bootstrap Class
Demonstrates both IoC approaches:

```java
// 1. ApplicationContext (Eager Loading)
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
UserBean appBean = (UserBean) context.getBean("myUserBean");

// 2. BeanFactory (Lazy Loading)
DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
UserBean factoryBean = (UserBean) factory.getBean("myUserBean");
```

## Key Concepts

### Inversion of Control (IoC)
Instead of your code creating objects directly (e.g., `new UserBean()`), you let Spring manage object creation and configuration. This provides:
- **Loose Coupling**: Objects don't need to know how to create their dependencies
- **Flexibility**: Change configuration without modifying code
- **Testability**: Easy to inject mock objects for testing

### ApplicationContext vs BeanFactory

| Feature | ApplicationContext | BeanFactory |
|---------|-------------------|------------|
| Loading | Eager (all beans on startup) | Lazy (beans on demand) |
| Features | Rich features (AOP, events) | Core IoC only |
| Performance | Initial load slower | Initial load faster |
| Use Case | Production apps | Lightweight apps |

## How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.6.0 or higher
- Spring Framework libraries (configured in pom.xml)

### Build and Run
```bash
cd 02-Ioc
mvn clean package
mvn exec:java -Dexec.mainClass="MainApp"
```

## Expected Output

```
--- Starting ApplicationContext (Eager Loading) ---
Hello From Bean => Mohamed Nagy

--- Starting BeanFactory (Lazy Loading) ---
Hello From Bean => Mohamed Nagy
```

## Learning Outcomes

After completing this task, you should understand:
- ✅ What Inversion of Control (IoC) is and why it's important
- ✅ How Spring's IoC container manages beans
- ✅ Difference between ApplicationContext and BeanFactory
- ✅ How to configure beans using XML
- ✅ The difference between eager and lazy loading
- ✅ How dependency injection works through property setting

## Next Steps

- Explore annotation-based configuration (`@Component`, `@Bean`)
- Learn about constructor and setter injection
- Understand bean scopes (singleton, prototype, request, session)
- Discover how Spring manages bean lifecycles
