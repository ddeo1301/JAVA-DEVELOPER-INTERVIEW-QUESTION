package AbstractDesign;

abstract class Bird{
    abstract void fly();
    abstract void eat();
    public void sleep(){
        System.out.println("Bird is sleeping");
    }
}

class Sparrow extends Bird{
    @Override
    void fly() {
        System.out.println("Sparrow flying");
    }
    @Override
    void eat() {
        System.out.println("sparrow eating");
    }
}

class Crow extends Bird{
    @Override
    void fly() {
        System.out.println("Crow flying");
    }
    @Override
    void eat() {
        System.out.println("Crow eating");
    }
}

public class AbstractClass {
    public static void doBirdStuff(Bird b){
        b.eat();
        b.fly();
    }

    public static void main(String[] args) {
        // Bird b = new Bird(); // Bird is abstract, so it cannot be instantiated
        Bird b = new Sparrow();
        b.eat(); // sparrow eating
        b.fly(); // Sparrow flying
        b.sleep(); // Bird is sleeping

        b = new Crow();
        b.eat(); // Crow eating
        b.fly(); // Crow flying
        b.sleep(); // Bird is sleeping

        doBirdStuff(new Sparrow());
        // OUTPUT
        // sparrow eating
        // Sparrow flying
        doBirdStuff(new Crow());
        // OUTPUT
        // Crow eating
        // Crow flying
    }
}

