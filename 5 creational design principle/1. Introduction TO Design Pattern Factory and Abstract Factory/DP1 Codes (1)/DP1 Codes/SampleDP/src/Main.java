import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

//        ScorpioN obj = new ScorpioN();
//        obj.driveCar(); // I am driving ScorpioN
//        ScorpioClassic obj2 = new ScorpioClassic();
//        obj2.driveCar();// I am driving ScorpioClassic
//        // this is bakwass tarika as tight coupling ho rha hai as there is a lot of
//        // dependency of reference on the implementation

        Collection<Scorpio> list =  new ArrayList<>();
        Scorpio car1 = new ScorpioN();
        Scorpio car2 = new ScorpioClassic();
        list.add(car1);
        list.add(car2);

        for(Scorpio car: list) {
            car.driveCar();
            // ScorpioN class me hu
            // I am driving ScorpioN
            // ScorpioClassic class me hu
            // I am driving ScorpioClassic
        }

//        ScorpioFactory factory = new ScorpioFactory();
//        Scorpio car1 = factory.createScorpio('D');
//        car1.driveCar(); // I am inside Scorpio Parent Class
//        ScorpioN obj = new ScorpioN();
//        obj.driveCar();
//
//        ScorpioClassic obj3 = new ScorpioClassic();
//        obj3.driveCar();
    }
}