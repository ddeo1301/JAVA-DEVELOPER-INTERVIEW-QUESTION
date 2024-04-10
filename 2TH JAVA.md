Q1)  JAVA INNER CLASS 

To access the inner class, create an object of the outer class, and then create an object of the inner class:
class OuterClass {
  int x = 10;

  class InnerClass {
    int y = 5;
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println(myInner.y + myOuter.x);    // // Outputs 15 (5 + 10)

    // private class InnerClass :-  error: OuterClass.InnerClass has private access in OuterClass. 
           Unlike a "regular" class, an inner class can be private or protected. If you don't want 
            outside objects to access the inner class, declare the class as private:
   // An inner class can also be static, which means that you can access it without creating an object 
         of the outer class:

  }
}



Q2) ENUMS :- enum is special class that represent a group of constants(unchangeable variables like final variable). To create an enum, use the enum keyword (instead of class or interface), and separate the constants with a comma. Note that they should be in uppercase letters:
public class Main { 
  enum Level {
    LOW,
    MEDIUM,
    HIGH
  }

  public static void main(String[] args) { 
    Level myVar = Level.MEDIUM;    // You can access enum constants with the dot syntax:
    System.out.println(myVar); 
  } 
}



Difference between Enums and Classes
An enum can, just like a class, have attributes and methods. The only difference is that enum constants are public, static and final (unchangeable - cannot be overridden).

An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).

Why And When To Use Enums?
Use enums when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.



Q3 - exception handling and how to create custom exception

Exception handling is a crucial mechanism in Java for dealing with unexpected errors or conditions that may arise during program execution. It allows you to gracefully handle these errors, prevent program crashes, and provide meaningful feedback to the user.

// Custom exception class extending Exception class
public class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
public class Example {
    public static void main(String[] args) {
        try {  // try block encloses the code that may throw an exception.
            // Code that may throw MyCustomException
            throw new MyCustomException("This is a custom exception");
        } catch (MyCustomException e) {  // catch block catches and handles the exception if it matches 
                                         //  the specified type.
            // Handle MyCustomException
            System.out.println("Caught MyCustomException: " + e.getMessage());
        }finally{
            System.out.println("Code that will always execute, whether an exception is caught or not");
        }
    }
}



Q3)  error and exception in java
ERROR :- Errors are serious problems that usually crash your entire program or even the system itself. 
         Usually not recoverable by the application
  - OutOfMemoryError: Thrown when the Java Virtual Machine (JVM) runs out of memory.
  - StackOverflowError: Thrown when the call stack overflows due to too many method invocations.
  - NoClassDefFoundError: Thrown when a required class cannot be found.

EXCEPTIONS - are like small hiccups or bumps in the road that your program might encounter during its 
        journey. They're unexpected situations that your program can handle or recover from, like 
        trying to read a file that doesn't exist or dividing by zero. Can be caught and handled using 
        try-catch blocks




Q4 - Java Collection Framework . difference and when to use what
     The Java Collection Framework (JCF) is a set of classes and interfaces provided in the Java API to 
    handle collections of objects. It provides various data structures and algorithms to store, 
    manipulate, and retrieve groups of objects efficiently. List, Set, Map, Queue, 



Q5 - how do we create thread and lifecycle of thread

 you can create threads by extending the Thread class or implementing the Runnable interface.
 // Extending the Thread class:
 public class MyThread extends Thread {
    public void run() {
        // Code to be executed by the thread
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Start the thread
    }
}

// Implementing the Runnable interface:
public class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed by the thread
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // Start the thread
    }
}


Thread is well known for independent execution. During the life cycle a thread can move from diff. state
1) New State(born)
2) Runnable State (Ready)
3) Running State (Execution)
4) Waiting State (Blocked)
5) Dead State(Exit)

t BORN-->t.state READY --> if thread schedular has selected RUNNING -->run() or t.stop()  DEAD

RUNNING --> t.suspend() or t.join() or t.sleep() or t.wait()  --> BLOCKED --> READY ( in suspend t.resume karo and rest m khud chala jayega)




Q5) how to get a thread
// Get the name of the current thread
String threadName = currentThread.getName();

// Get the ID of the current thread
long threadId = currentThread.getId();

// Set the priority of the current thread
currentThread.setPriority(Thread.MAX_PRIORITY);

// Check if the current thread is a daemon thread
boolean isDaemon = currentThread.isDaemon();

// Check if the current thread is alive (i.e., has started and not yet terminated)
boolean isAlive = currentThread.isAlive();




Q6 - what is static content and dynamic content
STATIC CONTENT :- prebuilt content is same everytime. use html code for developing a website. doesnot access imformation from the datatbase. unchanged or constant. user can read imformation but cant update it eg:- wikipedia
DYNAMIC CONTENT :- content is generated quickly and changes regularly. it uses server side language like PHP, node. Aceess imformation from database.  continouslu updated. can read and update at same time. eg:- flipkart



Q7 - how do u increase performance in sql
  - Avoid using SELECT * and fetch only the columns you need.
  - Use WHERE clauses to filter data early in the query.
  - Utilize proper indexing to speed up query execution.
  - Create appropriate indexes on columns used in WHERE, JOIN, and ORDER BY clauses.
  - Use WHERE instead of HAVING to define filters:




Q8 - what is string constant pool
  -  Java String Pool is a place in heap memory where all the strings defined in the program are stored. 
    A separate place in a stack is there where the variable storing the string is stored. Whenever we 
     create a new string object, JVM checks for the presence of the object in the String pool, If String 
    is available in the pool, the same object reference is shared with the variable, else a new object 
    is created.

// Program 1: Comparing two references to objects 
// created using literals. 
import java.util.*; 
  
// Driver Class 
class GFG { 
    // main function 
    public static void main(String[] args) 
    { 
        String s1 = "abc"; 
        String s2 = "abc"; 
  
        // Note that this == compares whether 
        // s1 and s2 refer to same object or not 
        if (s1 == s2) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
}



Q9) how do you deduct loop in linkedlist
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    // Method to delete a node with given data from the linked list
    public void deleteNode(int key) {
        Node current = head;
        Node prev = null;

        // Case 1: If the node to be deleted is the head node
        if (current != null && current.data == key) {
            head = current.next; // Move head to the next node
            return;
        }

        // Case 2: Traverse the list to find the node to be deleted
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // Case 3: If the node with the given data is not found
        if (current == null) {
            return;
        }

        // Case 4: Node with the given data is found, unlink it from the list
        prev.next = current.next;
    }
}
