import java.util.ArrayList;
import java.util.List;

public class ATCTower {

    //beforehand data hona chahoye saare aircraft ka
    List<IAircraft> queueForLanding = new ArrayList<>();

    synchronized public void requestToLand(IAircraft aircraft) {
        //check for permission and if permission is granted then call land method
        aircraft.land();

    }
}
