public class AircraftOne {

    private static AircraftOne aircraftInstance = null;

    private AircraftOne() {

    }

    public static AircraftOne getInstance() {
        if(aircraftInstance == null) {
            aircraftInstance = new AircraftOne();
        }
        return aircraftInstance;
    }


}
