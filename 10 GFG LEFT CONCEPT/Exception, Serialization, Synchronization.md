- EXCEPTION HANDLING
   - Any unexcepted interuption that can occur in our program and stops its execution
   - Adavntage is to maintain normal flow of the application


THROWABLE

1) ERROR
    - Error is irrecoverable
    - StackOverFlowError    VirtualMachineError     OutOfMemoryError    AssertionError

2) EXCEPTION
    1) Compile Time Exception(Checked Exception)
        - 1) IO Exception    2) SQL Exception       3) Class Not Found Exception
        - these exception are checked at compile Time by the compiler

    2) Run Time Exception(Unchecked Exception)
        - 1) ArithmeticException   2) NullPointerException   3) NumberFormatException  4) IndexOutOfBoundException
        - If we didnt handle or declare it, the program wouldnt give the compilation error

                        - Throwable  - class
                        - cloneable    closeable    serializeable     -  Interface

- whenever any exceptions occur, it halts the execution of our program but if we handle the exception then it 
will not halts only below try statement will nt execute else all will execute

TRY
   - used to specify a block of where we should place an exception code and must be followed by either catch or finally
   - can give custom message on exception
   - try can execute without catch block
   - try may have multiple catch but only 1 finally
   - there may have multiple try-catch-finally . means try block inside other try block
   - try can have multiple catch block and highest level of catch should be at last

CATCH
   - catch will execute if there is any exception occured in try but finally will always execute
   - used to handle the exception. cant be used alone . must be preceded by try and can be followed by finally
   - catch(... | ...)
       - these both should have same parent else it will give exception
   - Exception(sbse last daalo) -> Runtime Exception -> Arithmetic Exception(Sbse phle daalo i.e most specific)
   - If try block have 2 exceptions. But at 1 time only 1 exception occurs and its corresponding catch block is executed

FINALLY
   - always excuted whether an exception is handled or not
   - there may be 0 or many catch block but only 1 finally block
   - finally block is not executed - System.exit()    or  JVM crashes
   - we write finally code to avoid duplicacy of code
   - used to put "cleanup" code such as closing a file, closing connection
   - phle saara code will run then exception will occur if exception nt handled by catch block

NESTED TRY
   - whena any try block doesnot have a catch block for particular exception, then catch block of outer(parent) try 
   block are checked for the exception. If none of the catch block can handle the exception, then java runtime will 
   handle the exception.


- TRY WITH RESOURCES
    - allows us to declare resource to be used in a try block with the assurance that resource will be closed after 
    the assurance that resource will be closed after the execution of that block



- THROW
    - used to throw an exception explicitly
    - can throw both checked and unchecked exception
    - throw new exeption_class("error message").......where instance must be type throwable or subclass of throwable
    - If we throw an unchecked exception from a method, it is must to handle the exception or declare in throw clause
    - If we throw an checked exception using throw keyword, it is must to handle the exception using catch block or method must declare it in throws declaration
    

- THROWS 
  - use to declare an exception and gives imformation to programmer that there may occur an exception so normal flow
  of program may be maintained
  - mainly checked exception should be declared because
      - unchecked exception are under our control so we can correct it
      - error is beyond our control. eg:- VirtualMachineError or StackOverFlowError
  - if we are calling a method that declares an exception, we must caught or declare the exception 
  - It doesnot throw an exception. It is always used with method signature

        void fun() throws FileNotFoundException{

        }

    - This exception must throw fileNotFoundException and if we are calling this exception then its our
    responsiblity to either handle this exception or pass it to our caller
    - If we write some code and we dont know how to handle the exception which may arise in code of exception, we 
    put those exception with throws keyword
    - Throws keyword is used to handle multiple exception. We can specify multiple exception comma seperated which 
  might generate in our function and not handled


- CUSTOM EXCEPTION :- we create on our own and used it


- Java Exception Propagation
     - exception is 1st thrown from top of the stack -> if nt caught, it drops the call stack to previous method
      -> if nt caught there, exception again drops down to the previous method and so on until they r caught or 
       they reach the very bottom of the call stack. This is called exception propogation
     - By default Unchecked Exceptions are forwarded in calling chain (propagated).
     - By default, Checked Exceptions are not forwarded in calling chain (propagated).


 - EXCEPTION HANDLING WITH METHOD OVERRIDING IN JAVA
     - If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but can declare unchecked exception.
     - If the superclass method declares an exception, subclass overridden method can declare the same subclass 
     exception or no exception but cannot declare parent exception.


 - JAVA CUSTOM EXCEPTION / USER DEFINED EXCEPTION
     - In Java, we can create our own exceptions that are derived classes of the Exception class.
     - Using the custom exception, we can have your own exception and message.


- EQUALS AND HASHCODE
    - a == b always compare memory location

- equals is returning true, then your hashcode should also return true
- hashcode is returning true, then your equals may or maynot return true(collisons)


FINALIZE
 - used to perform cleanup processing just before object is garbage collected
 - finalize() method is used with the objects
 - finalize method performs the cleaning activities with respect to the object before its destruction
 - finally method is executed just before the object is destroyed


SERIALIZATION
 - Serialization is a mechanism of converting the state of an object into a byte stream. 
 - It is mainly used in Hibernate, RMI, JPA, EJB and JMS technologies.
 - For serializing the object, we call the writeObject() method of ObjectOutputStream class


DESERIALIZATION (REVERSE OF SERIALISATION)
 - Deserialization is the process where the byte stream is used to recreate the actual Java object in memory.
 - For deserialization we call the readObject() method of ObjectInputStream class.


- serialization and deserialization process is platform-independent, it means you can serialize an object on one platform and deserialize it on a different platform.
- We must have to implement the Serializable interface for serializing the object.