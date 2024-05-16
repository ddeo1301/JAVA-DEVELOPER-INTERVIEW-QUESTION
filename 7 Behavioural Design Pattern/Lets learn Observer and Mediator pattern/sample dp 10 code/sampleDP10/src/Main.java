public class Main {
    public static void main(String[] args) {
        ATCTower atcTower = new ATCTower();
        Indigo indigo = new Indigo(atcTower);

        indigo.requestPermForLanding();
    }
}