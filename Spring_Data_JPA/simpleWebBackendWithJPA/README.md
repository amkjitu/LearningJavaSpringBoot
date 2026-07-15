# simpleWebBackendWithJPA

This project is a small Spring Boot backend that demonstrates Spring Data JPA with an in-memory H2 database.

## What is in this project

- Spring Web for REST endpoints
- Spring Data JPA for database access
- H2 database for local in-memory storage
- A product CRUD API
- An H2 console at `/h2-console` that allows you to view the database UI contents

## What we built

- `HomeController` returns basic home/about text
- `ProductController` exposes REST endpoints for CRUD operations
- `ProductService` talks to the JPA repository
- `ProductRepo` extends `JpaRepository`
- `Product` is the JPA entity
- `H2ConsoleConfiguration` registers the H2 console servlet

## How to run

1. Open the project in your IDE.
2. Run the Spring Boot application.
3. Open `http://localhost:82/` in the browser.
4. Open `http://localhost:82/h2-console` for the database console.

## H2 console login

- **JDBC URL:** `jdbc:h2:mem:learningspringjpa`
- **Driver Class:** `org.h2.Driver`
- **Username:** `sa`
- **Password:** leave blank

## API endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/` | Home text |
| GET | `/about` | About text |
| GET | `/products` | List all products |
| GET | `/products/{id}` | Get one product |
| POST | `/products` | Create a product |
| PUT | `/products` | Update a product |
| DELETE | `/products/{id}` | Delete a product |

## Example request body

```json
{
  "id": 104,
  "productName": "Product 4",
  "productPrice": 400
}
```

## Notes

- The H2 console is registered directly in code so it works with this Spring Boot version.
- Data is temporary because the database runs in memory.
