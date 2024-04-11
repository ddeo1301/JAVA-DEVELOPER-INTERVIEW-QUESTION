public class App {
    public static void main(String[] args) {
        // ENCAPSULATION
        Student A = new Student(2, 24, "Divyanshu", 3, "Divya");

        System.out.println(A.getName());

        A.setAge(89);    // we can access through layer GETTER and SETTER . we cant do it directly

        System.out.println(A.getAge());
        
        A.publicStudy();
    }
}
