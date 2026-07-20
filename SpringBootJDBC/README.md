## Spring Boot JDBC
We already have seen the JDBC in the Core Java section. Now we will see how to use JDBC in Spring Boot. Spring Boot provides a simplified way to work with databases using JDBC. It offers features like automatic configuration, connection pooling, and easy integration with various database systems.

In this project we added two dependencies while creating the Spring Boot Project:
1. JDBC API: This dependency provides the necessary classes and interfaces for working with JDBC in Java. It allows us to establish database connections, execute SQL queries, and retrieve results.
2. H2 Database: H2 is an open-source, in-memory database that is lightweight and easy to use. It is often used for development and testing purposes. In this project, we will use H2 as our database to demonstrate JDBC operations.

And created following files under `src/main/resources`:
1. schema.sql to define the database schema.
2. data.sql to insert initial data into the database.

### How to use Spring Boot JDBC in this project:
1. Create a Spring Boot project with the necessary dependencies (JDBC API and H2 Database).
2. Configure the database connection properties in the application.properties file. For example, you can specify the database URL, username, and password.
3. Create a model class that represents the data you want to store in the database. This class should have fields corresponding to the columns in the database table.
4. Create a repository class that will handle the database operations using JDBC. This class will use the JdbcTemplate provided by Spring Boot to execute SQL queries and perform CRUD operations.
5. For simplicity, we are skipping the service layer and directly interacting with the repository from the main application class.

### How Spring JDBC Template works:
The Spring JDBC Template is a powerful utility class that simplifies the process of working with JDBC. It provides methods for executing SQL queries, updating records, and mapping result sets to Java objects. The JdbcTemplate handles the boilerplate code involved in JDBC operations, such as opening and closing connections, preparing statements, and handling exceptions. It also provides support for parameterized queries, batch updates, and transaction management. 

By using the JdbcTemplate, developers can focus on writing the SQL queries and mapping the results to Java objects, without worrying about the low-level details of JDBC.

### Next will learn JPA: 
Which will actually let us know about why we will use it on top of Hibernate ORM.
Suppose you don't want to use Hibernate rather want to use Jimmer/jOOQ (type-safe SQL builder)/MyBatis (SQL mapping) then it will be harder. But as Hibernate ORM follows Java Persistence API so it will be easier.

#### Recall What is JPA:
JPA stands for Java Persistence API (now known as Jakarta Persistence API). It is a standard Java specification used for Object-Relational Mapping (ORM). JPA allows developers to easily manage relational database data using Java objects rather than writing complex, manual SQL queries.