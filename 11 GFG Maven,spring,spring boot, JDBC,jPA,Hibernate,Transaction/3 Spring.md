SPRING FACTORY
 - Spring is a powerful lightweight application development framework used for JAVA Enterprise Edition.(JEE)

MODULES OF SPRING:
 - Core Container: IOC, Dependency Injection
 - Spring Data Access : JPA, Hibernate
 - Spring Web : Server 
 - Aspect Oriented Programming : Security framework  

SPRING CORE:
 - Spring IoC(Inversion of control) container is the core of Spring Framework.It creates the objects, 
    configures and assembles the dependencies and manages their entire life.
 - IoC and DI are used interchangeably IoC si achieved via DI.

INVERSION OF CONTROL
 - When spring is doing DI on our behalf then IOC is happening
 - By DI the responsibility of creating objects is shifted from our application code to the spring container
    and this phenomenon is known as Inversion of control.

Dependency Injections:
 - Injecting some dependencies into objects of some classes.
 - DI is a specific implementation of IoC, where the container injects dependencies into a bean rather than 
 the bean creating them itself
 - It’s a design pattern that can be implemented in any language. Via constructor, setter or field injection. 

  1) Constructor Injection
      - Dependencies are provided as constructor parameters when the bean is instantiated. 
      - This method ensures that the bean is created with all its required dependencies.

                    import org.springframework.beans.factory.annotation.Autowired;
                    import org.springframework.stereotype.Component;

                    @Component
                    public class Car {
                        private Engine engine;

                        @Autowired
                        public Car(Engine engine) {
                            this.engine = engine;
                        }

                        public void drive() {
                            engine.start();
                            System.out.println("Car is driving.");
                        }
                    }

                    @Component
                    public class Engine {
                        public void start() {
                            System.out.println("Engine started.");
                        }
                    }

     - In this example, the Car class depends on the Engine class, and this dependency is provided through the constructor.

   2) Setter Injection
       - With setter injection, Spring uses setter methods to inject dependencies.

                        import org.springframework.beans.factory.annotation.Autowired;
                        import org.springframework.stereotype.Component;

                        @Component
                        public class Car {
                            private Engine engine;

                            @Autowired
                            public void setEngine(Engine engine) {
                                this.engine = engine;
                            }

                            public void drive() {
                                engine.start();
                                System.out.println("Car is driving.");
                            }
                        }

                        @Component
                        public class Engine {
                            public void start() {
                                System.out.println("Engine started.");
                            }
                        }
 
      - Here, the Car class has a setter method for injecting the Engine dependency.
    
    3) Field Injection
         - With field injection, Spring directly injects dependencies into the fields of a class.

                            import org.springframework.beans.factory.annotation.Autowired;
                            import org.springframework.stereotype.Component;

                            @Component
                            public class Car {
                                @Autowired
                                private Engine engine;

                                public void drive() {
                                    engine.start();
                                    System.out.println("Car is driving.");
                                }
                            }

                            @Component
                            public class Engine {
                                public void start() {
                                    System.out.println("Engine started.");
                                }
                            }

      - In this example, the Engine dependency is injected directly into the Car class's field.


SPRING CONFIGURATION :
 - To enable Spring to manage these beans and their dependencies, we need to configure the application context. 
 - There are several ways to do this, including using Java-based configuration, XML configuration, or annotations. 

                     // JAVA BASED CONFIGURATION
                    import org.springframework.context.annotation.ComponentScan;
                    import org.springframework.context.annotation.Configuration;

                    @Configuration
                    @ComponentScan(basePackages = "com.example")
                    public class AppConfig {
                    }


                    // MAIN APPLICATION
                    import org.springframework.context.ApplicationContext;
                    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

                    public class Main {
                        public static void main(String[] args) {
                            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                            Car car = context.getBean(Car.class);
                            car.drive();
                        }
                    }

      - @Configuration indicates that the class is a source of bean definitions.
      - @ComponentScan tells Spring to scan the specified package for components (beans).
      - @Component is used to define beans.
      - @Autowired is used to indicate the points of injection. For eg: Notification Service Class requires
            SMSGateway. we have to specify it somewhere thats why we r using @Autowired. It is dependency on
            SMSGateway. If we dont use @Autowired we will get NULLPOINTEXCEPTION bcoz our SMSGateway is NULL 

     - Spring's IoC container manages the lifecycle of beans and injects dependencies where needed, providing 
        a clean separation of concerns and promoting loose coupling between components. 
     - This makes the application more modular, easier to maintain, and testable.

BENEFITS OF IOC AND DI IN SPRING BEAN : 
 1) Loose Coupling: Classes are less dependent on concrete implementations, making it easier to change 
                    implementations without modifying the dependent classes.
 2) Easier Testing: Dependencies can be mocked or stubbed, allowing for unit testing without needing the 
                    actual dependencies.
 3) Configuration Flexibility: Changing dependencies can be done through configuration without altering the
                     code, enhancing maintainability.

SPRING BEAN
  - An object created and managed inside an IoC container is called a bean.


BEAN FACTORY :-
 - BeanFactory is the simplest container in the Spring Framework, providing the core features necessary for 
 dependency injection. 
 - It is primarily used for lightweight applications where memory consumption is critical.

       - Key characteristics include:
           1) Lazy Initialization: Beans are instantiated only when requested, which can save memory in 
                    applications where not all beans are needed immediately.
           2) Basic Dependency Injection: Supports basic features of dependency injection but lacks advanced 
                    functionalities.
           3) Limited Features: Does not support annotation-based configuration, internationalization (I18N),
                     or event propagation.

                BeanFactory factory = new XmlBeanFactory(new Resource("applicationContext.xml"));

APPLICATION CONTEXT 
 - ApplicationContext is a more advanced and feature-rich container that extends BeanFactory. 
 - Used for creating all the beans that has been created

     - Eager Initialization: By default, it pre-instantiates all singleton beans at startup, reducing 
                response time for user requests.
     - Support for Annotations: Allows for annotation-based configuration (e.g., @Autowired, @PreDestroy),
                 making it easier to manage dependencies.
     - Internationalization: Can resolve messages from property files, facilitating the development of 
                applications that support multiple languages.
     - Event Handling: Supports event propagation, allowing beans to publish and listen to application events.
     - Parent-Child Contexts: Supports hierarchical contexts, where a parent context can be shared across 
                multiple child contexts.

COMMON IMPLEMENTATION OF APPLICATION CONTEXT INCLUDE:
   - ClassPathXmlApplicationContext: Loads bean definitions from an XML file located in the classpath.
   - FileSystemXmlApplicationContext: Loads bean definitions from an XML file in the filesystem.
   - AnnotationConfigApplicationContext: Used for Java-based configuration.


    <bean id="engine" class="com.example.Engine">
            <property name="type" value="V8" ref="address" />
    </bean>
    
     - bean tags defines bean
     - id attribute provide unique identifier for the bean
     - class is the path/package where our class is present
     - property tag configure property of the bean
     - name attribute specifies the property name
     - value attribute sets a literal value
     - ref attribute refers to another bean by id

     - If we are not specyfing anything in scope then it is SINGLETON else whatever we r specyfying it is that