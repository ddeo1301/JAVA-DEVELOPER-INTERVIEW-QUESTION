- Collection :- represent unified architecture for storing and manipulating data....interface extends from iterable
- Collections :- utility class that provides methods that we can perform on the collection classes


ARRAYLIST
 - class uses dynamic array for storing elements while linkedlist uses doubly linked list to store the elements
 - no size limit, contain duplicate element, maintain insertion order, not synchronized, 
 - manipulation is little slower then linked list bcoz a lot of shifting neeeds to occur if any element is removed
 - cannot create an arraylist of primitive types such as int, float, char etc. Required to use wrapper class in such case

 ARRAYLIST AND VECTOR
  - ArrayList is not synchronised so faster then vector and vector is synchronised
  - ArrayList increments 50% of current array size if no. of elements exceeds from its capacity but Vector 100%
  - 


HASHSET
 - used to create a collection that uses a hashtable for storage by using mechanism Hashing
 - contains unique element, allows NULL value, not synchronised
 - doesnot maintain insertion order and inserted on the basis of their hashcode

 - LINKED HASHSET 
     - maintains insertion order but consumes extra m/m and CPU cycles

 - TREESET
     - maintains ascending order
     - implemented using binary search tree which is just like Red-Black Tree so operations such as search, remove, 
     add takes O(log(N)) time because its self balancing tree 
     - tree height never exceeds o(lon(N)) for all maintained operations so it is efficient Data Structure in order
     to keep large data that is sorted and do operations on it


MAP
 - doesnot allow duplicate keys, not synchronised
 - HashMap and LinkedHashMap allow 1 NULL keys and multiple values but TreeMap doesnot allow any NULL key but can
  have multiple NULL values
 - HashMap doesnot maintain any order 
 - LinkedHashMap maintain order
 - TreeMap maintains ascending order

- HASHTABLE ClASS
     - Hashtable is an array of list and each list is known as bucket. position of bucket is identified by calling 
     the Hashcode() method. Hashtables contains value based on keys
     - conatins unique elements and doesnot allow null key or value, is synchronized
     - slower then HashMap


HASHMAP
 - HASHING
     - process of converting an object into an integral values. Integral value helps in indexing and faster searches
 - HashMap contains array of nodes and the node is represented as a class
  
 - equals()
     - checks the equality of 2 objects. compares the key whether they r equal or nt. method of Object class
     - can be overridden. If we override equals() method then it is mandatory to override the hashCode() method
 - hashCode()
     - method of Object class which returns the m/m reference of the object in integer form. 
     - value received from the method is called bucket number which is address of the element inside the map. 
     - HashCode of null value is 0
 - Buckets
     - Array of node is called buckets. Each node has data structure like linkedList.
     - More then 1 node can share same bucket . It may be diffrent in capacity

 - CALCULATING INDEX :- 
     - put() method to insert key, value pair in HashMap. Default size of HashMap is 16(0 to 15)
     - Index = hashCode(key) & (n-1) where n is size of the array
     - If Index of 2 keys are same, equals() method check that both Keys are equal or not. If Keys are same, 
     replace the value with the current value. Otherwise, connect this node object to the existing node object
      through the LinkedList. Hence both Keys will be stored at same index .
     
     - get() method is used to get the value by its key, when it is called it calculates the hashCode of the key
     - After generating hashCode, it calculates the index value and search for the index value
     - It comapres the 1st element key. If both keys are equal, then it return the value else check for the next 
     element in the node if it exists or nt

 
 - Comparable Interface
     - It provides a single sorting sequence i.e we can sort the elements on the basis of single data member only.
     - eg:- rollNo, Name

 - Comparator Interface
     - contains 2 methods compare(Object obj1, Object obj2) and equals(Object element)
     - It provides multiple sorting sequence i.e we can sort the element on the basis of any data member


QUEUE(FIFO)
 - DEQUE
     - double ended queue
     - NULL elements are nt allowd, no capacity restriction, faster then linkedlist and stack
    

