**Java Persistence API (JPA):**
  - JPA is a specification in Java that defines a standard for object-relational mapping 
    (ORM) and data persistence. It provides a set of guidelines that different ORM frameworks can implement.
  - JPA aims to simplify database interactions by allowing developers to work with Java objects rather than 
    complex SQL queries. 
  - It abstracts the database layer, so developers can interact with the database using Java classes and 
  annotations.
  - It’s only the specifications but not the implementation.
  - Does not conduct any functionality by itself therefore it needs some implementations.
  - Hibernate is one of the implementations for JPA guidelines for relational databases.
  - It is described in the javax.persistence package.
  - It uses JAVA persistence query Language.
  - Uses EntityManager for persistence units.
  - **Use JPA:** When you want to write portable and standard-compliant code that can work with any JPA provider.

 **Key Features:**
   - **Entity Management:** Defines how Java objects (entities) map to database tables.
   - **JPQL (Java Persistence Query Language):** A query language similar to SQL but operates on the entity 
        objects rather than tables.
   - **Entity Relationships:** Supports one-to-one, one-to-many, many-to-one, and many-to-many relationships.
   - **Transaction Management:** Manages transactions in a standardized way.
   - **Examples of Providers:** Hibernate, EclipseLink, OpenJPA.

**Hibernate:**
  -  Hibernate is a popular ORM framework that implements the JPA specification. 
  - It provides additional features and capabilities beyond the JPA standard.
  - Hibernate simplifies database interactions by automating the mapping between Java classes and database tables. 
  - By default the implementation of JPA in spring boot project.
  - It internally uses Hibernate Query Language for executing queries.
  - To create sessions it has a SessionFactory
  - Use Hibernate: When you need advanced features, optimizations, or specific behaviors provided by 
     Hibernate, or if you want to take advantage of its extensive ecosystem.

**Key Features:**
   - **Session Management:** Hibernate uses the Session object for CRUD operations, which provides a more 
       advanced way to manage entities.
   - **Criteria API:** Allows building queries programmatically with more flexibility.
   - **Caching:** Supports different levels of caching (first-level, second-level) to improve performance.
   - **Additional Annotations:** Hibernate provides extra annotations and configurations not covered by JPA.
   - **Automatic Schema Generation:** Can generate or update the database schema based on your entity mappings.

**How They Work Together:**
 1) ***JPA as a Standard, Hibernate as an Implementation:*** Hibernate implements the JPA standard, meaning 
    you can write JPA-compliant code and use Hibernate as the underlying engine. This allows developers to
     switch between different JPA providers with minimal code changes.
 2) **JPA for Portability, Hibernate for Features:** If you write code using only JPA annotations and APIs,
    your code is portable across different JPA providers. However, if you need advanced features, you might 
    use Hibernate-specific features, which can tie your code to Hibernate.

- In practice, many developers use JPA for the standard part of the application and switch to 
   Hibernate-specific features when they need more advanced capabilities.


**How are Spring Data repositories actually implemented?**
 - Spring Data repositories are implemented using dynamic proxies that automatically generate the necessary 
   boilerplate code for common data access patterns. 
 - By defining a simple interface and following naming conventions, you can leverage the power of JPA without 
   having to write complex SQL or JPQL queries manually. 
 - The underlying implementation is highly flexible, allowing for custom queries, custom implementations, and 
   easy integration with Spring's transaction management and dependency injection systems.
 - Spring Data repositories provide a powerful abstraction over the data access layer, allowing developers to
   interact with databases using high-level interfaces rather than boilerplate code. 

**1. Repository Interface Definition**
  - **User-Defined Interfaces:** In Spring Data, you define repository interfaces that extend predefined 
     repository interfaces provided by Spring, such as JpaRepository, CrudRepository, or PagingAndSortingRepository.

                import org.springframework.data.jpa.repository.JpaRepository;

                public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
                    // You can define custom query methods here
                }

**2. Spring Data Repository Interfaces**
 - **Core Interfaces:**
     - **CrudRepository<T, ID>:** Provides basic CRUD operations (e.g., save, findById, delete).
     - **JpaRepository<T, ID>:** Extends CrudRepository with additional JPA-specific operations 
          (e.g., flushing the persistence context, batch inserts).
     - **PagingAndSortingRepository<T, ID>:** Adds pagination and sorting capabilities.
 - **Custom Query Methods:** You can define methods following a specific naming convention (e.g., findByName)
     that Spring Data will automatically implement.

**3. Dynamic Proxy Implementation**
 - **Dynamic Proxy Creation:** At runtime, Spring Data generates a dynamic proxy class for your repository 
     interface. This proxy class implements the methods defined in your interface.
 - **Spring's @EnableJpaRepositories:** When you annotate your configuration class with 
     **@EnableJpaRepositories**, Spring scans for repository interfaces and creates proxy instances for them. 
     These proxies are registered as beans in the application context.

**4. Query Derivation Mechanism**
 - **Method Name Parsing:** When you define a method in a repository interface, Spring Data parses the method
    name and derives a query based on the entity's field names. For example, method named **findByName** will
     generate a query to find entities where the name field matches the given parameter.

                    List<MyEntity> findByName(String name);

 - **Query Methods:** If the method names follow the convention, Spring Data automatically translates them into JPQL queries.

**5. Custom Queries**
 - **@Query Annotation:** You can define custom queries using the @Query annotation directly on repository methods.

                @Query("SELECT e FROM MyEntity e WHERE e.name = ?1")
                List<MyEntity> findByNameCustomQuery(String name);

**6. Method Invocation**
 - **Intercepted Calls:** When a method on a repository is invoked, the proxy intercepts the call and
     delegates it to the appropriate underlying method:
 - **For Derived Queries:** The proxy generates a JPQL query based on the method name and executes it.
 - **For Annotated Queries:** The proxy uses the provided JPQL or native query.
 - **For Default Methods (e.g., save, findById):** The proxy delegates to predefined implementations provided 
     by Spring Data.

**7. Integration with JPA EntityManager**
 - **EntityManager Usage:** Underneath the repository proxy, Spring Data interacts with the JPA EntityManager
    to perform database operations. The **EntityManager** is responsible for managing the persistence context and executing queries.
 - **Transaction Management:** Spring automatically manages transactions for repository methods, using the **@Transactional** annotation.

**8. Customization with Repository Implementations**
 - **Custom Implementation:** If you need more control, you can provide custom implementations for repository
   methods. This is done by creating a custom repository interface and a corresponding implementation class.

                public interface MyEntityRepositoryCustom {
                    void customMethod();
                }

                public class MyEntityRepositoryImpl implements MyEntityRepositoryCustom {
                    @Override
                    public void customMethod() {
                        // Custom logic here
                    }
                }

 - **Combine with Default Interface**: Spring Data allows you to combine these custom methods with the 
     default repository methods by creating an interface that extends both JpaRepository and your custom interface.

**9. Repository Composition**
 - **Composability:** You can compose repositories by having one repository extend another, thereby combining
    their functionality. This allows for modular and reusable data access logic.

**10. Final Injection into Services**
 - **Dependency Injection:** Once the repository proxies are created and registered, they can be injected 
   into our service classes using Spring's dependency injection mechanisms (@Autowired, constructor injection, etc.).




**How JPA Works:**

 - **Session creation:**  getting sessions inside Hibernate. We go to hibernate and create sessions using 
     some classes inside Hibernate. Hibernate returns some sessions to JPA.
 - **Criteria Builder( Adding query):** Inside the JPA only.
 - **Execution of Query :** happens inside the hibernate only.
 - **Note:** Hibernate does not have functions like save, find, delete etc.
             It has QueryBuilding, executeQuery, sessionCreation, flushingSession etc. 

 - JPA abstracts the database interactions, allowing developers to work with Java objects instead of SQL queries. 
  - It manages the lifecycle of entities, handles transactions, and provides powerful query capabilities. 
  - By leveraging the persistence context and EntityManager, JPA ensures that changes to entities are 
     synchronized with the database efficiently and consistently. 
  - Through annotations, entities can be mapped to relational tables, and relationships between entities can
      be managed with ease, making JPA a powerful tool for data persistence in Java applications.



Java Persistence API (JPA) is a specification that provides a standardized way to map Java objects to
 database tables and manage relational data in Java applications. Here's how JPA works, step by step:

 **1) Entities and Object-Relational Mapping (ORM)**
   - **Entity Classes:** In JPA, an entity is a lightweight, persistent domain object, typically representing 
      a table in a relational database. Each entity class is annotated with **@Entity**, and its fields correspond to the table's columns.

   **Annotations for Mapping:**

     - @Entity: Marks a class as an entity.
     - @Table: Specifies the table name in the database (optional).
     - @Id: Defines the primary key of the entity.
     - @GeneratedValue: Configures auto-generation of primary key values.
     - @Column: Specifies the column name and attributes (optional).


            @Entity
            @Table(name = "users")
            public class User {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;

                @Column(name = "username", nullable = false, unique = true)
                private String username;

                private String password;
                
                // Getters and Setters
            }

 **2. Persistence Context and EntityManager**
   - **Persistence Context:** The persistence context is a set of entity instances that are managed by an EntityManager. 
       It is responsible for tracking changes to entities and synchronizing them with the database.

   - **EntityManager:** The EntityManager is the primary JPA interface for interacting with the persistence context. 
   It provides methods for creating, reading, updating, and deleting entities. 
   It also manages the lifecycle of entities within the persistence context.

**EntityManager Methods:**

            persist(Object entity): Inserts a new entity into the database.
            find(Class<T> entityClass, Object primaryKey): Retrieves an entity by its primary key.
            merge(Object entity): Updates an existing entity.
            remove(Object entity): Deletes an entity.
            createQuery(String jpql): Creates a JPQL query.

 **3. Persistence Unit and Configuration**
    **Persistence Unit:** A persistence unit is a logical grouping of entity classes that are managed 
    together. It is defined in the persistence.xml file, which is located in the META-INF directory.

 **4. Entity Lifecycle**
   Entities in JPA have different states, and the EntityManager manages the transition between these states:

            New (Transient): The entity is newly created and not yet associated with a persistence context.
                             It has no corresponding row in the database.
            Managed (Persistent): The entity is associated with a persistence context and is synchronized with the database.
            Detached: The entity was once managed, but is no longer associated with a persistence context.
            Removed: The entity is marked for removal from the database.

** Lifecycle Transitions:**

        Calling persist(entity) moves the entity from Transient to Managed.
        Calling remove(entity) marks the entity for deletion, changing its state to Removed.
        Detaching occurs when the persistence context is closed or when detach(entity) is explicitly called.

**5. Transactions**
 **Transaction Management:** JPA requires that all database operations be performed within a transaction. 
   Transactions ensure data integrity and consistency.

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();

                User user = new User();
                user.setUsername("john_doe");
                user.setPassword("password123");
                em.persist(user);

                em.getTransaction().commit();

                em.close();
                emf.close();

**Automatic Transaction Management:** In environments like Spring, transactions are often managed
    automatically using annotations such as **@Transactional.**

 **6. Queries and JPQL**

   - **JPQL (Java Persistence Query Language):** JPQL is a query language similar to SQL but operates on 
      entity objects rather than database tables. 
      JPQL is database-agnostic, meaning the same query can work across different databases.

                    String jpql = "SELECT u FROM User u WHERE u.username = :username";
                    TypedQuery<User> query = em.createQuery(jpql, User.class);
                    query.setParameter("username", "john_doe");
                    User user = query.getSingleResult();

   - **Criteria API:** An alternative to JPQL, the Criteria API allows you to build queries programmatically,
       offering more flexibility and type safety.

 **7. Synchronization and Flushing**
   - **Flushing:** When a transaction is committed, the EntityManager flushes the persistence context,
       meaning all changes to managed entities are synchronized with the database.

   - **Automatic and Manual Flushing:** Flushing can occur automatically during a transaction commit, but it
       can also be triggered manually using **em.flush().**

 **8. Caching**
   - **First-Level Cache:** The EntityManager maintains a first-level cache within the persistence context.
      Entities loaded by the EntityManager are stored in this cache, reducing the number of database accesses.

   - **Second-Level Cache:** Optionally, JPA providers like Hibernate offer a second-level cache that 
   persists beyond the lifecycle of a single EntityManager, improving performance for read-heavy applications.

**9. Advanced Features**
   - **Relationships:** JPA supports relationships between entities, including one-to-one, one-to-many, 
   many-to-one, and many-to-many, using annotations like **@OneToOne, @OneToMany, @ManyToOne, and @ManyToMany.**

   - **Inheritance:** JPA allows for entity inheritance, where a base class can have subclasses, and the 
      mapping strategy (single table, joined table, etc.) can be configured using the @Inheritance annotation.

   - **Callbacks and Listeners:** JPA provides lifecycle callbacks (e.g., **@PrePersist, @PostLoad**) and 
      entity listeners to react to specific events in an entity's lifecycle.

**10. Integration with Spring and Other Frameworks**
   - **Spring Data JPA:** Spring Data JPA builds on JPA to simplify repository management, provide powerful 
   query generation, and integrate seamlessly with Spring's dependency injection and transaction management.

   - **Spring Boot:** Spring Boot automatically configures JPA, eliminating the need for persistence.xml and 
      providing easy integration with databases through properties.


