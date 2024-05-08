public class RemoteProxy implements ICar{

    RCScorpio scorpio = new RCScorpio();
    @Override
    public void turnLeft() {
        System.out.println("I am inisde turnLeft in Remote Class");
        scorpio.turnLeft();
    }

    @Override
    public void turnRight() {
        System.out.println("I am inisde turnRight in Remote Class");

    }

    @Override
    public void goStraight() {
        System.out.println("I am inisde go straight in Remote Class");

    }
}
