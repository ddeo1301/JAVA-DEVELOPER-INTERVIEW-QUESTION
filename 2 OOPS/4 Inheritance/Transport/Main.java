package Transport;

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Maruti", "800", 4, 5, 5);
        c.startEngine(); // Engine is starting of Maruti : 800
        c.startAC();     // AC started of Maruti
        c.stopEngine();  // Engine is stopping of Maruti : 800
        System.out.println(c.name); // Maruti

        MotorCycle m = new MotorCycle("Splendor", "Xline", 2, "U", "Soft");
        m.startEngine();  // Engine is starting of Splendor : Xline
        m.wheelie();      // MotorCycle is doing Wheelieeeeeee! Splendor
        m.stopEngine();   // Engine is stopping of Splendor : Xline

        // java: incompatible types: Transport.Car cannot be converted to Transport.MotorCycle
        //MotorCycle m1 = new Car("Maruti", "800", 4, 5, 5);

         Vehicle v2 = new Maruti();
         // 1) Here, you're creating a Maruti object and assigning it to a Vehicle reference variable v2.
        // 2) When you instantiate Maruti, the constructor chain is invoked. Since Maruti extends Car, which extends
        // Vehicle, constructors for all three classes are called in sequence.
        // 3) So, the output shows the constructor calls in the order they occur: Vehicle constructor, then Car
        // constructor, and finally Maruti constructor.

         // Vehicle constructor called
        // Car constructor is called
        // Maruti constructor called

        Car c2 = new Maruti();
        // 1) Similarly, you're creating a Maruti object and assigning it to a Car reference variable c2.
        // 2) As with the previous case, the constructor chain is invoked when instantiating Maruti,
        // resulting in the same sequence of constructor calls: Vehicle constructor, Car constructor, and Maruti
        // constructor.

        // Vehicle constructor called
        // Car constructor is called
        // Maruti constructor called

    }
}
