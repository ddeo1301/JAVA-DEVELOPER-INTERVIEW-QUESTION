STATIC KEYWORD

    - used for m/m management. 
    - m/m space are allocated only once during execution of the program in static variable and methods and m/m space is 
       shared among all instances of class....eg :- declare static block and it will be executed only once
    - static members can be accessed without creating instance of the class(i.e new keyword)....
    - static members are associated with the class not with individual object i.e change in static members will be reflected
       in all instances of the class and we can access static members using the class name rather then object reference.
    - static methods and variables cannot access non static members of the class, as they are not associated with any 
        particular instance of the class
    - static methods can be overloaded i.e we can define multiple methods with same name but diff parameters but cannot
       override as they are associated with the class rather than with particular instance of the class

- STATIC LOCAL VARIABLES ARE NOT ALLOWED bcoz when a variable is declared static , then a single copy of variable is created
    and shared among all objects at the class level
- static block and variable are executed in the order they are present in a program

STATIC METHODS RESTRICTION :-
   - They can only directly call other static methods
   - They can only directly access static data
   - cannot refer to THIS or SUPER in any way
   - cannot make static reference to non static fields or methods

- use static variable :- that is common to all object. eg:- class student cllg name will be same
- use static methods :- for changing static variables

- A class can be made static only if it is nested class and we cannot make top level class with static modifier . 
- Nested static class doesnot need a reference of outer class. In this case, a static class cannot access non static member of outer class




FINAL KEYWORD

  - used as an non access modifier applicable to variable, method or class which is used to restrict a user in Java and it
     cannot be modified or extended
  - Final variable -> To create constant variable. its value cannot be changed once assigned . we must initialize final variable else the compiler will throw compile time error
  - Final Methods -> Prevent Method Overloading. cannot be overridden by a subclass i.e it cannot be inherited by a subclass
  - Final Classes -> prevent Inheritances . eg :- Wrapper class like Integer, Float etc. cannot be extended by subclass

  - must be initialized either at the time of declaration or in the constructor of the class
  - when a final variable is created inside a method/constructor/block, it is called local final variable, and it must initialize once where it is created
      
                  int [] arr = {1, 2, 3};
                  for(final int i : arr)  System.out.println(i + " ");  // 1 2 3
                
 - Since "i" variable goes out of scope with each iteration of the loop, it is redeclared each iteration, allowing the same
    token (i) to be used to represent multiple variables

- FINAL KEYWORD is used to declare variables, methods or classes as unmodifiable
- STATIC KEYWORD is used to declare class member(variables and methods) that belongs to class itself not individual objects


THIS KEYWORD

 - Using this keyword to refers to current class instance variables (this.name = name in parametrised constructor)
 - Using this() to invoke the current class constructor (mainly constructor default mein i.e test(10. 20))
 - Using this keyword to return the current class instance ( Test get(){return this;}    obj.get().display)
 - Using this keyword  as method parameter
   
                  void display(Test obj) {....}
                  void get() {display(this);}
                  obj.get();
               
 - Using this keyword to invoke the current class method
 - 
                   void display(){this.show();}
                   void show(....)    1st show wla fn execute then display wla execute hga
               
 - Using this keyword as an argument in the constructor call
  - helps in distinguish b/w instance and local variable with same name
  - overuse of this can make code harder to read and understand
  - using this in static context results in compile time error
   
 


 SUPER KEYWORD

- use to refer parent class when we are working with objects
- super() is used to call a superclass constructor, method, field
- super must be the first statement in a derived class constructor
- super cannot be used in static context such as static method or static variable initializer

- super with variables ... super.speed() then parent class wla call hga 
- super with methods ..... super.message() then parent method will be called
- super with constructor .... super() 
