# LAB 3

## Accessing databases in SpringBoot

> **Java Persistence API (JPA)** specification lets you define which objects should be persisted, and how those objects should be persisted in your Java applications.

> **Hibernate** is concerned with data persistence as it applies to relational databases

> **ORM** is a programming technique for converting data between incompatible type systems using object-oriented programming languages

> **Spring Data** purpose is to unify and ease the access to different kinds of persistence stores, both relational database systems and NoSQL

> **@Entity**: Entities in JPA are nothing but Java objects representing data that can be persisted to the database. An entity represents a table stored in a database. Every instance of an entity represents a row in the table.

## Exercise 3.1 b) questions

- The new repository is instantiated by using the anotation **@Autowired**. This means that, when the controller is instantiated, it will inject a new object automatically.

- The methods called by the userRepository, that are defined in the CrudRepository<>, are:
    - findAll()
    - findById(long id)
    - save(User user) 
    - delete(User user)

-
    