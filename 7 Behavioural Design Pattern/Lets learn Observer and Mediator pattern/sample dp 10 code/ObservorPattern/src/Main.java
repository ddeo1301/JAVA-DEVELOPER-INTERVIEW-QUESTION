public class Main {
    public static void main(String[] args) {
        ATCTower tower = new ATCTower();
        Boeing boeing1 = new Boeing(tower);

        boeing1.fly();
        // Subscribed in TOWER
        // Took-Off
        boeing1.land();
        // Landed
        // UnSubscribed in TOWER 
        Boeing boeing2 = new Boeing(tower);
        Boeing boeing3 = new Boeing(tower);
        Boeing boeing4 = new Boeing(tower);
        Boeing boeing5 = new Boeing(tower);
        boeing2.fly();
        boeing3.fly();
        boeing4.fly();
        boeing5.fly();

        tower.notifyObservers();


    }
}