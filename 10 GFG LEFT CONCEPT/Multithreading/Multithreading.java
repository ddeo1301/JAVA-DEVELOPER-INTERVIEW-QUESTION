// 1) Java Thread Example by extending Thread class

class Multi extends Thread{  
    public void run(){  
        System.out.println("thread is running...");  
    }  
    public static void main(String args[]){  
        Multi t1=new Multi();  
        t1.start();  // thread is running...
    }  
}  



// 2) Java Thread Example by implementing Runnable interface
class Multi3 implements Runnable{  
    public void run(){  
        System.out.println("thread is running...");  
    }  
    
    public static void main(String args[]){  
        Multi3 m1=new Multi3();  
        Thread t1 =new Thread(m1);   // Using the constructor Thread(Runnable r)  
        t1.start();  // thread is running...
    }  
}  

// If you are not extending the Thread class, your class object would not be treated as a thread object.
// So you need to explicitly create the Thread class object. We are passing the object of your class that implements
//  Runnable so that your class run() method may execute.



// 3) Using the Thread Class: Thread(String Name)
// We can directly use the Thread class to spawn new threads using the constructors defined above.

public class MyThread1  {  
// Main method  
    public static void main(String argvs[])  
    {  
        // creating an object of the Thread class using the constructor Thread(String name)   
        Thread t= new Thread("My first thread");  
        
        // the start() method moves the thread to the active state  
        t.start();  
        // getting the thread name by invoking the getName() method  
        String str = t.getName();  
        System.out.println(str); // My first thread 
    }  
}  

// 4) Using the Thread Class: Thread(Runnable r, String name)

public class MyThread2 implements Runnable  {    
    public void run()  
    {    
    System.out.println("Now the thread is running ...");    
    }    
        
    // main method  
    public static void main(String argvs[])  
    {   
        // creating an object of the class MyThread2  
        Runnable r1 = new MyThread2();   
        
        // creating an object of the class Thread using Thread(Runnable r, String name)  
        Thread th1 = new Thread(r1, "My new thread");    
        
        // the start() method moves the thread to the active state  
        th1.start();   
        
        // getting the thread name by invoking the getName() method  
        String str = th1.getName();  
        System.out.println(str);  
    }    
}    
// Output:
// My new thread
// Now the thread is running ...



// COMPLETABLE FUTURE
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Create a CompletableFuture that runs asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return "Task interrupted";
            }
            return "Hello from CompletableFuture";
        });

        // Register a callback to be executed when the task is complete
        future.thenAccept(result -> System.out.println(result))
              .exceptionally(ex -> {
                  System.out.println("Error: " + ex.getMessage());
                  return null;
              });

        // Wait for the CompletableFuture to complete
        future.join();
    }
}

// Explanation of the Example
// Asynchronous Task: The supplyAsync method runs a task asynchronously, simulating a delay with Thread.sleep.
// Callback Registration: The thenAccept method registers a callback that processes the result once the computation 
// is complete.
// Exception Handling: The exceptionally method provides a way to handle any exceptions that occur during the
// computation.
// Joining: The join method is called to wait for the completion of the CompletableFuture, ensuring that the main
// thread does not exit prematurely.

// CompletableFuture provides a robust framework for asynchronous programming in Java, enabling developers to write
//  non-blocking, efficient, and scalable code. Its ability to handle complex workflows, manage exceptions, and
//  compose multiple asynchronous tasks makes it a valuable tool for modern Java applications. By leveraging
//  CompletableFuture, developers can take full advantage of multi-core processors and improve application
//  responsiveness.