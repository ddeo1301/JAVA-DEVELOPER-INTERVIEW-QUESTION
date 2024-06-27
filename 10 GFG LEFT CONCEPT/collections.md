- Collection :- represent unified architecture for storing and manipulating data....interface extends from iterable
- Collections :- utility class that provides methods that we can perform on the collection classes


ARRAYLIST
 - class uses dynamic array for storing elements while linkedlist uses doubly linked list to store the elements
 - no size limit, contain duplicate element, maintain insertion order, not synchronized, 
 - manipulation is little slower then linked list bcoz a lot of shifting neeeds to occur if any element is removed
 - cannot create an arraylist of primitive types such as int, float, char etc. Required to use wrapper class in such case


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
 - doesnot allow duplicate keys
 - HashMap and LinkedHashMap allow NULL keys and values but TreeMap doesnot allow any NULL key or value
 - HashMap doesnot maintain any order 
 - LinkedHashMap maintain order
 - TreeMap maintains ascending order


QUEUE(FIFO)
 - DEQUE
     - double ended queue
     - NULL elements are nt allowd, no capacity restriction, faster then linkedlist and stack
    
