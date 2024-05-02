public class SingletonLazy {
    private SingletonLazy() {
        System.out.println("Instance created");
    }
    private static class Holder{
        private static final SingletonLazy INSTANCE = new SingletonLazy();
    }

    public static SingletonLazy getInstance() {
        return Holder.INSTANCE;
    }
    // we create static inner class jbtk hm ise Holder.INSTANCE; aise refer nhi krenge till then line 
    // 5 will not get executed. asliyat m hmne early initialisation hi ki hai. 

    public static void main(String[] args) {

//        Singleton obj1 = Singleton.getInstance();
//        Singleton obj2 = Singleton.getInstance();
        Thread th1 = new Thread( () -> {SingletonLazy.getInstance();}  );
        Thread th2 = new Thread( () -> {SingletonLazy.getInstance();}  );
        // Instance created.....bss ek brr object create hga

        th1.start();
        th2.start();

    }
}
