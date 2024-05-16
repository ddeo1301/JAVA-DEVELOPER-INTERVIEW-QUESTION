public class Boeing implements IAircraft, IObserver{

    ISubject tower;

    public Boeing(ISubject tower) {
        this.tower = tower;
    }

    @Override
    public void land() {
        //land krne k baad, unsubscribe the SUBJECT
        System.out.println("Landed");
        tower.removeObserver(this);

    }

    @Override
    public void fly() {
        tower.addObserver(this);
        System.out.println("Took-Off");
    }

    @Override
    public void proceed(Object newState) {
        //custom logic
        System.out.println("I am executing the proceeed method of aircraft");
    }
}
