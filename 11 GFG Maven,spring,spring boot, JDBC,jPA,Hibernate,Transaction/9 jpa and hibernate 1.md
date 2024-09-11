**Important Properties:**

   **To create datasource:**
                
                spring.datasource.url=
                spring.datasource.username=
                spring.datasource.password=

   **DDL related Queries:**

            spring.jpa.hibernate.ddl-auto

This ddl-auto can have 5 values:

            none: default value and makes no changes to ddl
            validate: Validate the schema, make no changes to the database
            update: update the schema if necessary -> addition
            create: create the schema and destroy previous data
            create-drop : recreate and then destroy the schema at the end of session.

   **To get logs of sql:** 

                spring.jpa.show-sql=true
                spring.jpa.properties.hibernate.generated_statistics=true

   **To update the naming strategy:**

            spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

**@Id:** Annotation is used to generate the id on some entity class.
**@GeneratedValue**

 - The JPA specification supports 5 different primary key generation strategies which generate the primary key values programmatically or use database features
 - In JPA (Java Persistence API), generation strategies define how the primary key values for entities are generated. 
 - These strategies are important for ensuring unique identifiers for each entity in the database. 
 - JPA provides several strategies for primary key generation, which are specified using the @GeneratedValue annotation.



  1) **AUTO:** 
  - Hibernate selects the generation strategy based on the used dialect
  - For **numeric** values, the generation is based on a **sequence or table generator**, while **UUID** values will use the **UUIDGenerator**.
                        **@Id**
                        **@GeneratedValue**
  - This is the default strategy. The JPA provider (e.g., Hibernate) selects the most appropriate 
    generation strategy based on the database dialect.This type can be **numerical** or **UUID**.
  - This strategy is convenient if you want to write database-agnostic code and let the JPA provider handle 
       the specifics.
  - Supported Databases: All relational databases.
  - Use when you want the JPA provider to decide the best strategy based on the database.
   
                            @Entity
                            public class User {
                                @Id
                                @GeneratedValue(strategy = GenerationType.AUTO)
                                private Long id;

                                private String username;
                                // other fields, getters, and setters
                            }


 2) **SEQUENCE:**
 
   - Hibernate relies on an auto-incremented database column to generate the primary key, Hibernate provides the **SequenceStyleGenerator class**
   - This generator uses sequences if our database supports them. It switches to table generation if they aren’t supported.
  - Use when the database supports sequences, especially in environments requiring efficient batch processing.


                @Entity
                public class User {
                    @Id
                    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
                    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
                    private Long id;

                    private String username;
                    // other fields, getters, and setters
                }

 **@SequenceGenerator Annotations:**

        name: Specifies the generator name.
        sequenceName: Specifies the name of the database sequence.
        allocationSize: Defines how many sequence values will be fetched in advance (default is 50). Setting it to 1 will fetch a new value for each insert.

 3) **IDENTITY:** 
   - The IDENTITY strategy relies on the database to automatically generate a unique identifier for the primary key. Typically, this is done using an auto-incrementing column in the database.
   - Use when the database supports auto-incrementing columns and you prefer simplicity, 
   - Use when the database supports auto-incrementing columns and you prefer simplicity, but be aware of potential inefficiencies in batch operations.
   - This strategy is simple to use but can be less efficient for batch inserts because each insert operation 
      requires a database round-trip to obtain the generated key.
 
                        @Entity
                        public class User {
                            @Id
                            @GeneratedValue(strategy = GenerationType.IDENTITY)
                            private Long id;

                            private String username;
                            // other fields, getters, and setters
                        }



**4. TABLE Strategy**
 - create a diff table to manage sequence.Increment then use
 - The TABLE strategy uses a dedicated database table to generate unique primary key values. 
 - The table typically has a column for the sequence name and a column for the next value.
 - The TABLE strategy is database-agnostic, meaning it can be used with any database. 
 - However, it is less efficient than SEQUENCE and IDENTITY due to the additional overhead of managing a separate table.
 - This strategy simulates a sequence by storing and updating the current value in a separate database table. It is rarely used due to its performance drawbacks, as it requires pessimistic locking 
 - All relational databases.
 - Considered when other strategies are not feasible, but generally, it is advisable to use SEQUENCE if supported by the database.
 - Hibernate uses a database table to simulate a sequence.
 - Default table : hibernate_sequences
                        
                        @Id
                        @GeneratedValue(strategy = GenerationType.TABLE)
                        private Long id;          


**5) UUID(unique user identifier):** 
 - That generates the unique string for you with the help of  **UUIDGenerator.**
 - This strategy generates universally unique identifiers (UUID) as primary keys, which is useful for 
  distributed systems where uniqueness across different databases is required.

                @Id
                @GeneratedValue(generator = "UUID")
                @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
                private UUID id;
