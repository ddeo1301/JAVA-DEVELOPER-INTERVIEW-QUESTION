- Collection :- represent unified architecture for storing and manipulating data....interface extends from iterable
- Collections :- utility class that provides methods that we can perform on the collection classes


ARRAYLIST
 - class uses dynamic array for storing elements while linkedlist uses doubly linked list to store the elements
 - no size limit, contain duplicate element, maintain insertion order, not synchronized, 
 - manipulation is little slower then linked list bcoz a lot of shifting neeeds to occur if any element is removed
 - cannot create an arraylist of primitive types such as int, float, char etc. Required to use wrapper class in such case

 ARRAYLIST AND VECTOR
  - ArrayList is not synchronised so faster then vector and vector is synchronised
  - ArrayList increments 50% of current array size if no. of elements exceeds from its capacity but Vector 100%
  - 


HASHSET
 - used to create a collection that uses a hashtable for storage by using mechanism Hashing
 - contains unique element, allows NULL value, not synchronised
 - doesnot maintain insertion order and inserted on the basis of their hashcode

 - LINKED HASHSET 
     - maintains insertion order but consumes extra m/m and CPU cycles

 - TREESET
     - maintains ascending order
     - implemented using binary search tree which is just like Red-Black Tree so operations such as search, remove, 
     add takes O(log(N)) time because its self balancing tree 
     - tree height never exceeds o(lon(N)) for all maintained operations so it is efficient Data Structure in order
     to keep large data that is sorted and do operations on it


MAP
 - doesnot allow duplicate keys, not synchronised
 - HashMap and LinkedHashMap allow 1 NULL keys and multiple values but TreeMap doesnot allow any NULL key but can
  have multiple NULL values
 - HashMap doesnot maintain any order 
 - LinkedHashMap maintain order
 - TreeMap maintains ascending order

- HASHTABLE ClASS
     - Hashtable is an array of list and each list is known as bucket. position of bucket is identified by calling 
     the Hashcode() method. Hashtables contains value based on keys
     - conatins unique elements and doesnot allow null key or value, is synchronized
     - slower then HashMap


HASHMAP
 - HASHING
     - process of converting an object into an integral values. Integral value helps in indexing and faster searches
 - HashMap contains array of nodes and the node is represented as a class
  
 - equals()
     - checks the equality of 2 objects. compares the key whether they r equal or nt. method of Object class
     - can be overridden. If we override equals() method then it is mandatory to override the hashCode() method
 - hashCode()
     - method of Object class which returns the m/m reference of the object in integer form. 
     - value received from the method is called bucket number which is address of the element inside the map. 
     - HashCode of null value is 0
 - Buckets
     - Array of node is called buckets. Each node has data structure like linkedList.
     - More then 1 node can share same bucket . It may be diffrent in capacity

 - CALCULATING INDEX :- 
     - put() method to insert key, value pair in HashMap. Default size of HashMap is 16(0 to 15)
     - Index = hashCode(key) & (n-1) where n is size of the array
     - If Index of 2 keys are same, equals() method check that both Keys are equal or not. If Keys are same, 
     replace the value with the current value. Otherwise, connect this node object to the existing node object
      through the LinkedList. Hence both Keys will be stored at same index .
     
     - get() method is used to get the value by its key, when it is called it calculates the hashCode of the key
     - After generating hashCode, it calculates the index value and search for the index value
     - It comapres the 1st element key. If both keys are equal, then it return the value else check for the next 
     element in the node if it exists or nt

 
 - Comparable Interface
     - It provides a single sorting sequence i.e we can sort the elements on the basis of single data member only.
     - eg:- rollNo, Name

 - Comparator Interface
     - contains 2 methods compare(Object obj1, Object obj2) and equals(Object element)
     - It provides multiple sorting sequence i.e we can sort the element on the basis of any data member


 - INITIALIZATION
    - Initialization in programming refers to the process of assigning an initial value to a variable or an object.
    -  often discussed in relation to the Singleton design pattern but are applicable to other scenarios as well.

      
 - Feature	            Early(Eager) Initialization	                             Lazy Initialization
 
Initialization Time	    At class loading	                                 On first access
Resource Usage	        Instance is always created, even if not used	     Instance created only when needed
Simplicity	            Simple and easy to implement	                   More complex, especially when thread-safe
Thread Safety	        Inherently thread-safe	                        Requires explicit handling for thread safety
Performance Overhead	Potential overhead during application startup	    Potential latency on first access

 -  If you want simplicity and are not concerned about resource usage, early initialization is a good choice. 
 - If resource efficiency and on-demand creation are more important, lazy initialization is more appropriate, 
 though it requires careful handling to ensure thread safety.



QUEUE(FIFO)
 - DEQUE
     - double ended queue
     - NULL elements are nt allowd, no capacity restriction, faster then linkedlist and stack
    



SINGLETON 
  - Logging        Database Connections     Kafka/Redis Connections
  - Early Initialization
  - Lazy Initialization 


 - FUNCTIONAL INTERFACE(Single Abstract Method Interfaces or SAM Interfaces)
     - An Interface that contains exactly one abstract method is known as functional interface. 
     - It can have any number of default, static methods but can contain only one abstract method. 
     - It can also declare methods of object class.


                    interface sayable{  
                        void say(String msg);  
                    }  
                    public class FunctionalInterfaceExample implements sayable{  
                        public void say(String msg){  
                            System.out.println(msg);  
                        }  
                        public static void main(String[] args) {  
                            FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
                            fie.say("Hello there");  // Hello there
                        }  
                    }  

 - A functional interface can have methods of object class.

                    interface sayable{  
                        void say(String msg);   // abstract method  
                        // It can contain any number of Object class methods.  
                        int hashCode();  
                        String toString();  
                        boolean equals(Object obj);  
                    }  
                    public class FunctionalInterfaceExample2 implements sayable{  
                        public void say(String msg){  
                            System.out.println(msg);  
                        }  
                        public static void main(String[] args) {  
                            FunctionalInterfaceExample2 fie = new FunctionalInterfaceExample2();  
                            fie.say("Hello there");  // Hello there
                        }  
                    } 

 - A functional interface can extends another interface only when it does not have any abstract method.

                        interface sayable{  
                            void say(String msg);   // abstract method  
                        }  
                        @FunctionalInterface  
                        interface Doable extends sayable{  
                            // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface  
                            void doIt();  
                        }   

 - In the following example, a functional interface is extending to a non-functional interface.

                        interface Doable{  
                            default void doIt(){  
                                System.out.println("Do it now");  
                            }  
                        }  
                        @FunctionalInterface  
                        interface Sayable extends Doable{  
                            void say(String msg);   // abstract method  
                        }  
                        public class FunctionalInterfaceExample3 implements Sayable{  
                            public void say(String msg){  
                                System.out.println(msg);  
                            }  
                            public static void main(String[] args) {  
                                FunctionalInterfaceExample3 fie = new FunctionalInterfaceExample3();  
                                fie.say("Hello there");  //Hello there
                                fie.doIt();  // Do it now
                            }  
                        }  


- SOME BUILT-IN JAVA FUNCTIONAL INTERFACES 
 1) Runnable –> This interface only contains the run() method.
 2) Comparable –> This interface only contains the compareTo() method.
 3) ActionListener –> This interface only contains the actionPerformed() method.
 4) Callable –> This interface only contains the call() method.

- JAVA SE 8 INCLUDE 4 MAIN KINDS OF FUNCTIONAL INTERFACES

 1) Consumer 
  - The consumer interface of the functional interface is the one that accepts only one argument .
  - has no return value. It returns nothing. 
  - There are also functional variants of the Consumer — DoubleConsumer, IntConsumer, and LongConsumer. These 
  variants accept primitive values as arguments.
 
 -  Bi-Consumer
     - Bi-Consumer interface takes two arguments. Both, Consumer and Bi-Consumer have no return value and returns 
     nothing. It is used in iterating through the entries of the map

                        SYNTAX
                        Consumer<Integer> consumer = (value) -> System.out.println(value);

 2) predicate functional interface of Java
     -  is a type of function that accepts a single value or argument and does some sort of processing on it, and 
     returns a boolean (True/ False) answer. 
     - The implementation of the Predicate functional interface also encapsulates the logic of filtering (a process
      that is used to filter stream components on the base of a provided predicate) in Java.
      - Some extensions of predicate are IntPredicate, DoublePredicate, and LongPredicate. These types of predicate
       functional interfaces accept only primitive data types or values as arguments.  
  
  -  Bi-Predicate
   -  instead of one, takes two arguments, does some processing, and returns the boolean value.

                        public interface Predicate<T> {
                            boolean test(T t);
                        }

                        // syntax for the implementation of predicate functional interface using a class
                        public class CheckForNull implements Predicate {
                            @Override
                            public boolean test(Object o) {
                                return o != null;
                            }
                        }

                        // predicate functional interface can also be implemented using Lambda expressions
                        Predicate predicate = (value) -> value != null;


 3) Function 
     - A function is a type of functional interface in Java that receives only a single argument and returns a 
     value after the required processing. 
     - There are many versions of Function interfaces because a primitive type can’t imply a general type argument,
      so we need these versions of function interfaces. 
     - Many different versions of the function interfaces are instrumental and are commonly used in primitive types 
     like double, int, long.
     - The different sequences of these primitive types are also used in the argument.
 
     -  Bi-Function :- it takes two arguments, whereas Function accepts one argument. 

                    public interface BiFunction<T, U, R> 
                    {
                    R apply(T t, U u);
                        .......// T and U are the inputs, and there is only one output which is R. 
                    }

     - Unary Operator :- Unary Operator extends Function

                    public interface UnaryOperator<T> extends Function<T, U> 
                    {
                        ……...
                    }
     
     -  Binary Operator :-  Binary Operator extends Bi-Function. 

                    public interface BinaryOperator<T> extends BiFunction<T, U, R> 
                    {
                        ……...
                    }

 4) Supplier functional interface
  - is a type of functional interface that does not take any input or argument and yet returns a single output.
  - This type of functional interface is generally used in the lazy generation of values. 
  - Supplier functional interfaces are also used for defining the logic for the generation of any sequence. 
  - For example – The logic behind the Fibonacci Series can be generated with the help of the Stream. generate 
  method, which is implemented by the Supplier functional Interface. 

  - The different extensions of the Supplier functional interface hold many other suppliers functions like
   BooleanSupplier, DoubleSupplier, LongSupplier, and IntSupplier. 
  - The return type of all these further specializations is their corresponding primitives only. 

                    Syntax / Prototype of Supplier Functional Interface is –
                        @FunctionalInterface
                        public interface Supplier<T>{
                        
                            // gets a result
                            ………….                     
                            // returns the specific result
                            …………
                            T.get();
                        
                        }


                    // A simple program to demonstrate the use of predicate interface

                    import java.util.*;
                    import java.util.function.Predicate;
                    
                    class Test {
                        public static void main(String args[])
                        {
                            // create a list of strings
                            List<String> names = Arrays.asList(
                                "Geek", "GeeksQuiz", "g1", "QA", "Geek2");
                    
                            // declare the predicate type as string and use
                            // lambda expression to create object
                            Predicate<String> p = (s) -> s.startsWith("G");
                    
                            // Iterate through the list
                            for (String st : names) {
                                // call the test method
                                if (p.test(st))
                                    System.out.println(st);
                            }
                        }
                    }