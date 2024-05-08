public class Main {
    public static void main(String[] args) {

        AbstractScorpio scorpio = new ScorpioN(new ScorpioN_Impl_USA());
        System.out.println(scorpio.isRightHanded());

    }
}