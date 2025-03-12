This is the proper file for crud operations including crud apis

working -
                                                       
                                                                        (Internally calls Repository which extends JpaRespository)     
                                                                                        |<------>Repository
                                                                                        |
    client---(send http request)--->Controller---(decides which service is to be called)---> Service---(it then perform operation on)--->Model(entity)
                                                                                        |                                                     |       
                                                                                        |--------->DataBase<-------------JPA/SpringData<------|





### A comprehensive understanding of Hibernate and JPA (Java Persistence API) in Spring Boot involves both conceptual and practical knowledge of how to manage data persistence effectively in a Java application. Below is a complete guide covering the essentials of Hibernate, JPA, and how to use them to implement CRUD operations in Spring Boot.
## What is JPA?
   Java Persistence API (JPA) is a specification for object-relational mapping (ORM) in Java. It defines how Java objects can be stored, retrieved, and managed in relational databases.
   JPA is not an implementation but a set of interfaces. Hibernate is one of the most popular implementations of JPA. 
   
## What is Hibernate?
   Hibernate is an ORM framework that implements JPA and provides a way to map Java classes (entities) to database tables. It abstracts the database interaction, reducing the need for boilerplate SQL code. 
   
## Key Concepts of JPA/Hibernate:
   ### Entity:

    A class that represents a table in the database.
    Annotated with @Entity.
    Fields are mapped to columns in the database table.
    Example:
    
    @Entity
    public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
        private String name;
        private String email;
    }
### Primary Key:

Every entity must have a primary key, marked with @Id.
The primary key can be auto-generated using @GeneratedValue.
EntityManager:

A JPA interface that handles CRUD operations.
In Spring Boot, the EntityManager is used internally by the JpaRepository provided by Spring Data JPA.
Repositories:

## Spring Data JPA provides repository abstractions, which are interfaces that handle all CRUD operations without writing explicit queries.
### Setting Up Hibernate/JPA in Spring Boot
### Spring Boot Dependencies (in pom.xml):
   Ensure the following dependencies are added to your project:
    
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>

## Configure application.properties (MySQL Example):
properties - 
### Database configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

### Hibernate JPA settings
    spring.jpa.hibernate.ddl-auto=update  # Possible values: create, update, validate, none
    spring.jpa.show-sql=true              # Show SQL statements in the console
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

## Entity Class:
   Entities represent the structure of the table. Let’s create an entity class for a "User" table.

    package com.example.demo.model;
    
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    
    @Entity
    public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    
        // Getters and Setters
    }

## Repository Interface:
   Use JpaRepository to interact with the database. Spring Data JPA provides this ready-made interface, and you only need to extend it.

    package com.example.demo.repository;
    
    import org.springframework.data.jpa.repository.JpaRepository;
    import com.example.demo.model.User;
    
    public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA will auto-implement common CRUD methods like save(), findAll(), findById(), deleteById()
    }

## Service Layer:
   The service layer contains the business logic and communicates with the repository layer.

    package com.example.demo.service;
    
    import com.example.demo.model.User;
    import com.example.demo.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    import java.util.List;
    import java.util.Optional;
    
    @Service
    public class UserService {
    
        @Autowired
        private UserRepository userRepository;
    
        public User createUser(User user) {
            return userRepository.save(user);
        }
    
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }
    
        public Optional<User> getUserById(Long id) {
            return userRepository.findById(id);
        }
    
        public User updateUser(Long id, User updatedUser) {
            return userRepository.findById(id).map(user -> {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                return userRepository.save(user);
            }).orElseThrow(() -> new RuntimeException("User not found"));
        }
    
        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }
    }

## Controller Layer:
   The controller layer handles HTTP requests and communicates with the service layer.


    package com.example.demo.controller;
    
    import com.example.demo.model.User;
    import com.example.demo.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.List;
    
    @RestController
    @RequestMapping("/users")
    public class UserController {
    
        @Autowired
        private UserService userService;
    
        // Create a new User
        @PostMapping
        public User createUser(@RequestBody User user) {
            return userService.createUser(user);
        }
    
        // Get all users
        @GetMapping
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }
    
        // Get a single user by ID
        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id) {
            return userService.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
    
        // Update a User
        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
            return ResponseEntity.ok(userService.updateUser(id, user));
        }
    
        // Delete a User
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
    }

## Conceptual Understanding of Key JPA/Hibernate Annotations:
    @Entity: Defines a class as an entity (table in the database).
    @Id: Marks the field as the primary key.
    @GeneratedValue: Specifies how the primary key will be generated.
    @Table: Optional; used to customize the table name.
    @Column: Optional; used to customize the column name.
    @ManyToOne, @OneToMany, @ManyToMany: Define relationships between entities (tables).
    @Transactional: Ensures methods execute within a transaction.
    @Query: Used to write custom queries.

## Advanced Hibernate/JPA Topics:
    Caching: Hibernate provides first-level and second-level caching.
    Lazy Loading vs Eager Loading: Determines when associated entities are loaded (only when accessed or immediately).
    Criteria API: A programmatic way to query the database.
    JPQL (Java Persistence Query Language): Object-oriented query language for fetching data from entities.
    Summary:
    Hibernate/JPA simplifies database access in Java applications through ORM.
    Spring Data JPA eliminates the need for boilerplate code, allowing focus on business logic.
    CRUD operations (Create, Read, Update, Delete) are easily handled using Spring Data JPA’s JpaRepository.
    Proper configuration of the database (MySQL in this case) is key to successfully running your application.
    This covers everything you need to get started with Spring Boot and Hibernate/JPA for CRUD operations.