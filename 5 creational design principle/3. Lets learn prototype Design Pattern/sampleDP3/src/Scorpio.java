public class Scorpio implements IScorpioPrototype{

    //default Engine   ..... agr hmne nhi btaya ki kon sa engine le rhe hai then we will take scorpio engine by default
    ScorpioEngine engine;

    public Scorpio() {
        //default engine
        this.engine = new ScorpioEngine();
    }

    private Scorpio(ScorpioEngine scorpioEngine) {
        //deep copy - copy constructor
        this.engine = new ScorpioEngine(scorpioEngine);
    }

    @Override
    public void start() {
        System.out.println("Start hogyi Scorpio");
    }

    @Override
    public IScorpioPrototype clone() {
        IScorpioPrototype clonedScorpio = new Scorpio(this.engine);
        return clonedScorpio; // prototype mein hm bss prototype return krte hai
    }

    @Override
    public void setEngine(ScorpioEngine eng) {
        this.engine = eng;
    }
}
