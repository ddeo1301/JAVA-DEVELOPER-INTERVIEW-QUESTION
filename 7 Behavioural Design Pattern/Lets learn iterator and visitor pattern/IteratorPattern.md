Iterator Pattern is a behavioral design pattern that provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. This pattern is commonly used to traverse collections like lists, arrays, or other data structures.

COMPONENTS
 - Iterator: An interface for accessing and traversing elements.
 - Concrete Iterator: A class that implements the Iterator interface and is responsible for the actual traversal of the aggregate object.
 - Aggregate: An interface that defines a method to create an iterator.
 - Concrete Aggregate: A class that implements the Aggregate interface and returns an instance of the Concrete Iterator.


EXAMPLES
Let's create an example using a collection of names.

    1. Iterator Interface :- This interface defines the methods for traversing the collection. Iterator interface provides hasNext() and next() methods for traversal.
            public interface Iterator {
                boolean hasNext();
                Object next();
            }

    2. Concrete Iterator :- This class implements the Iterator interface and provides the mechanism to iterate over the collection. NameIterator class implements the Iterator interface and provides the actual implementation for hasNext() and next().
            public class NameIterator implements Iterator {
                private String[] names;
                private int index;

                public NameIterator(String[] names) {
                    this.names = names;
                    this.index = 0;
                }

                @Override
                public boolean hasNext() {
                    return index < names.length;
                }

                @Override
                public Object next() {
                    if (this.hasNext()) {
                        return names[index++];
                    }
                    return null;
                }
            }

    3. Aggregate Interface :- This interface defines a method to create an iterator. Container interface defines a method getIterator() that returns an Iterator.
            public interface Container {
                Iterator getIterator();
            }

    4. Concrete Aggregate :- This class implements the Container interface and returns an instance of the Concrete Iterator. NameRepository class implements the Container interface and provides the names collection. It returns a new NameIterator for the collection.
            public class NameRepository implements Container {
                private String[] names = {"John", "Jane", "Jack", "Jill"};

                @Override
                public Iterator getIterator() {
                    return new NameIterator(names);
                }
            }

    5. Client Code :- client code uses the Concrete Aggregate to get an iterator and traverse the collection. IteratorPatternDemo class demonstrates how to use the NameRepository to get an iterator and print all the names in the collection.
            public class IteratorPatternDemo {
                public static void main(String[] args) {
                    NameRepository nameRepository = new NameRepository();

                    for (Iterator iter = nameRepository.getIterator(); iter.hasNext(); ) {
                        String name = (String) iter.next();
                        System.out.println("Name: " + name);
                    }
                }
            }

This example illustrates the essence of the Iterator Pattern, allowing a client to traverse a collection without knowing its underlying structure, thereby promoting loose coupling and enhancing code maintainability.






