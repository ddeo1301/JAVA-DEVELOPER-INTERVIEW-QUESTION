public class BulletProof extends ScorpioDecorator{

    ICar scorpio;  // scorpio ka instance le lia

    public BulletProof(ICar meriScorpio) {  // koi nayi scorpio nahi bni hai blki actual scorpio ka reference ko copy kia gya hai
        this.scorpio = meriScorpio;
    }

    @Override
    public void start() {
        scorpio.start();
    }

    @Override
    public void stop() {
        scorpio.stop();
    }

    @Override
    public float getWeight() {   // bullet proof krne s scorpio k weight increase ho jayega
        return 300f + scorpio.getWeight();
    }
}
