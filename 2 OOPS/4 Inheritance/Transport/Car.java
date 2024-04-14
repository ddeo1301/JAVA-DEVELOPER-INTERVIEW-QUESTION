package Transport;

public class Car extends Vehicle{
    public int noOfDoors;
     public int transmissionType;

    public Car(){
        System.out.println("Car constructor is called");
        this.noOfDoors = 0;
        this.transmissionType = 0;
    }

    public Car(String name, String model, int noOfTyres,int nod, int tl){
        super(name, model, noOfTyres);  // super() ..... Default constructor will be called
        this.noOfDoors = nod;
        this.noOfTyres = tl;
        // super.startEngine();
    }

    public void startAC(){
        System.out.println("AC started of " + name);
    }

}
