public class Indigo implements IAircraft{
    // yeh aircraft mediator s deal krega i.e ATCTower
    ATCTower atcTower; // composition 

    public Indigo(ATCTower tower) { //  constructor s initialise krenge
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
