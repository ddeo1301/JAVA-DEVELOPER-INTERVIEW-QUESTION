ABSTRACTION IN JAVA :-
   1) Delivering only essentials information to the outer world while masking the background details.
   2) It is a design and programming method that seperates the interface from the implementation
   3) eg:-
        - various functionalities of Airpods but dont know the actual implementation/ Working
        - To drive a car, one only needs to know the driving process and not the mechanics of the car engine


ABSTRACTION IN COLLECTIONS :- 
  sort() , for eg is used to sort an array, a list, or a collection of items, and we know that if we give a container to sort, it will sort it, but we dont know which sorting algorithm it uses to sort that container 


ABSTRACTION USING CLASSES :- 
  1) Grouping data members and member fn into classes using access specifiers
  2) A class can choose which data members are visible to the outside world and which are hidden


WHAT IS ABSTRACT CLASS
 1) An abstract class in java is a class that cannot be instantiated on its own and is designed to be subclassed. It can serve as a superclass for other classes that share a common structure or behaviour
 2) An abstract class in Java delivers abstraction by serving as a template for its subclasses, allowing for the defination of a common interface without specifying the complete implementation details.
 3) It has come from the idea of Abstraction


DESIGN STATEGY
 1) Abstraction divides code into two categories :- interface and implementation
     So, when creating ur componennt, keep the interface seperate from the implementation so that if the underlying implementation changes, the interface stays the same.
  2) In this instance, any program that ues these interfaces would remain unaffected and would require recompilation with the most recent implementation
  3) Makes  code modular and maintainable


ADVANTAGES OF ABSTRACTION
 1) Reduces Complexity
 2) Increase Security
 3) Increase Reusablity
 4) AVoid Code Duplication
 5) Loose Coupling 


In abstraction we seperate interface from implementation so that if we want to add new implementation
we can use interface