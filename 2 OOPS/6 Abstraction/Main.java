package AbstractDesign;

interface Bird{
    void fly();   // it is bydefault public
    void eat();
    default void sleep(){
        System.out.println("Bird is sleeping");
    }
}

interface Walk{
    int legs = 4;  // Bydefault it is public, static and final
    void walking();
}

class Sparrow implements Bird, Walk{
    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }
    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }

    @Override
    public void walking() {
        int a = Walk.legs;
        System.out.println("Sparrow walking");
    }

}
public class Main {
    public static void doBirdStuff(Bird b){
        b.eat();
        b.fly();
        b.sleep();
    }

    public static void main(String[] args) {
        // Bird b = new Bird(); // Bird is abstract, so it cannot be instantiated
        Bird b = new Sparrow();
        b.eat(); // sparrow eating
        b.fly(); // Sparrow flying
        b.sleep(); // Bird is sleeping

        doBirdStuff(new Sparrow());
        // OUTPUT
        // sparrow eating
        // Sparrow flying
    }
}
