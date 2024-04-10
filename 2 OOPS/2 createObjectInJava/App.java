package StudentPack;

public class App {
    public static void main(String[] args) {
        // Default Constructor
        Student A = new Student();
        // Student Default constructor is called
        System.out.println(A.name); // null
        A.id = 1;
        A.age = 14;
        A.name = "Deo";
        A.nos = 5;
        System.out.println(A.name); // Deo
        System.out.println(A.age);  // 14
        System.out.println(A.id); // 1
        System.out.println(A.nos); // 5

        A.bunk(); // Deo Bunking
        A.study();// Deo Studying
        A.sleep();// Deo sleeping


        // PARAMETRIZED CONSTRUCTOR
        Student B = new Student(2, 24, "Divyanshu", 3);
        // Student Parametrized constructor is called
        System.out.println(B.name); // Divyanshu
        System.out.println(B.age);  // 24
        System.out.println(B.id); // 2
        System.out.println(B.nos); // 3

        B.bunk(); // Divyanshu Bunking
        B.study();// Divyanshu Studying
        B.sleep();// Divyanshu sleeping


        // COPY CONSTRUCTOR
        Student C = new Student(B); // C mein B wla constructor copy hga...agr A dale to wo copy hga
        // Student Copy constructor is called
        System.out.println(C.name); // Divyanshu
        System.out.println(C.age);  // 24
        System.out.println(C.id); // 2
        System.out.println(C.nos); // 3

        C.sleep();// Divyanshu sleeping
        C.bunk(); // Divyanshu Bunking
        C.study(); // Divyanshu Studying
    }

    // Object Lifecycle :-  object create hta hai, object mein atrribute and behaviour set hti hai
    // uske bd object dead ho jta hai
}
