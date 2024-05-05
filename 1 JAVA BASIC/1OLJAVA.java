Q1 - explain oops concept and how do we acheive / implement each oops concept using java

OBJECT :- are instance of classs that has state and behaviour 
CLASS :- are blueprint from which we can create individual objects. Class doesn't consume any space

      public class Main{
          int x = 5;
          public static void main(String[] args){
              Main obj = new Main();
              System.out.println(obj.x);  // modify attribute value
          }
      }

PILLARS OF OOPS
1) INHERITANCE :- when one object acquires all the properties and behaviours of parent object. provides code reusablity
   1) Single Inheritamce :- subclasses inherit the features of one superclass. 
   2) Multilevel Inheritance :-  , a derived class will be inheriting a base class, and as well as the derived class also acts as the base class for other classes.
   3) Hierarchical Inheritance :- one class serves as a superclass (base class) for more than one subclass.
   4) Multiple Inheritance (Through Interfaces) :- one class can have more than one superclass and inherit features from all parent classes. Please note that Java does not support multiple inheritances with classes. In Java, we can achieve multiple inheritances only through Interfaces.

11) why and when to use interface
  - To achieve security - hide certain details and only show the important details of an object 
   (interface).
  - we cannot declare an interface directly as a variable type, but you can use interfaces as reference 
     types for variables

      interface One {
          public void print_geek();
      }
      interface Two {
          public void print_for();
      }
      interface Three extends One, Two {
          public void print_geek();
      }
      class Child implements Three {
          @Override public void print_geek()
          {
              System.out.println("Geeks");
          }
      
          public void print_for() { System.out.println("for"); }
      }
      public class Main {
          public static void main(String[] args)
          {
              Child c = new Child();
              c.print_geek();
              c.print_for();
              c.print_geek();
          }
      }

1) interfaces cannot be used to create objects
2) Interface methods do not have a body - the body is provided by the "implement" class
3) On implementation of an interface, you must override all of its methods
4) Interface methods are by default abstract and public
5) Interface attributes are by default public, static and final
6) An interface cannot contain a constructor (as it cannot be used to create objects), cannot inherit classes

5) Hybrid Inheritance :- Java doesnot support hybrid inheritance


      class Employee{               // Base or super class
          int salary = 1000000;
      }
      class Engineer extends Employee{  // Inherited or sub class
          int benefits = 10000;
      }
      class Details{                        // Driver Class
          public static void main(String[] args){
            Engineer E1 = new Engineer();
              System.out.println("Salary : " + E1.salary
                                + "\nBenefits : " + E1.benefits);
          }
      }



2) ABSTRACTION -  process of hiding the implementation details and showing only the essential features of the object. Abstract classes and interfaces are used to achieve abstraction in Java.

abstract keyword is a non-access modifier, used for classes and methods:
Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).
An abstract class can have both abstract and regular methods:

      // Abstract class
      abstract class Animal {
        // Abstract method (does not have a body)
        public abstract void animalSound();
        // Regular method
        public void sleep() {
          System.out.println("Zzz");
        }
      }
      // Subclass (inherit from Animal)
      class Pig extends Animal {
        public void animalSound() {
          // The body of animalSound() is provided here
          System.out.println("The pig says: wee wee");
        }
      }
      class Main {
        public static void main(String[] args) {
          Pig myPig = new Pig(); // Create a Pig object
          myPig.animalSound();
          myPig.sleep();
        }
      }

      Implementation in Java (Abstract Class):
      abstract class Shape {
          abstract void draw();
      }
      class Circle extends Shape {
          void draw() {
              System.out.println("Drawing Circle");
          }
      }

      Implementation in Java (Interface):
      interface Drawable {
          void draw();
      }
      class Circle implements Drawable {
          public void draw() {
              System.out.println("Drawing Circle");
          }
      }





3) ENCAPSULATION :- Binding (or wrapping) code and data together into a single unit are known as encapsulation.

public class Person {
  private String name; // private = restricted access
  // Getter :- get method returns the value of the variable name.
  public String getName() {
    return name;
  }
  // Setter :- set method takes a parameter (newName) and assigns it to the name variable. The this 
//             keyword is used to refer to the current object.
  public void setName(String newName) {
    this.name = newName;
  }
}
public class Main {
  public static void main(String[] args) {
    Person myObj = new Person();
    myObj.name = "John";
    System.out.println(myObj.name);   //  error: name has private access in Person
    // Instead, we use the getName() and setName() methods to access and update the variable:
    myObj.setName("John"); // Set the value of the name variable to "John"
    System.out.println(myObj.getName()); // "JOHN"
  }
}



4) POLYMORPHISM :- If one task is performed in different ways, it is known as polymorphism. 

// Implementation in Java (Method Overriding OR runtime polymorphism):
public class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

// Implementation in Java (Method Overloading or compile-time polymorphism):
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
}
 
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // Create a Animal object
    Animal myPig = new Pig();  // Create a Pig object
    Animal myDog = new Dog();  // Create a Dog object
    myAnimal.animalSound();    // The animal makes a sound
    myPig.animalSound();       // The pig says: wee wee
    myDog.animalSound();       // The dog says: bow wow

    Pig myPig = new Animal();  // error: incompatible types: Animal cannot be converted to Pig
    Pig myPig = new Dog();     // error: incompatible types: Dog cannot be converted to Pig
  }
}




Q2 - Explain static keyword and how does the execution of static block/variable/method
 
 static keyword is used for a constant variable or a method that is the same for every instance of a class. This means that static members are shared among all instances of the class, and they can be accessed without creating objects.

STATIC BLOCK
  - Static blocks are used to initialize static variables.
  - They are executed only once when the class is loaded into the memory by the JVM.
  - Static blocks are executed in the order they appear in the class, from top to bottom.

  public class Example {
    static {
        System.out.println("Static block");
    }
}

STATIC VARIABLE
  - Static variables (also known as class variables) are shared among all instances of the class.
  - They are initialized only once, at the start of the program's execution, and retain their values 
     until the program terminates.

     public class Example {
        static int count = 0; // static variable
     }

STATIC METHOD
  - No, in Java, you cannot override static methods. 
  - Static methods belong to the class rather than any specific instance of the class.
  - They can be called directly using the class name without creating an instance of the class.
  - Static methods cannot access instance variables directly, as they are not associated with any 
     instance of the class.

    public class Example {
      static void display() { // static method
        System.out.println("Static method");
     }
  }
 