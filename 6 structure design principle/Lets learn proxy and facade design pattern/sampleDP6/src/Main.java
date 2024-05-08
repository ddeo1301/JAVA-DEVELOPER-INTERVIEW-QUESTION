import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create a remote proxy
        RemoteProxy remoteProxy = new RemoteProxy();// hme pta hai yhi proxy hai prr user k hisab s 
        // yeh remote control car hai

        while(true) {
            Scanner sc  = new Scanner(System.in);
            String action = sc.nextLine();

            switch(action) {
                case "left":remoteProxy.turnLeft();
                    break;
                // left
                // I am inside turnleft in Remote class
                // I am inside turnleft in Remote class
                case "right":remoteProxy.turnRight();
                    break;
                case "straight":remoteProxy.goStraight();
                    break;
                default:
                    System.out.println("Invalid action");
            }
        }


    }
}