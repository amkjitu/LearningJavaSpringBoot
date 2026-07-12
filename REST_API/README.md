## REST API (Representational State Transfer)
### 1: REST API Introduction, REST API Architecture
REST (Representational State Transfer) is an architectural style for designing networked applications. It relies on a stateless, client-server communication protocol, typically HTTP. RESTful APIs use standard HTTP methods (GET, POST, PUT, DELETE) to perform CRUD (Create, Read, Update, Delete) operations on resources.

Implementing a REST API involves defining endpoints that correspond to specific resources and actions. Each endpoint should be designed to handle requests and return appropriate responses, often in JSON or XML format.

#### Jersey and Spring are popular frameworks for building RESTful APIs in Java.
1. Jersey is a reference implementation of JAX-RS (Java API for RESTful Web Services) and provides annotations to define RESTful endpoints. Spring Boot simplifies the development of REST APIs by providing built-in support for creating RESTful services with minimal configuration.

Create a Java Project by archetype jersey-quickstart-webapp with Command Line:
```
mvn archetype:generate -DgroupId="com.mycompany.app" -DartifactId="my-jerseyapp" -DarchetypeGroupId="org.glassfish.jersey.archetypes" -DarchetypeArtifactId="jersey-quickstart-webapp" -DarchetypeVersion="2.41" -DinteractiveMode=false
```
Here in this project we have created two resources, one is MyResource.java and RobotResource.java. MyResource.java is a simple resource that returns a "Hello, World!" message when accessed via a GET request. RobotResource.java is a bit more complex and demonstrates how to handle different HTTP methods (GET, POST, PUT, DELETE) for a resource representing a robot:

Phase 1: We use memory storage to store robot data. In a real-world application, you would typically use a database for persistent storage.

Phase 2: We will use database storage to store robot data. In a real-world application, you would typically use a database for persistent storage.


2. Spring is a powerful framework that allows developers to build robust and scalable RESTful APIs. It provides features like dependency injection, request mapping, and exception handling, making it easier to create RESTful services.
