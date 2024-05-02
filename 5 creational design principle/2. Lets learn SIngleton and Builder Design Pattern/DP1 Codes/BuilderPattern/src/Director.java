import Models.ICar;

public class Director {

    ICarBuilder carBuilder; //// instruction dega builder ko

    public Director(ICarBuilder builder) { // builder ki value client dega
        this.carBuilder = builder;
    }

    // instruction 
    // constructer type ..... jo nhi chaiye usme false
    public void construct(boolean tyreNeeded, boolean engineNeeded, boolean bodyNeeded) {
        if(engineNeeded) {
            carBuilder.buildEngine();
        }

        if(tyreNeeded) {
            carBuilder.buildTyre();
        }

        carBuilder.buildChassis();
        if(bodyNeeded) {
            carBuilder.buildBodyShell();
        }

    }


}
