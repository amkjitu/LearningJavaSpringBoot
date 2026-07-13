## Spring Framework
Spring Framework is a powerful and widely used framework for building Java applications. It provides comprehensive infrastructure support for developing robust and scalable applications, including web applications, enterprise applications, and microservices.

Spring Framework promotes the use of dependency injection, aspect-oriented programming, and modular architecture, making it easier to develop maintainable and testable code.

While Spring Boot is a part of the Spring ecosystem, simplifies the process of building and deploying Spring applications by providing opinionated defaults and auto-configuration.

Note: Spring Framework overcomes the drawbacks of traditional Java EE development by providing a more lightweight and flexible approach to building applications. It allows developers to focus on business logic rather than boilerplate code, resulting in faster development cycles and improved productivity.

### Here to learn we will develop a simple E-commerce project:
* Spring Boot
* Spring Data JPA
* MySQL database

The project will demonstrate the core concepts of Spring Framework, including dependency injection, RESTful API development, and database interaction.

IOC (Inversion of Control): This is a design principle in which the control of object creation and dependency management is inverted from the application code to a container or framework. In Spring, the IoC container is responsible for managing the lifecycle and configuration of application components.

Dependency Injection (DI): This refers to the process of providing an object with its dependencies rather than allowing it to create them itself. Spring's DI container manages the lifecycle and configuration of application components, promoting loose coupling and easier testing.

### Spring Boot

Spring Boot is a framework that simplifies the development of Spring applications by providing a set of conventions and defaults. It handles server configuration, dependency management, database and application setup.

#### Components of Spring Boot:
1. Spring Boot Starter: A set of pre-configured dependencies that simplify the setup of common application features, such as web development, data access, and security.
2. Spring Boot Auto-Configuration: Automatically configures the application based on the dependencies present in the classpath, reducing the need for manual configuration.
3. Spring Boot CLI: A command-line interface that allows developers to quickly create and run Spring Boot applications using Groovy scripts.
4. Spring Boot Actuator: Provides production-ready features for monitoring and managing Spring Boot applications, including metrics, health checks, and application insights.
5. Spring Boot DevTools: A set of tools that enhance the development experience by providing features like automatic restarts, live reload, and remote debugging.
6. Spring Boot Testing: Provides support for testing Spring Boot applications, including unit tests, integration tests, and end-to-end tests.

#### Steps to create a simple Spring Boot application:
1. Create a new Spring Boot project using Spring Initializr (https://start.spring.io/)
2. Choose the project metadata (Group, Artifact, Name, Description, Package Name)
3. Select the dependencies required for the project (e.g., Spring Web, Spring Data JPA, MySQL Driver)
4. Generate the project and download the ZIP file
5. Extract the ZIP file and open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse)
6. Configure the application properties (e.g., database connection settings) in the application.properties or application.yml file
7. Create the necessary packages and classes for your application (e.g., controllers, services, repositories, entities)
8. Implement the business logic and RESTful endpoints for your application
9. Run the Spring Boot application and test the endpoints using tools like Postman
10. Deploy the application to a server or cloud platform (e.g., AWS, Heroku) for production use.

#### BUT for now we will only focus on the core concepts and basic implementation.
1. Create a new Spring Boot project using Spring Initializr (https://start.spring.io/)
2. Choose the project metadata (Group, Artifact, Name, Description, Package Name)