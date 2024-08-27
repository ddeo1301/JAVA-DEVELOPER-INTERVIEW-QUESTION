 - al.stream().filter(...).forEach(System.out::println)
 - List<Integer> al = new ArrayList<>(Arrays.asList(5, 10, 15, 20));

Advantage of stream()
  - No storage
  - pipeline of function
  - can be infinite
  - can be parallelized mainly collection
  - can be created from collections, arrays, methods in stream



LAMBDA  FUNCTION
  - Function Iterface :- which has only 1 abstract class

                     interface Test{
                           void print();
                       }

  - In Lambda fn we dont need to specify data type
  - parameter and return type is automatically inserted by lambda expression

NO PARAMETER

            () -> System.out.println("Hello WOrld");

            interface Test1 {
                void print();
            }

            class GfG {
                // functional interface parameter is passed
                static void fun(Test1 t) { 
                    t.print(); 
                }

                public static void main(String[] args)
                {
                    // lambda expression is passed without parameter to functional interface t
                    fun(() -> System.out.println("Hello"));  // Hello
                }
            }


SINGLE PARAMETER

            p -> System.out.println(p);

            // functional interface with one parameter of Integer type
            interface Test2 {
                // The void type and the Integer type is automatically inferred from here and assigned to the lambda expression
                void print(Integer p);
            }

            class GfG {
                // takes lambda expression and a variable of Integer type as arguments
                static void fun(Test2 t, Integer p)
                {
                    // calls the print function
                    t.print(p);
                }
                public static void main(String[] args)
                {
                    // lambda expression is passed with a single parameter lambda expression is mapped to the single argument abstract function in the functional interface Test2
                    
                    fun(p -> System.out.println(p), 10);
                }
            }


MULTI PARAMETER

                (p1, p2) -> System.out.println(p1 + " " + p2);

                // functional interface Test3 with 2 parameter of Integer type
                interface Test3 {
                    // The void type and the Integer type is automatically inferred from here and assigned to the lambda expression
                    void print(Integer p1, Integer p2);
                }

                class GfG {
                    // takes parameter of Test3 type followed by 2 integer parameters p1 and p2
                    static void fun(Test3 t, Integer p1, Integer p2)
                    {
                        // calls the print function
                        t.print(p1, p2);
                    }
                    public static void main(String[] args)
                    {
                        // lambda expression is passed with two parameters lambda expression is mapped to the double argument abstract function in the functional interface Test3
                        fun((p1, p2) -> System.out.println(p1 + " " + p2), 10, 20);   // 10  20
                    }
                }


         al.forEach(x -> System.out.println(x))
         al.forEach(System.out::println)    :: method reference both static and method reference
         al.forEach(GFG(class) :: printSquare(uska method hai))
      


STREAM APPLICATION

  int m = Arrays.stream(arr).getAsDouble().max().getAsInt()

 - Max, Min and Avg return an optional class as a return value because if our streams are empty and there are no element then these fn are going to return null. so as signing NULL to integer is not a good idea
 - optional class is for non primitive type
 - comparator interface has non primitive
 
          Stream.iterate(1, x-> x+1)                          iterate takes initial value here as 1
                 .filter(x -> x.toString().contains("5"))      output :- 5  15  25  35  45  50  51  52  53  54
                 .limit(10)
                 .forEach(System.out::println);
        

 - Begine with 'a' and ends with 'c' in lexicographical order

                  Arrays.stream(arr).filter(x -> x.startsWith("a")).filter(x -> x.endsWith("c"))
                      .sorted().forEach(System.out::println)

collect method is used to collect stream data somewhere


REDUCE 
   - allows you to transform a stream of elements into a single result.
     
               int sum = numbers.stream()
                                    .reduce(0, (a, b) -> a + b);  // STARTING INITIAL VALUE IS 0
               String concatenated = words.stream()
                                              .reduce("", (a, b) -> a + " " + b);
                Optional<Integer> max = numbers.stream()
                                                  .reduce((a, b) -> a > b ? a : b);  
               // no initial value provided, the result is wrapped in an Optional.


STREAM APPLICATION
 - Readable, short and efficient code
 - Works great with Lambda expression and method references
 - can be parallelrized



JAVA COLLECTIONS FRAMEWORK
 
IMPLEMENTATION OF DATA STRUCTURE

                List    :     ArrayList, Linkedlist, Vector, Stack
                Set     :     HashSet, TreeSet, LinkedHashSet
                Queue   :     LinkedList, ArrayDeque, PriorityQueue
                Deque   :     LinkedList, ArrayDeque
                Map     :     HashMap, TreeMap, LinkedHashMap

Collections Class(Implementation of Basic Algorithm)

                binarySearch(), sort(), max(), min(), reverse(), fill()



SINGLE STREAM
 - Serial streams use a single thread to process the pipeline of operations.
 - They execute operations one after the other in a sequential manner.
 - serial streams are suitable for small datasets or when the order of execution is important

            List<String> words = Arrays.asList("apple", "banana", "cherry");
            words.stream()
                .filter(word -> word.length() > 5)
                .forEach(System.out::println);


PARALLEL STREAM
 - Parallel streams leverage multiple threads to process the pipeline of operations concurrently.
 - They divide the stream into multiple substreams, process them in parallel, and combine the results.
 - parallel streams can provide performance benefits for large datasets with computationally intensive 
 operations on multi-core systems

                  words.parallelStream()
                      .filter(word -> word.length() > 5)
                      .forEach(System.out::println);
