
EXCEPTION :- In java, Exception is an unexpected event, which occurs during the execution of a program i.e at runtime, that disrupts the normal flow of the program's instruction. Exception can be caught and handled by the program.
It occurs due to :- 1) Invalid user input  2) Device failure  3) Loss of network connections 4)Physical limitations 5)Code Errors 6)Opening an available files

RUNTIME EXCEPTIONS :- It happens due to programming errors aka unchecked exceptions
RuntimeException is the superclass of all classes that exceptions are thrown during the normal exception of Java VM(virtual machine). The Runtime Exception and its subclasses are unchecked exceptions. The most common exceptions are NullPointerException(by mistake pointer is pointig to null and we r trying to acceess it), ArrayIndexOfBoundExceptions, classCastExceptions, InvalidArgumentExceptionException etc.

JAVA IOException exceptions :- is a checked exceptions that must be handled at compilation time. IOException is the base class for such exceptions which are thrown while accessing data from files, directories and streams. It represent a class or exceptions that are thrown when an I/O error occurs

package Exceptions;

import java.net.StandardSocketOptions;

public class LearnExceptions {
    public static void main(String[] args) {
        try{
            int a = 5/0;
            int arr[] = new int[5];
            System.out.println(arr[100]);
        }
        catch(Exception err){   // for any exception we r going to get as this is parent class of
            //  all exception
            System.out.println(err.getMessage());
            System.out.println(err.getStackTrace());
            System.out.println("we need to handle exception here");
        }
        catch(ArrayIndexOutOfBoundsException | ArithmeticException err){
            System.out.println(err.getMessage());
            System.out.println(err.getStackTrace());
            System.out.println("we need to handle exception here");
        }
        catch(ArithmeticException err){
            System.out.println(err.getMessage()); // tells what is the error message
            System.out.println(err.getStackTrace()); // stack race tells that our calls went from
            // where to where but issue here is that it return array and if we want to generate object
            // here then it will try to return toString method here
            System.out.println("we need to handle exception here");
        }finally{
            System.out.println("I will definetly execute whatsoever is the condition is");
        }
        System.out.println("After exception");
    }
}  // jaise hi exception milega it will directly go to its catch block without even seeing what is
   // written below it



TRY:- statement allows us to define a block of code to be tested for errors while it is being executed
CATCH:- statement allows us to define a block of code to be executed if an error occurs in the try block
FINALLY:- used to execute the code after the try and catch blocks have been executed.

1) System.exit() :- if called within try or catch block
2) Infinte loop or encounters Deadlock :-  bcoz program never reaches the point
3) system crash i.e crashing the JVM :- due to some unrecoverable error
from above three the finally block will not execute


THROWS KEYWORD :- We use throws keyword in the method declaration to declare the type of exceptions that might occur within it.
SYNTAX :- 
   accessModifier returnType methodName() throws ExceptionType1, ExceptionType2 ....{
         // code
   }


   import java.io.*;
   class Main{
       public static void findFile() throws NullPinterException, IOException, InvalidClassException {
           // code that may produce NullPinterException
              ------
           // code that may produce IOException
              ------
            // code that may produce InvalidClassException
              ------ 
       }

       public static void main(String[] args){
          try{
             findFile();
          }catch(IOException e1){
              System.out.println(e1.getMessage());
          }catch(IOException e2){
              System.out.println(e2.getMessage());
          }
       }
   }
// it is telling from before had only that all these types of exception may come so main method will handle all these exception


THROW KEYWORD :- is used explicitly throw a single exception. when an exception is thrown, the flow of program execution transfer from the try block to the catch block. we use throw keyword within the method

package Exceptions;

public class throwsExceptionHandling {

    public static void printName(String name) throws ArithmeticException, NullPointerException, DivyanshuException {
        if(name.equalsIgnoreCase("Divyans")) {
            throw new NullPointerException("Big blunder has been done");
            //null
            //very goood
        } else if(name.equalsIgnoreCase("Divyanshu")) {
            throw new DivyanshuException("own exception created by me");
            // Hello from deo
            //own exception created by me
            //very goood
        }
        System.out.println(name);
    }

    public static void main(String[] args) {
        try {
            printName("Divyanshu");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("very goood");
        }
    }
}

class DivyanshuException extends Exception {
    DivyanshuException(String message) {
        super(message);
        System.out.println("Hello from deo");
    }

}


