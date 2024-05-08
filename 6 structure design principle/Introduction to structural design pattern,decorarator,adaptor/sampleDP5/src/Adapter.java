public class Adapter implements ICar{
    HotAirBalloon hotAirBalloon;
    public Adapter(HotAirBalloon balloon) { // reference copy kr lia hai yha p
        this.hotAirBalloon = balloon;
    }

    @Override
    public void start() {  // dekhne m lg rha hai ki yeh icar wla start hua hai but asliyat m hotairballon 
        // wla call hua hai. yeh fyada hta hai adadpter ka
        String gasToBeUsed = hotAirBalloon.gasUsed;
        hotAirBalloon.start(gasToBeUsed);
    }
}
