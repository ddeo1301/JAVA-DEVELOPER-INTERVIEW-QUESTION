class name same as public class. class first main method find krega....

"main" is not reserved keyword in java...

RESERVED KEYWORD in java have specific meanings and are part of language syntax, like 'class', 'public', 'static',
 'if', 'else' etc

The word 'main' is conventionally used as the name for the entry point method of a java application

The signature of the 'main' method must be "public static void main(String[] args)" for the JVM to recognise it as
 the application's entry point

Despite its special role, 'main' can be used as an identifier(variable name) elsewhere, such as in method
 names(with diff signatures) or variable names, because it is not reserved by the language

default value of char in java is \0 i.e U+0000

int myNum = 500 stores it in 4 bytes which is like 00000000 00000000 00000001 11110100
byte num = (byte) myNum;    now converting it into 1 byte, 11110100 = -12. as byte range is between -128 to 128, 
so java wraps value during narrowing conversion to fit them into target data type range
long a = 100L;   L is important.......float f = 3.14f........till 7 decimal point
explicit :- write double, long -> int, float -> char, short -> byte, boolean
nextInt().....nextBigInteger()......nextFloat()

GARBAGE COLLECTIONS: Automatic process in Java that frees up m/m by reclaiming space occupied by object that are no
 longer in use by program, preventing memory leaks.
Memory Leaks: Occur when objects are unintentionally retained in memory, leading to gradual memory consumption and
potential program crashes. eg:- when a collections(such as list or map) holds reference to object that are no
longer needed, but these reference are not removed from the colection

RESOURCE LEAKS: Occur when resources like file handles or database connections are not properly released, leading
 to resource exhaustion. eg:- when file is opened for reading but not closed after reading is complete....here it 
 consumes system resource unnecessarily....sc.close();

Garbage collection helps prevent memory leaks, but developers must also manage object references and release 
resources properly to avoid both memory and resource leaks in Java applications.

for(;;) is a standard way to create an infinite loop, as it has no initialization, condition, or update expressions.
 It simply means "repeat indefinitely".

STRING POOL :- Java maintains special area in java heap called the string pool where all string literals are stored.
 when we create a string using string literals, java checks the pool first. if the string already exist, it returns
  the reference to the same instance, helping to same memory

IMUTABLE STRING :- string in java are immutable, which means once a string object is created, its value cannot be 
changed. If u perform any operations that seems to modify a string, what actually happens is a new string object is
 created.

str.contains("Divyanshu")    str.startsWith("Div")    str.endsWith("Div")
String name = str.replace('o', 'a')        char[] ch = str.toCharArray()
String str = String.valueOf(23);  converts diff data type(int, long, float, double, boolean, char, charArray, object)
     into string representation
isEmpty() :- checks if string is empty(length is 0)
isBlank() :- checks if string is blank(empty or contains only white space characters)


    String ats = Arrays.toString(digits);   // array to string 
    int val = Integer.parseInt(ats.replace("[", "").replace("]", "").replace(",", "").replace(" ", "")); // string to int
    String sti = String.valueOf(val);  
        int[] ans = new int[sti.length()];
        
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Character.getNumericValue(sti.charAt(i));
        }





WRAPPER CLASS in java are used to convert primitive types (int, char, float) into corresponding objects

NEED OF WRAPPER CLASS :- 
   1) The classes in java.util packages handles only objects and hence wrapper classes help in this case also
   2) Data Structure in the collections framework, such as ArrayList and Vector, store only objects
   (reference types) and not primitive types
   3) An object is needed to support synchronization in multithreading

package Wrapper;

public class LearnWrapper {
    public static void main(String[] args) {
        // primitive type -> OBJECT  (AUTOBOXING)
        int num = 5;
        // let convert int into object
        Integer n = Integer.valueOf(num + 1); // 6
        Integer m = Integer.valueOf(8 );  // 8
        System.out.println(n);
        System.out.println(m);
        Integer n1 = num;
        System.out.println(n1 + 2); // 7
        // This is only called autoboxing that how we applied box of wrapper class above primitive


        // WRAPPER OBJECT INTO PRIMITIVE TYPES   (UNBOXING)
        Integer number = 50;
        // let convert integer object into int
        if(number instanceof Integer){
            System.out.println("Yes it is Integer object");  // Yes it is Integer object
        }
        // wrapper object -> number is ready

        // let's convert it into a primitive type
        int num1 = number;  // number.isValue()
        System.out.println(num1+4);  // 54
    }
}

AUTOBOXING :- Automatic conversion of primitive data types into its corresponding wrapper class. Since java5
we donot need the valueOf() method of wrapper class to convert primitive into object
int a = 10;
Integer j = a;

UNBOXING :- Automatic conversion of wrapper type into its primitive type . Reverse of autoboxing. Since java5
we dont need to use the intValue() method of wrapper classes to convert the wrapper type to primitives
Integer j = a
int a = 10;

Characteristics of Anonymous Classes:
 1) No Name: As the name suggests, an anonymous class does not have a name.
 2) Single Use: They are often used for one-time use, making the code more concise.
 3) Inline: Anonymous classes are defined and instantiated in a single statement.
 4) Limited Scope: They can be used only in the scope where they are defined.

 Anonymous classes are typically created in the context of implementing an interface or extending a class
    InterfaceOrSuperclass object = new InterfaceOrSuperclass() {
        // Class body
    };

Key Points to Remember:
 1) Accessing Variables: Anonymous classes can access final or effectively final local variables from the
  enclosing scope.
 2) Limited Capabilities: Since anonymous classes are unnamed and defined in a single expression, they cannot 
 define constructors. They can only have instance initializer blocks.
 3) Type Inference with Diamond Operator: In Java 7 and later, anonymous classes can use the diamond operator for
  type inference when the type parameters can be inferred from the context.
            List<String> list = new ArrayList<>() {
                // Additional methods or initializations can go here
            };

Limitations:
 1) Code Readability: Overuse of anonymous classes can lead to less readable and maintainable code.
 2) No Constructors: Since anonymous classes cannot have constructors, complex initialization can be tricky.
 3) Single Instantiation: They are meant for single use and cannot be reused like named classes.

