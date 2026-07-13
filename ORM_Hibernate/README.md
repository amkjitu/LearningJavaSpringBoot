## ORM - Object Relational Mapping

Object Relational Mapping (ORM) is a programming technique for converting data between incompatible type systems in object-oriented programming languages. It allows developers to work with databases using object-oriented paradigms, abstracting away the underlying database operations.

Hibernate is a popular ORM tool for Java applications that provides a framework for mapping object-oriented domain models to relational databases. 
    * ORMs are actually converts into SQL queries and execute them on the database. 
    * So there is a performance overhead of using ORM tools. 
    * However, they provide significant benefits in terms of development speed, maintainability, and code readability.

Other ORM Tools: Laravel Eloquent, Django ORM, SQLAlchemy, DOTNET Entity Framework, Sequelize, TypeORM, Doctrine ORM, GORM, ActiveRecord. It simplifies database interactions by allowing developers to work with Java objects instead of writing complex SQL queries.

Spring Data JPA is a part of the Spring Framework that provides an abstraction layer for data access. It simplifies the implementation of data access layers by providing a repository-based approach to interact with databases.

Behind the scenes, Spring Data JPA uses Hibernate as the default ORM provider, allowing developers to leverage Hibernate's capabilities while benefiting from Spring's features.

## Hibernate Framework

Hibernate is a widely used ORM framework for Java applications. It provides a powerful and flexible way to map Java objects to relational database tables, allowing developers to work with databases using object-oriented paradigms.

Hibernate provides a rich set of features, including:
- Object-Relational Mapping: Hibernate allows developers to define mappings between Java classes and database tables, enabling seamless persistence of objects to the database.
- Query Language: Hibernate provides its own query language called Hibernate Query Language (HQL), which allows developers to write database queries using object-oriented syntax.
- Caching: Hibernate supports caching mechanisms to improve performance by reducing the number of database queries.
- Transactions: Hibernate provides support for managing transactions, ensuring data integrity and consistency.
- Annotations: Hibernate supports annotations for defining mappings and configurations, making it easier to work with Hibernate in a declarative manner.
- Configuration: Hibernate provides flexible configuration options, allowing developers to customize the behavior of the framework according to their application's needs.
- Relationships: Hibernate supports various types of relationships between entities, including one-to-one, one-to-many, many-to-one, and many-to-many, allowing developers to model complex data structures.
- Integration with Spring: Hibernate can be easily integrated with the Spring Framework, allowing developers to leverage Spring's features while using Hibernate for data access.
- Performance Optimization: Hibernate provides various performance optimization techniques, such as lazy loading, batch fetching, and query caching, to improve the efficiency of database operations.
- Community Support: Hibernate has a large and active community, providing extensive documentation, tutorials, and forums for developers to seek help and share knowledge.

How to use Hibernate in a Spring Boot application:
1. Add Hibernate dependencies to your Spring Boot project's build file (e.g., Maven or Gradle).
2. Configure the database connection properties in the resources/hibernate.cfg.xml file.
3. Create entity classes that represent the database tables and annotate them with Hibernate annotations (e.g., @Entity, @Table, @Id, @Column).
4. Create a repository interface that extends JpaRepository or CrudRepository to perform CRUD operations on the entity classes.
5. Use the repository in your service classes to interact with the database and perform operations on the entities.
6. Optionally, you can configure additional Hibernate settings, such as caching, transaction management, and query optimization, in the application.properties or application.yml file.
7. Run your Spring Boot application, and Hibernate will handle the mapping of Java objects to database tables, allowing you to perform database operations using object-oriented paradigms.


