INHERITANCE
  - Child inherits attributes and behaviour from Parent and is a way to create class from existing class
  - The Derived/Child/Sub class inherits some attributes and behaviours from Base/Parent/Super Class, and may have more specialised attributes and behaviours
  - Inheritance is used where objects exhibits a hierarchical relationship, signifying a specialized - generalised connections
  - Use inheritance whenever an IS-A relationship is identified between objects.

TYPES OF INHERITANCE:
  1) Single Inheritance
  2) Multilevel Inheritance
  3) Hierarical Inheritance
  4) Hybrid Inheritance
  5) Multiple Inheritance


IMPLEMENTING INHERITANCE IN JAVA
  - Unlike C++, Java doesnot provide an inheritance specifier like public, protected or private i.e we cannot specify mode of inheritance
  - Java doesnot support multiple inheritance

    class SuperClass{
       // SuperClass fields and methods
    }
    class SubClass extends SuperClass{
      // SUbclass fields and methods, it includes those inherited from SuperClass
    }


SUPER KEYWORD
  1) Refer to the instance if immediate parent
  2) Invokes actor of immediate parent
  3) Invokes a method of immediate parent  ->   super.startEngine()
  4) super() must be 1st statement in constructor body


ADVANTAGES :- 
  1) Reusability :- Avoids duplicating methods in child classes that already exist in parent classes
  2) Code modification :- Localises changes, preventing inconsistencies throughout the program.
  3) Extensibility :- Allow easy enhancement or upgrade of specific parts of a product without core attributes
  4) Data hiding :- Supports encapsulation by keeping some data private in the base class, preventing alteration by derived classes


PROTECTED MEMBERS :-
1) Members declared protected are accessible within class itself and its derived class
2) Protected access modifier serves two primary purposes :-
    1) ENCAPSULATION :-
         - like private modifier, protected provides a level of encapsulation, ensuring that certain class members are not directly accessible from outside the class which promotes data hiding and prevents external code from modifying or accessing sensitive data directly

    2) INHERITANCE :-
         - Unlike private, protected members can be inherited by derived clsses. This means that subclasses have limited access to these members, aalowing them to build upon the base class functionality while maintaining some level of data integrity and control




class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor called");
    }
}

class Car extends Vehicle {
    Car() {
        System.out.println("Car constructor called");
    }
}

class Maruti extends Car {
    Maruti() {
        System.out.println("Maruti constructor called");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        // Output: Vehicle constructor called

        System.out.println();

        Car c1 = new Car();
        // Output:
        // Vehicle constructor called
        // Car constructor called

        System.out.println();

        Maruti m1 = new Maruti();
        // Output:
        // Vehicle constructor called
        // Car constructor called
        // Maruti constructor called
    }
}

Explanation:

1) When you create an instance of Vehicle, only the Vehicle constructor is called because it's the only class in its hierarchy.
2) When you create an instance of Car, first the Vehicle constructor is called (since Car extends Vehicle), then the Car constructor is called.
3) Similarly, when you create an instance of Maruti, the constructor chain starts from Vehicle, then Car, and finally Maruti. So, the constructors of all three classes are called in sequence.