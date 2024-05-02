import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        Collection<Scorpio> list =  new ArrayList<>();
        Scorpio car1 = new ScorpioN();
        Scorpio car2 = new ScorpioClassic();
        list.add(car1);
        list.add(car2);

        for(Scorpio car: list) {
            car.driveCar();
        }

//        ScorpioFactory factory = new ScorpioFactory();
//        Scorpio car1 = factory.createScorpio('D');
//        car1.driveCar();
//        ScorpioN obj = new ScorpioN();
//        obj.driveCar();
//
//        ScorpioClassic obj3 = new ScorpioClassic();
//        obj3.driveCar();
    }
}