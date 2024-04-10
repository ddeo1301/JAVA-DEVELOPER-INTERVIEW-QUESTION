package StudentPack;

public class Student {
    // Attributes
    public int id;
    public int age;
    public String name;
    public int nos;

    // Default constructor  // attribute -> garbage
    public Student(){
        System.out.println("Student Default constructor is called");
    }

    // Parametrized constructor
    public Student(int idxx, int agexx, String namexx, int nosxx){
        System.out.println("Student Default constructor is called");
        this.id = idxx;   // this keyword bolta hai jo abhi bn rha hai
        this.age = agexx;
        this.name = namexx;
        this.nos = nosxx;
    }

    // COPY CONSTRUCTOR
    public Student(Student srcobj){  // srcobj  ->  A
        System.out.println("Student Copy constructor is called");
        this.id = srcobj.id;
        this.age = srcobj.age;
        this.name = srcobj.name;
        this.nos = srcobj.nos;
    }

    // Methods / Behaviours
    public void study(){
        System.out.println(name + " Studying");
    }

    public void sleep(){
        System.out.println(name + " sleeping");
    }

    public void bunk(){
        System.out.println(name + " Bunking");
    }

}
