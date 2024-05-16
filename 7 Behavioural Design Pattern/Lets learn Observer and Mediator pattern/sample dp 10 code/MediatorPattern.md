 Mediator Pattern is a behavioral design pattern that promotes loose coupling by preventing objects from referring to each other explicitly. It accomplishes this by introducing a mediator object that handles all the communication between different components, making the system more maintainable and flexible.


EXPLANATION
 - Purpose: The Mediator Pattern aims to reduce the complexity of communication between multiple objects or classes. Instead of having objects communicate directly, they communicate through a mediator. This ensures that objects are not tightly coupled and can be modified independently.


COMPONENTS
 - Mediator Interface: Declares methods for communication between colleague objects.
 - Concrete Mediator: Implements the mediator interface and coordinates communication between colleague objects.
 - Colleague Classes: Represent the objects that communicate with each other. They interact with the mediator instead of directly with each other.


EXAMPLE
Imagine a chat room where users (colleagues) send messages to each other. Instead of each user sending messages directly to another user, they send messages through a chat room (mediator).
Let's implement a simple chat room application using the Mediator Pattern in Java.

    Mediator Interface :- Defines the methods for adding users and sending messages.
            public interface ChatMediator {
                void sendMessage(String message, User user);
                void addUser(User user);
            }

    Concrete Mediator :-  Implements the mediator interface. It maintains a list of users and handles message broadcasting.
            import java.util.ArrayList;
            import java.util.List;

            public class ChatMediatorImpl implements ChatMediator {
                private List<User> users;

                public ChatMediatorImpl() {
                    this.users = new ArrayList<>();
                }

                @Override
                public void addUser(User user) {
                    this.users.add(user);
                }

                @Override
                public void sendMessage(String message, User user) {
                    for (User u : this.users) {
                        // Don't send the message to the sender
                        if (u != user) {
                            u.receive(message);
                        }
                    }
                }
            }

    Colleague Class :- Provides a blueprint for user objects with methods for sending and receiving messages.
            public abstract class User {
                protected ChatMediator mediator;
                protected String name;

                public User(ChatMediator mediator, String name) {
                    this.mediator = mediator;
                    this.name = name;
                }

                public abstract void send(String message);
                public abstract void receive(String message);
            }

    Concrete Colleague Classes :- Implements the User class. When a user sends a message, it goes through the mediator, which then broadcasts it to all other users.
            public class UserImpl extends User {

                public UserImpl(ChatMediator mediator, String name) {
                    super(mediator, name);
                }

                @Override
                public void send(String message) {
                    System.out.println(this.name + " sends: " + message);
                    mediator.sendMessage(message, this);
                }

                @Override
                public void receive(String message) {
                    System.out.println(this.name + " receives: " + message);
                }
            }

    Client Code :- Creates the mediator and users, adds users to the mediator, and demonstrates sending a message.
            public class MediatorPatternDemo {
                public static void main(String[] args) {
                    ChatMediator mediator = new ChatMediatorImpl();
                    
                    User user1 = new UserImpl(mediator, "Alice");
                    User user2 = new UserImpl(mediator, "Bob");
                    User user3 = new UserImpl(mediator, "Charlie");
                    User user4 = new UserImpl(mediator, "Dave");

                    mediator.addUser(user1);
                    mediator.addUser(user2);
                    mediator.addUser(user3);
                    mediator.addUser(user4);

                    user1.send("Hello, everyone!");
                }
            }


BENEFITS :- 
 - Decoupling: Objects are not tightly coupled, making the system more flexible and easier to maintain.
 - Simplified Communication: The mediator centralizes communication logic, reducing the complexity of interaction patterns.

DRAWBACKS :
 - Mediator Complexity: The mediator can become complex if it handles too many interactions, potentially becoming a bottleneck.

- The Mediator Pattern is a powerful way to manage complex communications and dependencies between objects, enhancing maintainability and scalability in software design.






