import java.util.ArrayList;
import java.util.List;

public class ATCTower implements ISubject{

    List<IObserver> observers = new ArrayList<>();
    @Override
    public void addObserver(IObserver observer) {
        System.out.println("Subscribed in TOWER");
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        System.out.println("UnSubscribed in TOWER");
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer: observers) {
            //apply some logic
            //apply sokme conditions
            //or you want to notify all registered observers
            observer.proceed(this);
        }
    }
}
