public class Tejas implements IAircraft{

    //intrinsic property
    private final String name = "Tejas";
    private final int seater = 2;
    private final String dimensions = "15m long 4 m wide";
    private final String wingSpan = "40 feet";

    //extrinsic property
    public double getTotalTimeToReachDestination(int srcX, int srcY, int desX, int desY, int speed) {
        return 5;
    }
}
