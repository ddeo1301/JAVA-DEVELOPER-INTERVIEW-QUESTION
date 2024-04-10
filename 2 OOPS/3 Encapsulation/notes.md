DEFINATION
   Encapsulation binds data and methods in a class. Like a capsule, it combines and binds them together.
   As we are hiding data from outer classes or world, ENCAPSULATION is also known as DATA HIDING

The goal is to implement classes in a way that prevents unauthorized access to or modification of the original contents of a class by its instances(or objects).  The underlying algorithms of one class need not be known to another class.  The two classes can still communicate through.

FUNCTION OF ENCAPSULATION
   1) Provides a secure layer
   2) Hides internal implementation of code and data in a class
   3) Exposes only necessary imformation to the external world



ACCESS MODIFIER
  1) way to define access to the data and methods of a class
  2) PUBLIC
       -  Members declared as public are accessible from any part of the program.
       -  They can be accessed by objects of the class and external code
  3) PRIVATE
       -  are accessible only within the same class
       -  They are not accessible from outside the class, including derived classes
  4) PROTECTED
       -  are accessible within the same class and by derived classes
       -  they are not directly accessible from external code



PERFECT ENCAPSULATION
   1) If all data members/variables are private
   2) Handling Access to Encapsulated Data
        -  Despite encapsulation, external interaction is necessary.
        -  Implementation of public methods, such as getters and setters, allows external communication.
        -  These methods enable controlled access to the encapsulated data.