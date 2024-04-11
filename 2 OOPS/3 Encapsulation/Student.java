public class Student {
    
    private int age;
    private String name;

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    public void setAge(int a){
        // extra layer of authentication
        if(age < 100)
           this.age = a;
        return;
    }
   
    // Default constructor  // attribute -> garbage
    public Student(){
        System.out.println("Student Default constructor is called");
    }

    // Parametrized constructor
    public Student( int agexx, String namexx, ){
        this.age = agexx;
        this.name = namexx;
    }

    private void study(){
        System.out.println(name + " Studying");
    }

    public void publicStudy(){
        study();
    }

}
