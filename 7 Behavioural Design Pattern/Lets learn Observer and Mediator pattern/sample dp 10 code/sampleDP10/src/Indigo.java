public class Indigo implements IAircraft{
    ATCTower atcTower;

    public Indigo(ATCTower tower) {
        this.atcTower = tower;
    }

    //khud se land ko call nahi krega aircraft, kyoki permission is needed
    @Override
    public void land() {
        System.out.println("Main Mahendra Indigi Land karrra hu");
    }
    //premission lega ATC se
    public void requestPermForLanding() {
        //TODO: ATC tower se permission lo
        System.out.println("Calling atc tower method for permissions");
        atcTower.requestToLand(this);
    }
}
