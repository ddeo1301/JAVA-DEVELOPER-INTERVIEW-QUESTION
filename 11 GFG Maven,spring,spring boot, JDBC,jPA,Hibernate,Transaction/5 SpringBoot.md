**SPRING-BOOT**
   - Open source Java based framework used to create microservices in minutes.
   - Minimum configurations, embedded servers etc.
   - Spring Boot is a framework built on top of the Spring Framework, designed to simplify the development of 
    Spring-based applications.
   - Beans is an object that is managed by Spring IOC(Inversion of control) container. They r fundamental part of spring
      framework, as they represent the building blocks of ur application, allowing spring to manage dependencies,
      lifecycles and configuration  

**Why Use Spring Boot?**
 1) Spring Boot reduces the complexity of configuring Spring applications and speeds up the development
    process.
 2) Microservices: It is commonly used in microservices architecture due to its simplicity and ability to 
   create standalone, production-grade applications quickly.
 3) Spring Boot has a vast community and extensive documentation, making it easier to find support and resources.

 **@SpringBootApplication** annotation is a combination of three annotations:
 1) @Configuration: Tags the class as a source of bean definitions for the application context.
 2) @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other 
             beans, and various property settings.
 3) @ComponentScan: Tells Spring to look for other components, configurations, and services in the package, 
            allowing it to find the controllers.


PROJECT                                      
   - my sql dependency                         
   -abc(optional)       Optional willnot get added

MYPROJECT
   - MYSQL

    <artifactsId>spring-boot-starter-web</artifactsId>
    <exclusion>spring-boot-starter-tomcat</exclusion>
       - Here starter will contain everything except TOMCAT
       - We as a developer can make some modification on the starter by defining on this exclusion and
        optional
        - when we remove jetty and tomcat, it will nt throw any exception error but it will simply run our 
          application but as it doesnot have any server where it needs to deploy so it will stop


- DISPATCHER SERVELET sees that for the given path which of the JAVA code has to be executed.
- DISPATCHER SERVELET only searches for controller section bcoz any mapping that we provide DISPATCHER 
  SERVELET searches for only those beans that r there in controller


**Embedded Tomcat Server:**
 - means that server has been already embedded and we don't need to provide an extra server to run our application.
 - We need to add a starter package to show you the embedded tomcat server.

**Is it Mandatory To use the Tomcat Embedded server?**
 - No, It’s not mandatory to use the embedded tomcat server.
 - We can remove it using exclusions.
 - But we need some server to be installed if we want our application to run all time or otherwise it will 
   act as just a java code.

**Creation Of Spring Boot:**
 - Go to https://start.spring.io/
 - Provide Specifications and then You are good to go.
 - Explore what is required and what is not.
 - You can add starter packages if you want.

**Running the Application:**
 - You can run the Spring Boot application using a simple command:
                    mvn spring-boot:run
 - Or, if you've packaged your application as a JAR:
                    java -jar target/myapplication.jar



**WAYS OF CREATING BEANS**
  - @Component ->  1) @Service  2) @Repository  3) @Controller
  - @service <--> @repository   . It will not throw any error. 
  - @controller <--> @repository  . It will not work.  whenever our dispather servelet requires any mapping
        /test API then dispather servelet will only look in controller class that which mapping or to which
         class it would request to and it wont even look into service and repository



**HTTP METHODS (CRUD)**
 1) **GET (@GetMapping):** 
     - Retrieve a resource or list of resources. eg:- Fetching a single user by ID or all users.
     - Whenever we want to get some data from our application and dont want to make any modification
     - idempotent and has no request body. Used to get some data from the server.

                @GetMapping("/users/{id}")
                public ResponseEntity<User> getUserById(@PathVariable Long id) {
                    Optional<User> user = userRepository.findById(id);
                    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
                }
                // retrieves a specific user by ID. If the user is found, it returns the user; otherwise, it 
                   returns a 404 Not Found status.

                @GetMapping("/users")
                public List<User> getAllUsers() {
                    return userRepository.findAll();
                }
                // retrieves all users from the database.

 2) **POST (@PostMapping):** 
     - Used for creating a new resource. eg:- Creating a new user.
     - non idempotent and has a request body. Used to insert some data on the server.

                        @PostMapping("/users")
                        public User createUser(@RequestBody User user) {
                            return userRepository.save(user);
                        }
                        // This method handles HTTP POST requests to the /users endpoint. 
                        // It creates a new User entity based on the JSON provided in the request body and 
                        // saves it to the database.

3) **PUT (@PutMapping):**
     - Used for updating an existing resource.  eg:- Updating user details.
     - idempotent and updates an existing resource and inserts if it does not exist.
     - if we are doing partial change then all will be NULL except the change we made

               @PutMapping("/users/{id}")
               public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
                  Optional<User> optionalUser = userRepository.findById(id);
                  if (!optionalUser.isPresent()) {
                     return ResponseEntity.notFound().build();
                  }

                  User user = optionalUser.get();
                  user.setName(userDetails.getName());
                  user.setEmail(userDetails.getEmail());

                  User updatedUser = userRepository.save(user);
                  return ResponseEntity.ok(updatedUser);
               }
               // This method updates an existing user with the provided details. It checks if the user 
               // exists; if so, it updates the user and saves the changes. If the user doesn't exist, it
               //  returns a 404 status.

 4) **DELETE (@DeleteMapping)**: 
     - Used for deleting a resource. eg:- Deleting a user by ID.
     - idempotent and deletes an existing resource on the server.

               @DeleteMapping("/users/{id}")
               public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
                  Optional<User> user = userRepository.findById(id);
                  if (!user.isPresent()) {
                     return ResponseEntity.notFound().build();
                  }

                  userRepository.delete(user.get());
                  return ResponseEntity.noContent().build();
               }
               // This method deletes a user by ID. It checks if the user exists, and if so, it deletes the 
               user and returns a 204 No Content status. If the user doesn't exist, it returns a 404 status.


     - Except Post requests all requests are idempotent.Because post requests are always changing the state
         of the server all remaining are keeping the state the same.
     - Idempotent means giving same output for the same input i.e same behaviour even on multiple calls
     - PATCH: idempotent and updates partial data without changing the whole data.
     - PUT: Updates the entire resource. Replaces the resource with the provided content.
     - PATCH: Partially updates the resource. Only the provided fields are modified.
     - PUT: Used to update an entire resource. If a resource with the specified identifier exists, PUT 
         replaces it with the new content. If it doesn't exist, PUT may create a new resource.
     - PATCH: Used to partially update a resource. Instead of replacing the entire resource, PATCH only 
         updates the fields that are provided in the request.



**MVC(MODEL-VIEW-CONTROLLER)**
 1) **Model:** encapsulates the application/business logic.
 2) **View:** is responsible for rendering the model data and in general it generates HTML output that the
           client or browser can return.
 3) **Controller:** is responsible for processing user requests and building an appropriate model and passes
           it to the view for rendering.

**Workflow of MVC in Spring Boot**
 1) **Client Request:** The client sends an HTTP request to the server.
 2) **DispatcherServlet:** The request is intercepted by the DispatcherServlet, which determines the 
         appropriate controller to handle the request.
 3) **Controller Processing:** The selected controller processes the request, often interacting with the 
         model to retrieve or update data.
 4) **Model and View:** The controller returns a ModelAndView object, which contains the model data and the
        name of the view to render.
 5) **View Rendering:** The DispatcherServlet resolves the view name to an actual view (like a JSP or
        Thymeleaf template) and renders the response to the client.

                           // Model Class
                           @Entity
                           public class User {
                              @Id
                              @GeneratedValue(strategy = GenerationType.IDENTITY)
                              private Long id;
                              private String name;

                              // Getters and Setters
                           }

                           // Controller Class
                           @Controller
                           @RequestMapping("/users")
                           public class UserController {

                              @Autowired
                              private UserService userService;

                              @GetMapping
                              public String listUsers(Model model) {
                                 model.addAttribute("users", userService.findAll());
                                 return "userList"; // View name
                              }

                              @PostMapping
                              public String createUser(@ModelAttribute User user) {
                                 userService.save(user);
                                 return "redirect:/users"; // Redirect after post
                              }
                           }

                           // Service Class
                           @Service
                           public class UserService {
                              @Autowired
                              private UserRepository userRepository;

                              public List<User> findAll() {
                                 return userRepository.findAll();
                              }

                              public void save(User user) {
                                 userRepository.save(user);
                              }
                           }



**How We can run Spring boot application inside server:**
 1) Create the jar first by using the mvn package.
 2) Target folder will have a jar inside it.
 3) java -jar jarpath
 4) mvn clean package && java -jar jarpath 

 Difference between Spring and SpringBoot:

**Spring**
 - It has some nice features like dependency Injections and has modules out of box: Spring 
      JDBC, Spring MVC, Spring Security, Spring AOP, Spring ORM, Spring test
 - Loosely coupled Application.
 - Build configurations manually
**SpringBoot**
 - It’s just an extension of Spring framework. 
 - StandAlone Application
 - Starters packages and less configurations


**Annotations Used in SpringBoot:**

  **Core Spring Boot Annotations**

 **@SpringBootApplication:** This is the main annotation used to mark the application's entry point class.
 
            **Injections:**
               **Field injection:** autowiring as attribute.
               **Constructor Injection:**  putting the object inside the constructor.
               **Setter injection:**  setter method injections.

   1) **@Configuration:** Tags the class as a source of bean definitions for the application context.
            This annotation indicates that a class declares one or more @Bean methods and may be processed by
             Spring container to generate bean definitions and service requests for those beans at runtime.
            **@Bean** can be used with this **@configuration** only. 
   2) **@EnableAutoConfiguration:** Tells Spring Boot to start adding beans based on classpath settings,
             other beans, and various property settings.
   3) **@ComponentScan:** Tells Spring to look for other components, configurations, and services in the
             com/example package. to scan some other package
   4) **@EnableAutoConfiguration:** This annotation tells Spring Boot to start adding beans based on 
            classpath settings, other beans, and various property settings.
   5) **@RequestParam:** can be passed in some uri and we can get inside our method
   6) **@Qualifier:** to distinguish between two same types of qualifiers.
   7) **@Component:** This is a generic stereotype for any Spring-managed component. It allows **@AutoWired**
            to be used on constructor arguments. Tells bean should be created
   8) **@Repository:** This annotation indicates that an annotated class is a repository, which is a 
          mechanism for encapsulating storage, retrieval, and search behavior.
   9) **@Service:** This annotation indicates that a class is a service, which is a part of the business
            layer. It is a specialization of the **@Component** class. type of service class
   10) **@Controller:** This annotation indicates that a class serves as a controller in the MVC pattern.
            servletDispatcher dispatch request to it and can return data to view
   11) **@RestController:** This annotation is a convenience annotation for @Controller and @ResponseBody 
            together. servletDispatcher dispatch request to it and can return json as api response.
   12) **@Repository:** Just to show it is a mechanism for retrieval, storage(CRUD). 
   13) **@Value:** to get some value from config
   14) **@Bean:** to create a bean on some internal classes on a method
   15) **@Scope:** to define the scope as singleton, prototype 

  **Spring MVC and REST Annotations**
   1) **@RequestMapping:** This annotation maps web requests to Spring Controller methods. basically provided 
            on some class, to have some base path.
   2) **@GetMapping:** This annotation is a shortcut for **@RequestMapping(method = RequestMethod.GET)**.
            get request to call some method inside the application.
   3) **@PostMapping:** This annotation is a shortcut for @RequestMapping(method = RequestMethod.POST).
   4) **@PutMapping:** This annotation is a shortcut for @RequestMapping(method = RequestMethod.PUT).
   5) **@DeleteMapping:** This annotation is a shortcut for @RequestMapping(method = RequestMethod.DELETE).
   6) **@PatchMapping:** This annotation is a shortcut for @RequestMapping(method = RequestMethod.PATCH).
   7) **@RequestBody:** This annotation maps the HTTP request body to a transfer or domain object. to get 
            data from the body of request:
   8) **@ResponseBody:** This annotation indicates that the return type should be written straight to the 
            HTTP response body.
   9) **@PathVariable:** getting data from Path of any api.
   10) **@Autowired:** used to autowire the beans.
   11) **@Entity:** to create an entity for jpa repository to search an entity.
   12) **@Table:** we can use it in class to create a table inside a db.


