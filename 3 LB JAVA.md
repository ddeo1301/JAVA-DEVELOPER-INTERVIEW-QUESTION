class name same as public class. class first main method find krega....
"main" is not reserved keyword in java...
RESERVED KEYWORD in java have specific meanings and are part of language syntax, like 'class', 'public', 'static', 'if', 'else' etc
The word 'main' is conventionally used as the name for the entry point method of a java application
The signature of the 'main' method must be "public static void main(String[] args)" for the JVM to recognise it as the application's entry point
Despite its special role, 'main' can be used as an identifier(variable name) elsewhere, such as in method names(with diff signatures) or variable names, because it is not reserved by the language

default value of char in java is \0 i.e U+0000
int myNum = 500 stores it in 4 bytes which is like 00000000 00000000 00000001 11110100
byte num = (byte) myNum;    now converting it into 1 byte, 11110100 = -12. as byte range is between -128 to 128, so java wraps value during narrowing conversion to fit them into target data type range
long a = 100L;   L is important.......float f = 3.14f........till 7 decimal point
explicit :- write double, long -> int, float -> char, short -> byte, boolean
nextInt().....nextBigInteger()......nextFloat()

GARBAGE COLLECTIONS: Automatic process in Java that frees up m/m by reclaiming space occupied by object that are no longer in use by program, preventing memory leaks.
Memory Leaks: Occur when objects are unintentionally retained in memory, leading to gradual memory consumption and potential program crashes. eg:- when a collections(such as list or map) holds reference to object that are no longer needed, but these reference are not removed from the colection

RESOURCE LEAKS: Occur when resources like file handles or database connections are not properly released, leading to resource exhaustion. eg:- when file is opened for reading but not closed after reading is complete....here it consumes system resource unnecessarily....sc.close();
Garbage collection helps prevent memory leaks, but developers must also manage object references and release resources properly to avoid both memory and resource leaks in Java applications.

for(;;) is a standard way to create an infinite loop, as it has no initialization, condition, or update expressions. It simply means "repeat indefinitely".

STRING POOL :- Java maintains special area in java heap called the string pool where all string literals are stored. when we create a string using string literals, java checks the pool first. if the string already exist, it returns the reference to the same instance, helping to same memory

IMUTABLE STRING :- string in java are immutable, which means once a string object is created, its value cannot be changed. If u perform any operations that seems to modify a string, what actually happens is a new string object is created.

str.contains("Divyanshu")    str.startsWith("Div")    str.endsWith("Div")
String name = str.replace('o', 'a')        char[] ch = str.toCharArray()
String str = String.valueOf(23);  converts diff data type(int, long, float, double, boolean, char, charArray, object) into string representation
isEmpty() :- checks if string is empty(length is 0)
isBlank() :- checks if string is blank(empty or contains only white space characters)

EXCEPTION :- In java, Exception is an unexpected event, which occurs during the execution of a program i.e at runtime, that disrupts the normal flow of the program's instruction. Exception can be caught and handled by the program.
It occurs due to :- 1) Invalid user input  2) Device failure  3) Loss of network connections 4)Physical limitations 5)Code Errors 6)Opening an available files

RUNTIME EXCEPTIONS :- It happens due to programming errors aka unchecked exceptions
RuntimeException is the superclass of all classes that exceptions are thrown during the normal exception of Java VM(virtual machine). The Runtime Exception and its subclasses are unchecked exceptions. The most common exceptions are NullPointerException, ArrayIndexOfBoundExceptions, classCastExceptions, InvalidArgumentExceptionException etc.

JAVA IOException exceptions :- is a checked exceptions that must be handled at compilation time. IOException is the base class for such exceptions which are thrown while accessing data from files, directories and streams. It represent a class or exceptions that are thrown when an I/O error occurs

