**DML: Data Manipulation Queries:**
 - Manipulates the data inside the db.
 - what data would reside in my table.
 - create, alter, delete, drop

                QUERIES:
                - Select * from table_name;
                - Insert into table tableName(col1, col2, col3) VALUES (“col1val”, “col2val” ,”col3val”);
                - Update table table_name where id =id set col = “newVal”;
                - Delete from table where id = id;

**DDL: Data Definition Language**
 - Manipulates the Structure of a table inside a schema.
 - Schema would look like
 - eg:- insert, delete, update, select

                    Queries:
                    - Alter table table_name add column col_name type;
                    - Drop table table_name;
                    - Create table table_name (col1 type, col2 type, col3 type);
                    - To see no of connections to our Db: show processlist;


- Many a times if a person wants to create a person name, they would keep the name as **createPerson**, and 
for get a person as **getPerson** which is ideally wrong bcoz out HTTP method should identify that what 
operations you want to perform. Our URL that we r using should always be noun which will identify that on 
which resource we r performing the operations

- **Controller** is basically the 1st layer used by dispatcher servelet that what should be the end point 
after that we have **service layer** which have all the business logic which interact with any other API i.e
interaction with repository. **Repository** any interaction with Database



**JDBC(Java/Jakarta Database Connectivity)**  (ALSO CHECK THE PDF ATTACHED)
 - Java Database Connectivity (JDBC) is an API that allows Java applications to interact with various   databases. 
 - It provides a standard method for connecting to relational databases, executing SQL queries, and 
    retrieving results

 - Standard APIs for independent database connectivity between the Java programming language and the wide  
    range of databases.
    - **Driver:** Specific Db vendors like Mysql, oracle etc.
    - **Driver Manager:** Manager that ensures the exact driver has been used to ensure the db connection.
        Connection conn = DriverManager.getConnection(“jdbc:mysql://localhost:3306/myDb” , “user”, “pass”);
        Connection conn = DriverManager.getConnection(“jdbc:postgresql://localhost/myDb” , “user”, “pass”);


 **Key Features**
 1) **Database Independence:** JDBC allows Java applications to interact with different databases without 
        needing to change the code significantly.
 2) **Support for Multiple Databases:** JDBC can connect to any database that provides a JDBC driver, 
        including popular databases like MySQL, Oracle, PostgreSQL, and SQL Server.
 3) **Standardized API:** It provides a set of interfaces and classes that standardize how Java applications
         communicate with databases.

**Components of JDBC**
 1) **JDBC API:** This includes two main packages:
        **java.sql:** Contains classes and interfaces for database access.
        **javax.sql:** Provides additional functionality such as connection pooling and distributed transactions.
 2) **JDBC Driver Manager:** This class manages the different JDBC drivers. It is responsible for 
 establishing a connection between the Java application and the database.
 3) **JDBC Drivers:** These are specific implementations that convert Java calls to database-specific calls. 
        There are four main types of JDBC drivers:

                Type 1: JDBC-ODBC bridge driver (deprecated).
                Type 2: Native-API driver that uses database-specific native libraries.
                Type 3: Network Protocol driver that communicates with a middleware server.
                Type 4: Thin driver that communicates directly with the database using its native protocol.

**Basic Steps to Connect to a Database**
 - To connect a Java application to a database using JDBC, follow these steps:
     1) **Load the JDBC Driver:** This is typically done using Class.forName() to load the driver class.
     2) **Establish a Connection:** Use **DriverManager.getConnection()** to create a connection to the 
        database. The connection URL will start with jdbc: followed by the database type and connection details.

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

     3) **Create a Statement:** Use the Connection object to create a Statement or PreparedStatement for 
        executing SQL queries.

                Statement stmt = conn.createStatement();

     4) **Execute Queries:** Use the statement to execute queries and retrieve results.

                ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

     5) **Process Results:** Iterate through the ResultSet to process the data returned by the query.
     6) **Close Connections:** Always close the ResultSet, Statement, and Connection objects to free up resources.

                    rs.close();
                    stmt.close();
                    conn.close();

**Example Code**

                import java.sql.Connection;
                import java.sql.DriverManager;
                import java.sql.ResultSet;
                import java.sql.Statement;

                public class JDBCExample {
                    public static void main(String[] args) {
                        String url = "jdbc:mysql://localhost:3306/mydatabase";
                        String user = "username";
                        String password = "password";

                        try (Connection conn = DriverManager.getConnection(url, user, password);
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable")) {

                            while (rs.next()) {
                                System.out.println("Column Value: " + rs.getString("column_name"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


**Statements:**
   - Statement statement = conn.createStatement();

 - Executing Sql Statement can be done by 3 different methods:

     1) **executeQuery()** for select statements.whenever u want to get some data bcoz it provides u the class
           that store the data ResultSet 
     2) **executeUpdate()** for updating the data or table structure. returns an integer -> no. of rows 
           impacted due to query
     3) **execute()** can be used in both above cases when the result is unknown. it will return true if some 
           resultSet was returned, otherwise false

**Prepared Statements:**
   - Prepared statement objects contain precompiled SQL sequences.It can have one or more parameters denoted by “?”
     - Feature by which, sql statement template is generated by using that template we can run the same 
         query multiple times in an efficient manner.
     - Certain params remain unspecified with (?)
     - This Query gets parsed once and executed multiple times.
     - Wherever we need to pass some params we use prepared statements.
     - Eg : insert into person (id, name, age, dob) VALUES (? ,? , ?, ?);

                statement = connection.prepareStatement("insert into person(name, id) VALUES (?,?)");
                statement.setString(1,person.getName() );
                statement.setInt(2, person.getId())

**Problems with JDBC:**
 1) We need to write a lot of code before and after execution of the query.
 2) Exception handling is done by us,
 3) Handle the transaction by ourselves.
 4) Time Consuming
 5) Everytime we r creating new connections and we r closing it. unnecessary creation of connection is there
    It is nt advisable to make connection everytime so at some time we can reuse the connection

**Spring JDBC:** 
 - It provides you a method to write the queries directly, so it saves a lot of time and effort.
 - Spring provides a mechanism to manage connection pools(Hikari connection pool)
 - whenever our connection is started by default connection pool is created. what connection we have added
   will get added in connection pool. whenever request comes everything is handled by the SpringJDBC itself
   we dont have to make sure that which connection is routed to which connection

**JDBCTemplate Class:**
 - It takes care of creation and release of resources such as creating and closing of connection objects etc.
 - Less Time consuming.
 - If we will provide bean of data Source automatically Bean will inject this DataSource inside JDBC template
 - DataSource is the class provided by spring JDBC in which we provide the parameters that to which URL we 
    connect to, what is the username and what is the password
 - **SpringBoot** has provided the abstraction that we dont have to provide bean of data source, you can 
     provide me the bean and i will provide bean on ur behalf

**public class PersonController{**

    @Autowired
    PersonService personService;
      // It will create the instance of personController and after that it will set these properties. It may
      // happen that at that time personServices has not been crearted. Here, when we r using field injection
      // it means that our PersonController is getting created using default constructor and then it is using 
      // setters to create personServices

    @Autowired
    PersonController(PersonService personService)
        this.personService = personService;
           // Here springBoot makes sure that before even creatingPersonController, personService is always 
           // created. Now, we make sure that ordering is correct i.e 1st personService is created then 
           // personController is created
}


**@Bean** (method level Annotation)
 - Bean annotation is used with methods whatever is the response of this type of methods, an instance will be
   created and automatically added to my application context

why we need to specify **@configuration** bcoz it tells to spring that please create beans even those classes
 of those return types which r specified



**NamedParameterJdbc Template:**
   - It allows the use of named parameters rather than the traditional for “?” placeholders.

            @Autowired
            private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("name" , name);
            parameterSource.addValue("id" , id);
            return namedParameterJdbcTemplate.update("insert into person (name, id) values (:name, :id)", 
                   parameterSource);

**Problems with all the above approaches:**
   - We will have to map the class to some database table, i.e., mapper creation is done by us.
