 Visitor pattern is a behavioral design pattern that allows you to separate algorithms from the objects on which they operate. By using the Visitor pattern, you can add new operations to existing object structures without modifying those structures.

KEY CONCEPTS
 - Visitor Interface: Declares a visit operation for each type of element.
 - Concrete Visitor: Implements the operations declared in the Visitor interface.
 - Element Interface: Declares an accept method that takes a visitor as an argument.
 - Concrete Element: Implements the accept method to call the appropriate visit method on the visitor object.
 - Client: The client code, which uses the Visitor pattern, typically creates the visitors and makes the elements accept them.


EXAMPLES
Suppose we have a simple structure representing different types of shapes. We want to be able to perform different operations on these shapes (e.g., calculating area, drawing, exporting to XML) without changing the shape classes.

    Step 1: Define the Visitor Interface :- ShapeVisitor declares methods to visit different types of shapes.
            interface ShapeVisitor {
                void visit(Circle circle);
                void visit(Rectangle rectangle);
                void visit(Triangle triangle);
            }

    Step 2: Define the Element Interface :- Shape declares the accept method, which takes a ShapeVisitor.
            interface Shape {
                void accept(ShapeVisitor visitor);
            }

    Step 3: Implement Concrete Elements :- Circle, Rectangle, and Triangle implement Shape and define the accept method.
            class Circle implements Shape {
                private double radius;

                public Circle(double radius) {
                    this.radius = radius;
                }

                public double getRadius() {
                    return radius;
                }

                @Override
                public void accept(ShapeVisitor visitor) {
                    visitor.visit(this);
                }
            }

            class Rectangle implements Shape {
                private double width;
                private double height;

                public Rectangle(double width, double height) {
                    this.width = width;
                    this.height = height;
                }

                public double getWidth() {
                    return width;
                }

                public double getHeight() {
                    return height;
                }

                @Override
                public void accept(ShapeVisitor visitor) {
                    visitor.visit(this);
                }
            }

            class Triangle implements Shape {
                private double base;
                private double height;

                public Triangle(double base, double height) {
                    this.base = base;
                    this.height = height;
                }

                public double getBase() {
                    return base;
                }

                public double getHeight() {
                    return height;
                }

                @Override
                public void accept(ShapeVisitor visitor) {
                    visitor.visit(this);
                }
            }

    Step 4: Implement Concrete Visitors :- AreaCalculator and ShapeDrawer implement ShapeVisitor and provide specific implementations for each shape.
            class AreaCalculator implements ShapeVisitor {

                @Override
                public void visit(Circle circle) {
                    double area = Math.PI * Math.pow(circle.getRadius(), 2);
                    System.out.println("Area of Circle: " + area);
                }

                @Override
                public void visit(Rectangle rectangle) {
                    double area = rectangle.getWidth() * rectangle.getHeight();
                    System.out.println("Area of Rectangle: " + area);
                }

                @Override
                public void visit(Triangle triangle) {
                    double area = 0.5 * triangle.getBase() * triangle.getHeight();
                    System.out.println("Area of Triangle: " + area);
                }
            }

            class ShapeDrawer implements ShapeVisitor {

                @Override
                public void visit(Circle circle) {
                    System.out.println("Drawing Circle");
                }

                @Override
                public void visit(Rectangle rectangle) {
                    System.out.println("Drawing Rectangle");
                }

                @Override
                public void visit(Triangle triangle) {
                    System.out.println("Drawing Triangle");
                }
            }

    Step 5: Use the Visitor in the Client Code :- VisitorPatternDemo class demonstrates how to use the Visitor pattern by creating shapes and applying different visitors to them.
            public class VisitorPatternDemo {
                public static void main(String[] args) {
                    Shape[] shapes = new Shape[] {
                        new Circle(2.5),
                        new Rectangle(4, 5),
                        new Triangle(3, 4)
                    };

                    ShapeVisitor areaCalculator = new AreaCalculator();
                    ShapeVisitor shapeDrawer = new ShapeDrawer();

                    for (Shape shape : shapes) {
                        shape.accept(areaCalculator);
                    }

                    for (Shape shape : shapes) {
                        shape.accept(shapeDrawer);
                    }
                }
            }

By following this structure, you can add new operations to shapes by simply creating new visitors without altering the shape classes. This promotes open/closed principle, making the codebase more maintainable and scalable.