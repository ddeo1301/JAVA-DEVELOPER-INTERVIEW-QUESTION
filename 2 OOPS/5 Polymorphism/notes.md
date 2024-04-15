POLYMORPHISM :- MANY FORMS
   - The ability of a single fn or operator to work in diff ways based on the objects it is acting upon or actual need.
   - A phenomenon that allows an object to have several diff forms and behaviours
   - TYPES :- 
        1) Compile Time polymorphism / Static Polymorphism
            1) Method overloading :-
                  Overloading occurs when a class contains multiple methods sharing a name but differing in argument count or argument type

                   public class Calculator {
                        int add(int a, int b){
                            return a + b;
                        }
                        // overloading add, 3 int addition
                        int add(int a, int b, int c){
                            return a + b + c;
                        }
                        double add(int a, int b, int c, double d){
                            return a + b + c + d;
                        }
                    }

            2) operator overloading :-
                 Java doesnot support user defined operator overloading but internally overloas certain operator(e.g :- + for string concatenation and integer addition).
                 eg :- 1) int, int  2) int, double  3) str1 , str2
                 + operator in java in polymorphic but we cannot overload it by ourself it is done whatever java has given 


        2) Run Time polymorphism / Dynamic Polymorphism
              1)  Function overloading :-
                      A subclass can provide a specific implementation of a method that is already defined in its superclass
               2) Dynamic Method Dispatch[Upcasting] :- A superclass references variable can refer to a subclass object and dynamic dispatch is used to resolve the called method at runtime

