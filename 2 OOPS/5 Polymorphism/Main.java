package Polymorphism;

public class Main {
    public static void main(String[] args) {
        // METHOD OVERLOADING
        Calculator c = new Calculator();
        System.out.println(c.add(2, 3)); // 5
        System.out.println(c.add(2, 3, 4)); // 9
        System.out.println(c.add(2,3, 4,5.6)); // 14.6


        // RUNTIME POLYMORPHISM
        Circle c = new Circle();
        c.draw();  // if draw method is not in circle then -> Generic shape drawing...i.e shape method i.e parent mehod will be called
        // else -> Circle drawing... i.e circle method wla draw will be called

        Rect r = new Rect();
        r.draw(); // Rect is drawing...

        Shape s1 = new Rect();
        s1.draw(); // Rect is drawing...

        // UPCASTING  -> child class reference we r storing in parent class
        Circle c1 = new Circle();
        doDrawingStuff(new Shape());  // Generic shape drawing...
        doDrawingStuff(c1);    // Circle drawing...

        Rect r1 = new Rect();
        doDrawingStuff(r1);  // Rect is drawing...


        // DOWNCASTING
        Circle c2 = new Circle();
        doDrawingStuff(c2);
    }

    public static void doDrawingStuff(Shape s){
        s.draw();  // polymorphics
        // As parent can hold child method . so, parent can call child relevant method

        // DOWNCASTING
        Circle c = (Circle)s;  // Circle drawing...
        c.draw();              // Circle drawing...
        c.personal();          // PErsonal method of Circle...
    }
}
