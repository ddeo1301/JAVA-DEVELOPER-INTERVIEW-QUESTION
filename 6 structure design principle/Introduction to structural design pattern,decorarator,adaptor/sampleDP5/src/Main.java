public class Main {
    public static void main(String[] args) {
        HotAirBalloon hotAirBalloon = new HotAirBalloon();
        Adapter adapter = new Adapter(hotAirBalloon);
        adapter.start();
    }
}