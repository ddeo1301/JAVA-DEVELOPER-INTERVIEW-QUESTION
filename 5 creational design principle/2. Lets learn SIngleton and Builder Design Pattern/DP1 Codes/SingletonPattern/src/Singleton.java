public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("constructor k andar hu, instance create");
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {

//        Singleton obj1 = Singleton.getInstance();
//        Singleton obj2 = Singleton.getInstance();
// //     constructor k andar hu, instance create
// // yha pe 2 object create krne ki kosis kr rhe hai prr bss 1 object create ho rha but for thread
// // 2 object will be created

// 2nd
//        Thread th1 = new Thread( () -> {Singleton.getInstance();}  ); 
//        Thread th2 = new Thread( () -> {Singleton.getInstance();}  );// 2 object bn gye mtlb code fatt gya
// // constructor k ander hm 2 brr chale gye jbki hme ek brr hi jna tha
// //     constructor k andar hu, instance create
// //     constructor k andar hu, instance create
//
//        th1.start();
//        th2.start();

    }
}
