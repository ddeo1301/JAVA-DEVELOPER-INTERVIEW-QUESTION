import Models.ScorpioClassicBodyShell;
import Models.ScorpioClassicEngine;
import Models.ScorpioNBodyShell;
import Models.ScorpioNEngine;

public class ScorpioN extends Scorpio {

    public void makeScorpio() {
        System.out.println("ScorpioN class me hu");
        this.engine = new ScorpioNEngine();
        this.bodyShell= new ScorpioNBodyShell();
    }
    public void driveCar() {
        makeScorpio();
        System.out.println("I am driving a ScorpioN");
    }
}
