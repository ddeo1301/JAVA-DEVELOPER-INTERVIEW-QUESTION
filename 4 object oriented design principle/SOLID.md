SINGLE RESPONSIBLITY PRINCIPLE
    - The SRP states that a class should have only one reason to change. It should have a single responsibility. 
            public class DataCreator {
                public void createData() {
                    // Create data
                }
            }

            public class DataParser {
                public void parseData() {
                    // Parse data
                }
            }

            public class DataSaver {
                public void saveData() {
                    // Save data
                }
            }



OPEN-CLOSED PRINCIPLE
   - The OCP states that classes should be open for extension but closed for modification. 
            public interface PaymentMethod {
                void pay(double amount);
            }

            public class DebitCardPayment implements PaymentMethod {
                public void pay(double amount) {
                    // Process debit card payment
                }
            }

            public class CreditCardPayment implements PaymentMethod {
                public void pay(double amount) {
                    // Process credit card payment
                }
            }

            public class UPIPayment implements PaymentMethod {
                public void pay(double amount) {
                    // Process UPI payment
                }
            }

            public class PaymentManager {
                public void processPayment(PaymentMethod paymentMethod, double amount) {
                    paymentMethod.pay(amount);
                }
            }



LISKOV SUBSTITUTION PRINCIPLE
  - LSP states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
            public interface Polygon {
                double area();
            }

            public class Rectangle implements Polygon {
                protected double width;
                protected double height;
                
                public double area() {
                    return width * height;
                }
            }

            public class Square implements Polygon {
                private double side;
                
                public Square(double side) {
                    this.side = side;
                }
                
                public double area() {
                    return side * side;
                }
            }


INTERFACE SEGREGATION PRINCIPLE
  -  ISP states that clients should not be forced to depend on interfaces they do not use. 
            public interface Feedable {
                void eat();
            }

            public interface Workable {
                void work();
            }

            public class Human implements Feedable, Workable {
                public void eat() {
                    // Eat
                }
                
                public void work() {
                    // Work
                }
            }

            public class Robot implements Workable {
                public void work() {
                    // Work
                }
            }



DEPENDENCY INVERSION PRINCIPLE
 -  DIP states that high-level modules should not depend on low-level modules, but both should depend on abstractions. 
            public interface PaymentMethod {
                void pay(double amount);
            }

            public class DebitCardPayment implements PaymentMethod {
                public void pay(double amount) {
                    // Process debit card payment
                }
            }

            public class PaymentManager {
                public void processPayment(PaymentMethod paymentMethod, double amount) {
                    paymentMethod.pay(amount);
                }
            }