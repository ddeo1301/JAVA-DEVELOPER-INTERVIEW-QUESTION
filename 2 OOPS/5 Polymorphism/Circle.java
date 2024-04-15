package Polymorphism;

public class Circle extends Shape {
    @Override  // not neccesary to write just to customise that its parent class also have the same method
    public void draw(){
        System.out.println("Circle drawing...");
    }

    public void personal(){
        System.out.println("PErsonal method of Circle...");
    }
}
