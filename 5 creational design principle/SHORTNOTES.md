 1) Singleton Pattern:
     - Intent: Ensure a class has only one instance and provide a global point of access to it.
     - Key Components: Private constructor, getInstance() method, static instance variable.
     - Example: Database connection pool.

 2) Builder Pattern:
     - Intent: Separate the construction of a complex object from its representation.
     - Key Components: Director, Builder, ConcreteBuilder, Product.
     - Example: StringBuilder in Java.

3)  Factory Method Pattern:
    - Intent: Define an interface for creating an object, but let subclasses decide which class to instantiate.
    - Key Components: Creator, ConcreteCreator, Product.
    - Example: Calendar.getInstance() method.

4) Abstract Factory Pattern:
    - Intent: Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
    - Key Components: AbstractFactory, ConcreteFactory, AbstractProduct, ConcreteProduct.
    - Example: GUIFactory producing different UI components.

 5) Prototype Pattern:
    - Intent: Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.
    - Key Components: Prototype, ConcretePrototype, Client.
    - Example: Cloning objects in Java.
    
 Remember, each pattern has its own use cases and trade-offs, so choose the one 
that best fits your design needs