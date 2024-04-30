import Models.IEngine;

public class Car {

    IEngine engine;
    IVehicleFactory carFactory;

    // car ko kaise pta chalega ki scorpio ya defender wli factory s car lani hai
    Car(IVehicleFactory factory) {
        this.carFactory = factory;
    }

    public void driveCar() {
        engine = carFactory.createEngine();
        System.out.println("MIlgyi gaadi, chillll maro");
    }
}


// yeh factory car ba rhi hai so car ka layer bnayenge hm yha