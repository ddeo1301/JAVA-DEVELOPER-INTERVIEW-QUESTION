package Transport;

public class Vehicle {
    public String name;
    public String model;
    public int noOfTyres;
    public Vehicle(){
        System.out.println("Vehicle constructor called");
        this.name = "";
        this.model = "";
        this.noOfTyres = -1;
    }

    public Vehicle(String n, String m, int not){
        this.name = n;
        this.model = m;
        this.noOfTyres = not;
    }

    public void startEngine(){
        System.out.printf("Engine is starting of %s : %s\n", name, model);
    }

    void stopEngine(){
        System.out.printf("Engine is stopping of %s : %s\n", name, model);
    }
}
