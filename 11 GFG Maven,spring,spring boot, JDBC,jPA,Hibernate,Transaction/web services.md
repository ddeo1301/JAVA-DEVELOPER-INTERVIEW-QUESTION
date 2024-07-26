WEB SERVICES
  - Earlier static and dynamic content use to be on same server 
  - Issues :- Performance Issue, Scalablity, Load Balancing, If one fails then entire system fails

 - Through standared protocol they r going to interact b/w server and client
    1) HOSTIP :- where exactly our service is runnning
    2) PORT   :- Every server can run various task or application on it . For every application there are 
                 dedicated port on it. eg:- we have reached the host 10.20.30.12, Now exactly where we need 
                 to go , there we require the PORT
    3) METHOD :- For example now we reached the vistara backend, Nowexactly which method is required like 
                 booking flight etc so here we need to specify which method we need to go
    4) PARAMETER

  - As we have centralized standared protocols, so it doesnot matter that our client and server are written in same language or different language

 - A web service is a set of open protocols and standards that allow data to be exchanged between different
    applications or systems.
 - A standardized way of propagating messages between server and client applications.
 - The web service would be able to deliver functionality to the client that invoked the web service.
 - Location approach with independence of Programming language.


TYPES OF WEB SERVICES
   1) SOAP (Simple Object Access Protocol):
      - XML based protocol for accessing web services.
      - Has its own security called WS security.
      - Uses WSDL file (Web Services Description Language) which is an xml document which contains 
         information about path and end point and how to use that method.

   2) RESTful (Representational State Transfer) Web Services:
       - Permits different data types such as plain text, HTML, XML and JSON.
       - Can use soap as implementation.


WEB SERVER AND APPLICATION SERVER

  WEB SERVERS :
   - Accepts and fulfills requests from clients for static content (i.e. HTML Pages, images, videos). Web 
   servers handle HTTP requests and responses only.
   - Example Apache HTTP Server, Microsoft  Internet Information Services, Nginx

   APPLICATIONS SERVER :   

    - Exposes business logic to the clients, 
    which generates dynamic content.
    - It is a software framework that transforms data to provide the specialized functionality offered by a 
       business, service or application.
    - Servers enhance the interactive parts of a website that can appear differently depending upon the 
       context of the request.
    - Eg: Oracle WebLogic Server, JBoss (WildFly), Apache Tomcat (also serves as a web server),Microsoft .NET Framework



   - KEY DIFFRENCES
       - TASKS : Web servers handle simple HTTP requests, while application servers process complex business logic
       - PROTOCOLS : Web servers primarily use HTTP, while application servers support additional protocols
       - CONTENT : Web servers deliver static content, while application servers generate dynamic content
       - MULTITHREADING : Application servers use multithreading for scalability, while web servers use 
                           non-blocking I/O and event-driven architecture

   - WORKING TOGETHER
       - Web servers receive requests first and handle static content or forward dynamic requests to 
          application servers
       - Application servers process business logic and pass the result back to the web server to deliver to 
          the client
       - The line between web servers and application servers has become blurred as web servers support more
          dynamic content and application servers incorporate web server capabilities

  - whenever our traffic are high load balancer will ensurethat how many request are served by each server
  - whenever java code is running on server it is always running but when it is nt deployed on any server then
     whatever functionality you would run, it tried to get executed and it will stop

 
SCALING

  HORIZONTAL SCALING
   - Increases performance by adding more servers to distribute the load
   - Requires load balancing to distribute traffic across multiple servers
   - Provides fault tolerance and high availability by having redundant servers
   - Allows scaling on-demand by easily adding more servers as needed
   - Complexity: Managing a distributed system is more complex, requiring load balancing, data 
                  synchronization, and distributed computing strategies.
   - Consistency: Ensuring data consistency across multiple servers can be challenging.
   - Cost: Initial setup and maintenance of multiple servers can be expensive.

  VERTICAL SCALING 
   - Increases performance by upgrading components of an existing server, such as CPU, memory, storage
   - Usually requires minimal changes to the application code
   - Provides consistent performance by having a single robust server
   - May involve downtime during upgrades
   - Has a limit on how much a single server can be scaled up


 - Horizontal scaling is better for applications that can be easily distributed across servers, such as web
    apps, CDNs, and databases
 - Vertical scaling is suitable for applications that require high processing power but cannot be easily 
    distributed, such as legacy systems or resource-intensive databases
 - A hybrid approach combining both horizontal and vertical scaling is often the most effective strategy for
    handling global content distribution and massive datasets
 - horizontal scaling provides more flexibility and fault tolerance by distributing load across multiple 
 servers, while vertical scaling offers consistent performance by upgrading a single server.


 HTTP SERVER

  - Java provides built-in support for creating HTTP servers through the HttpServer class, which is part of the  com.sun.net.httpserver   package. 
  - This allows developers to implement a simple HTTP server without needing to handle low-level socket 
  programming directly.
        
        // 1) Import Required Packagesfor networking and handling HTTP requests.

        import com.sun.net.httpserver.HttpServer;
        import com.sun.net.httpserver.HttpHandler;
        import com.sun.net.httpserver.HttpExchange;

        import java.io.IOException;
        import java.io.OutputStream;
        import java.net.InetSocketAddress;

        public class SimpleHttpServer {
            public static void main(String[] args) throws IOException {
                
                // Use the HttpServer.create() method to instantiate server, specifying the hostname and port.
                HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
                
                // context /test is defined, and HttpHandler class is linked to handle requests for this path.
                server.createContext("/test", new MyHandler());

                // Set an executor to handle requests (null uses the default executor)
                server.setExecutor(Executors.newFixedThreadPool(4));

                // Start the server
                server.start();
            }

            // Define a custom handler
            static class MyHandler implements HttpHandler {
                @Override
                public void handle(HttpExchange exchange) throws IOException {

                    String response = "Hello, World!";

                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();

                    //  Inside HttpHandler, the handle method processes incoming requests. 
                    // It sends a simple "Hello, World!" response with a 200 OK status.
                }
            }
        }



      -  SPRING CODE FOR ABOVE HTTP SERVER
      
                import org.springframework.boot.SpringApplication;
                import org.springframework.boot.autoconfigure.SpringBootApplication;
                import org.springframework.web.bind.annotation.GetMapping;
                import org.springframework.web.bind.annotation.RestController;

                @SpringBootApplication
                public class SpringBootHttpServer {
                    public static void main(String[] args) {
                        SpringApplication.run(SpringBootHttpServer.class, args);
                    }

                    @RestController
                    public class MyController {
                        @GetMapping("/")
                        public String hello() {
                            return "Hello, Spring Boot!";
                        }
                    }
                }



FEATURES AND LIMITATIONS:-

 1) Support for GET and POST: 
     - The server can be extended to handle different HTTP methods by checking exchange.getRequestMethod().
 2) Threading: 
     - For handling multiple requests simultaneously, you can set an executor to manage threads.
 3) Simplicity: 
     - This built-in server is suitable for lightweight applications and testing but may not be suitable for 
        production due to performance limitations and lack of advanced features.

CONCLUSIONS
 - Java's built-in HttpServer class provides a straightforward way to create an HTTP server with minimal code. 
 - It is particularly useful for developing small applications, prototypes, or for educational purposes,
  allowing developers to focus on higher-level logic without dealing with the complexities of socket 
  programming directly



