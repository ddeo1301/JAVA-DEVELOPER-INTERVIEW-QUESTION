SPRING LIFECYCLE
 - In Spring Framework, a "bean" is an object that is managed by the Spring IoC (Inversion of Control) container

- LIFECYCLE OF BEAN FROM INSTANTIATION TO DESTRUCTION 

    1. Instantiation
        - The Spring container instantiates the bean using the constructor defined in the bean configuration
           file (XML, Java configuration, or annotations).
    2. Populating Properties
        - After instantiation, the Spring container populates the bean’s properties using dependency
          injection. This involves setting the values for the bean’s properties as specified in the 
          configuration.
    3. Bean Name Aware
        - If the bean implements the BeanNameAware interface, the Spring container passes the bean’s ID (name) to the bean by calling the **setBeanName(String name)** method.
    4. Bean Factory Aware        - **setBeanFactory(BeanFactory beanFactory)**
    5. Application Context Aware - **setApplicationContext(ApplicationContext context)** method.
    6. Pre-Initialization (BeanPostProcessors)   **postProcessBeforeInitialization(Object bean, String beanName)**
        - The Spring container calls the postProcessBeforeInitialization methods of any BeanPostProcessor 
          implementations. These methods allow for custom modification of new bean instances before any
          initialization callbacks are invoked.
    7. Initializing Bean - **afterPropertiesSet()**method.
                         Alternatively, you can specify a custom init-method in the bean configuration.
    8. Post-Initialization (Bean Post Processors)   ..... LINES SAME AS 6
        **postProcessAfterInitialization(Object bean, String beanName)** 
    9. Bean Ready to Use
            At this stage, the bean is fully initialized and ready for use by the application.
    10. Destroying Bean
        - When the Spring container is shut down, it destroys the bean. If the bean implements the  
          DisposableBean interface, the Spring container calls the destroy method. Alternatively, you can 
           specify a custom destroy-method in the bean configuration. 
                **DisposableBean: destroy()**

EXAMPLE

    // XML Configuration

    <bean id="myBean" class="com.example.MyBean"
        init-method="init" destroy-method="cleanup">
        <property name="property1" value="value1"/>
    </bean>

    // Java Configuration

    @Configuration
    public class AppConfig {

        @Bean(initMethod = "init", destroyMethod = "cleanup")
        public MyBean myBean() {
            return new MyBean();
        }
    }

    // Annotations

    @Component
    public class MyBean implements InitializingBean, DisposableBean {
        
        @Value("${property1}")
        private String property1;

        @Override
        public void afterPropertiesSet() throws Exception {
            // initialization logic
        }

        @Override
        public void destroy() throws Exception {
            // cleanup logic
        }
    }



SINGLETON  VS  SINGLE BEAN SCOPE
 -  **SINGLETON** scope is the default scope in Spring. 
 - A singleton-scoped bean means that the Spring IoC container will create exactly one instance of the bean, 
    and this single instance will be shared across the entire Spring application context.
 - Initialization : Eager (default), can be lazy
 - Lifecycle : Managed by Spring (initialization and destruction)	

 - A SINGLE BEAN PROTOTYPE SCOPE bean means that the Spring IoC container will create a new instance of the
     bean every time it is requested from the container
 - Each request results in a new instance, meaning the instances are not shared across different components.
 - Initialization : Lazy, created only when requested
 - Lifecycle : Initialization managed by Spring, destruction not managed	



SPRING BEAN SCOPE
1) Singleton: 
    - It returns a single bean instance per Spring IoC container.
    - This single instance is stored in a cache of such singleton beans, and all subsequent requests and 
    references for that named bean return the cached object. 
    - If no bean scope is specified in the configuration file, singleton is default. 
    - Real world example: connection to a database

2) Prototype: 
    - It returns a new bean instance each time it is requested. 
    - It does not store any cache version like singleton. 
    - Real world example: declare configured form elements (a textbox configured to validate names, e-mail 
              addresses for example) and get "living" instances of them for every form being created

3) Request: 
    - Request scope bean creates a different instance of the bean for every HTTP request.
    - It returns a single bean instance per HTTP request. 
    - Real world example: information that should only be valid on one page like the result of a search or 
                the confirmation of an order. The bean will be valid until the page is reloaded. 

4) Session: 
    - Session scope bean creates a different instance of the bean for every Session  request. 
    - It returns a single bean instance per HTTP session (User level session). 
    - Real world example: to hold authentication information getting invalidated when the session is closed
            (by timeout or logout). You can store other user information that you don't want to reload with
             every request here as well.

5) GlobalSession: 
    - It returns a single bean instance per global HTTP session. 
    - It is only valid in the context of a web-aware Spring ApplicationContext (Application level session). 
    - It is similar to the Session scope and really only makes sense in the context of portlet-based web applications. 
    - The portlet specification defines the notion of a global Session that is shared among all of the 
    various portlets that make up a single portlet web application. 
    - Beans defined at the global session scope are bound to the lifetime of the global portlet Session.

6) Application: 
    - application scope bean creates a different instance of the bean for the lifecycle of ServletContext. 

 - FOR POINT **3) 4) 5)** only :- It is available only if you use a web-aware Spring ApplicationContext implementation (such as XmlWebApplicationContext)

7) WebSocket: 
    - Websocket scope creates it for a particular web socket session. 
    - It is available only if you use a web-aware Spring ApplicationContext implementation (such as 
    XmlWebApplicationContext)
 

