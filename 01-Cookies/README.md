# 01-Cookies: Cookie Management with Java Servlets

## Overview

This task demonstrates how to work with HTTP cookies in a Java servlet-based web application. The application creates, manages, and displays cookies using the Jakarta Servlet API (jakarta.servlet).

## What This Application Does

The `HelloServlet` application handles HTTP GET requests at the `/hello` endpoint and demonstrates the complete cookie lifecycle:

1. **Cookie Creation**: Creates two cookies with user-provided names (first name and last name)
2. **Cookie Storage**: Sets an expiration time of 24 hours for the cookies
3. **Cookie Retrieval**: Reads and displays all cookies stored in the request
4. **Cookie Deletion**: Demonstrates deleting a specific cookie by setting its max age to 0

## How It Works

### Request Flow

When you access the servlet at `/hello?firstName=John&lastName=Doe`:

```
1. User sends GET request with parameters
2. Servlet creates two Cookie objects from the parameters
3. Cookies are added to the HTTP response with a 24-hour expiration
4. Servlet retrieves all cookies from the request
5. Cookies are displayed in an HTML response
6. The "first_name" cookie is deleted (max age set to 0)
```

### Key Code Components

**Cookie Creation:**
```java
Cookie firstName = new Cookie("first_name", request.getParameter("firstName"));
Cookie lastName = new Cookie("last_name", request.getParameter("lastName"));

firstName.setMaxAge(60 * 60 * 24); // 24 hours in seconds
lastName.setMaxAge(60 * 60 * 24);

response.addCookie(firstName);
response.addCookie(lastName);
```

**Cookie Retrieval and Display:**
```java
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        out.print("Name: " + cookie.getName() + ", ");
        out.print("Value: " + cookie.getValue() + "<br/>");
    }
}
```

**Cookie Deletion:**
```java
if (cookie.getName().compareTo("first_name") == 0) {
    cookie.setMaxAge(0); // Delete by setting max age to 0
    response.addCookie(cookie);
}
```

## Building and Running

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- A servlet container (Tomcat, Jetty, etc.)

### Build the Project

```bash
cd 01-Cookies
./mvnw clean package
```

This creates a WAR file at `target/demo1-1.0-SNAPSHOT.war` ready for deployment.

### Deploy to Tomcat

1. Copy the WAR file to your Tomcat `webapps` directory
2. Start Tomcat
3. Access the servlet at: `http://localhost:8080/demo1-1.0-SNAPSHOT/hello?firstName=John&lastName=Doe`

## Example Usage

### Request
```
GET /demo1-1.0-SNAPSHOT/hello?firstName=John&lastName=Doe
```

### Response
The servlet responds with an HTML page showing:
```
Cookies Name and Value
Deleted cookie: first_name
Name: JSESSIONID, Value: <session-id>
Name: last_name, Value: Doe
Name: first_name, Value: John
```

## Key Concepts Demonstrated

1. **HTTP Cookies**: Understanding how cookies are created and sent in HTTP responses
2. **Cookie Expiration**: Setting cookie lifespan using `setMaxAge()`
3. **Cookie Deletion**: Removing cookies by setting max age to 0
4. **Request Parameters**: Extracting URL parameters using `getParameter()`
5. **Response Writing**: Generating HTML responses from servlets
6. **Servlet Annotations**: Using `@WebServlet` to map URLs to servlet classes

## Technologies Used

- **Java 21**: The programming language
- **Jakarta Servlet API 6.1.0**: Modern servlet specification
- **javax.servlet API 4.0.1**: Legacy servlet API (for compatibility)
- **Maven**: Build automation tool
- **JUnit 5**: Testing framework (included for future unit tests)

## File Structure

```
01-Cookies/
├── pom.xml                          # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── HelloServlet.java   # Main servlet implementation
│   │   └── resources/               # Static resources
│   └── test/
│       ├── java/                    # Test classes
│       └── resources/               # Test resources
└── target/                          # Compiled output and WAR file
```

## Dependencies

| Dependency | Version | Purpose |
|-----------|---------|---------|
| Jakarta Servlet API | 6.1.0 | Modern servlet specification |
| javax.servlet API | 4.0.1 | Legacy servlet API compatibility |
| JUnit Jupiter | 5.13.2 | Unit testing framework |

## Learning Outcomes

After studying this task, you will understand:
- ✅ How to create HTTP cookies in Java servlets
- ✅ How to set cookie properties (name, value, expiration)
- ✅ How to retrieve and display cookies
- ✅ How to delete cookies
- ✅ How to deploy and run servlet applications
- ✅ The difference between Jakarta and javax servlet APIs

## Further Exploration

You might want to enhance this application by:
- Adding a form to collect user input instead of URL parameters
- Persisting cookie data to a database
- Implementing cookie encryption for sensitive data
- Creating a logout feature that clears all cookies
- Adding validation to prevent malicious cookie values

---

**Back to [Main Directory](../README.md)**
