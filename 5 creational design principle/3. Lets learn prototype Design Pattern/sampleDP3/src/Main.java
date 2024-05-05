public class Main {
    public static void main(String[] args) {
        //create a prototype
        IScorpioPrototype prototype = new Scorpio();

        //create a Scorpio N
        IScorpioPrototype scorpioN = prototype.clone(); // protype copy kia hmne
        scorpioN.setEngine(new ScorpioNEngine());// engine ka diff tha so we handle it here

        ///create a Scorpio Classsic
        IScorpioPrototype scorpioClassic = prototype.clone();// new krke object nhi bnayenge as we will use protype
        scorpioClassic.setEngine(new ScorpioClassicEngine());

    }
}