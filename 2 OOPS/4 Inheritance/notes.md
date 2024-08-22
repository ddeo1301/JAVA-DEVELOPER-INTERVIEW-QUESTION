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
  5) Multiple Inheritance:- Java dont support inorder to prevent DIAMOND PROBLEM as to avoid complexity and ambiguity arise
     from it ....which method should D inherit

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
                        
                        // Drived class
                        public class Main {
                            public static void main(String[] args)
                            {
                                Child c = new Child();
                                c.print_geek();
                                c.print_for();
                                c.print_geek();
                            }
                        }



IMPLEMENTING INHERITANCE IN JAVA
  - Unlike C++, Java doesnot provide an inheritance specifier like public, protected or private i.e we cannot specify mode of inheritance
    
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

Animal an = new Cat();
 - object is cat but reference is animal and whatever cat class inherited from animal that only we can access and 
 animal class wla fn will be only called

Cat c3 = (Cat) animal;
 - again converting it in reference variable of cat so cat wla reference hga

- variable hiding :- child clas variables hides the parent class variable

- By default all the class  extends object class    Car1.equals(Car2);
- @Override is allowed only in overridden but it is nt compulsary

- Ref Variable :- Parent          Object :- Child
   - for instance member(for fields/variables) --- Reference variable
   - function overriding  ---- Child Object

                    class Animal {
                        public void makeSound() {
                            System.out.println("The animal makes a sound");
                        }
                    }
                    
                    class Cat extends Animal {
                        @Override
                        public void makeSound() {
                            System.out.println("The cat meows");
                        }
                    
                        public void scratch() {
                            System.out.println("The cat scratches");
                        }
                    }
                    
                    class Dog extends Animal {
                        @Override
                        public void makeSound() {
                            System.out.println("The dog barks");
                        }
                    }
                    
                    public class Main {
                        public static void main(String[] args) {
                            // This is legal: Upcasting
                            Animal animal = new Cat(); // Cat is an Animal
                            animal.makeSound(); // Output: The cat meows
                    
                            // This is illegal and will not compile
                            // Cat an = new Animal(); // Uncommenting this line will cause a compile-time error
                    
                            // Correct way to downcast
                            if (animal instanceof Cat) {
                                Cat cat = (Cat) animal; // Safe downcast
                                cat.scratch(); // Output: The cat scratches
                            } else {
                                System.out.println("The animal is not a Cat.");
                            }
                    
                            // Example of unsafe downcasting
                            Animal anotherAnimal = new Dog();
                            // Cat anotherCat = (Cat) anotherAnimal; // This would throw a ClassCastException at runtime
                    
                            // Checking the type before downcasting
                            if (anotherAnimal instanceof Cat) {
                                Cat anotherCat = (Cat) anotherAnimal; // Safe downcast
                                anotherCat.scratch();
                            } else {
                                System.out.println("anotherAnimal is not an instance of Cat.");
                            }
                        }
                    }


ASSOCIATION(gfg notes)
