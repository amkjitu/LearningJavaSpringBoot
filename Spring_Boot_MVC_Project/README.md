## Simple Ecommerce Application with Spring Boot MVC

Backend: spring boot

Frontend: react

### Project Details:
This is a simple e-commerce application built using Spring Boot for the backend and React for the frontend. The application allows users 
  - Browse products
  - Add products
  - Edit products
  - Delete products
  - View product details
  - Search for products
  - Add products to the cart

#### Backend Details:
- The backend is built using Spring Boot
- It provides RESTful APIs for managing products and handling user requests
- It uses Spring Data JPA for database operations and Hibernate as the ORM framework
- It uses H2 database for development and testing purposes
- It is structured into different layers, including controllers, services, and repositories, models, following the MVC architecture
  - Controllers handle incoming HTTP requests and return appropriate responses
  - Services contain the business logic and interact with the repositories
  - Repositories handle database operations and provide an abstraction layer for data access
  - Models represent the data structure and business rules
- The backend uses Lombok for reducing boilerplate code and simplifying the development process

#### Frontend Details:
- The frontend is built using React
- It provides a user-friendly interface for browsing and managing products
- It communicates with the backend APIs to perform CRUD operations on products
- It uses React Router for navigation and state management libraries like Redux or Context API for managing application state

Note: As we are focusing on Spring Boot MVC, the frontend part is just a simple React application.