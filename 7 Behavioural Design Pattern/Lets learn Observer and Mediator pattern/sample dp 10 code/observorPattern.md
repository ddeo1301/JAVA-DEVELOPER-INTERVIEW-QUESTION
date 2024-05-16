The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects. This means that when one object (the subject) changes state, all its dependents (observers) are notified and updated automatically. This pattern is particularly useful in scenarios where an object needs to notify other objects about changes in its state without being tightly coupled to them.


KEY COMPONENT
 - Subject: The object that holds the state and notifies observers of changes.
 - Observer: The interface or abstract class that defines the method to be called when the subject's state changes.
 - ConcreteSubject: A concrete implementation of the Subject.
 - ConcreteObserver: A concrete implementation of the Observer interface.


JAVA IMPLEMENTATION
 - Let's implement the Observer Pattern in Java with an example. We'll create a simple weather station system where the weather station (Subject) notifies different displays (Observers) whenever there is a change in the weather data.

    Step 1: Define the Observer Interface :- Defines the update method, which will be called when the subject's state changes.
            public interface Observer {
                void update(float temperature, float humidity, float pressure);
            }

    Step 2: Define the Subject Interface :-  Manages a list of observers and provides methods to add, remove, and notify observers.
            import java.util.ArrayList;
            import java.util.List;

            public class Subject {
                private List<Observer> observers = new ArrayList<>();

                public void addObserver(Observer observer) {
                    observers.add(observer);
                }

                public void removeObserver(Observer observer) {
                    observers.remove(observer);
                }

                public void notifyObservers(float temperature, float humidity, float pressure) {
                    for (Observer observer : observers) {
                        observer.update(temperature, humidity, pressure);
                    }
                }
            }

    Step 3: Create the ConcreteSubject Class :-  Extends the Subject and contains state data (temperature, humidity, pressure). When these states change, measurementsChanged() is called to notify all observers.
            public class WeatherData extends Subject {
                private float temperature;
                private float humidity;
                private float pressure;

                public void setMeasurements(float temperature, float humidity, float pressure) {
                    this.temperature = temperature;
                    this.humidity = humidity;
                    this.pressure = pressure;
                    measurementsChanged();
                }

                public void measurementsChanged() {
                    notifyObservers(temperature, humidity, pressure);
                }
            }

    Step 4: Create ConcreteObserver Classes :- Implement the Observer interface and are responsible for updating and displaying information based on the state changes in WeatherData.
            public class CurrentConditionsDisplay implements Observer {
                private float temperature;
                private float humidity;
                private Subject weatherData;

                public CurrentConditionsDisplay(Subject weatherData) {
                    this.weatherData = weatherData;
                    weatherData.addObserver(this);
                }

                @Override
                public void update(float temperature, float humidity, float pressure) {
                    this.temperature = temperature;
                    this.humidity = humidity;
                    display();
                }

                public void display() {
                    System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
                }
            }

            public class ForecastDisplay implements Observer {
                private float currentPressure = 29.92f;
                private float lastPressure;
                private Subject weatherData;

                public ForecastDisplay(Subject weatherData) {
                    this.weatherData = weatherData;
                    weatherData.addObserver(this);
                }

                @Override
                public void update(float temperature, float humidity, float pressure) {
                    lastPressure = currentPressure;
                    currentPressure = pressure;
                    display();
                }

                public void display() {
                    System.out.print("Forecast: ");
                    if (currentPressure > lastPressure) {
                        System.out.println("Improving weather on the way!");
                    } else if (currentPressure == lastPressure) {
                        System.out.println("More of the same");
                    } else if (currentPressure < lastPressure) {
                        System.out.println("Watch out for cooler, rainy weather");
                    }
                }
            }

    Step 5: Test the Observer Pattern :- Demonstrates how the pattern works by creating a WeatherData object and attaching displays (observers) to it. When the weather data changes, all attached displays are automatically updated.
            public class WeatherStation {
                public static void main(String[] args) {
                    WeatherData weatherData = new WeatherData();

                    CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
                    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

                    weatherData.setMeasurements(80, 65, 30.4f);
                    weatherData.setMeasurements(82, 70, 29.2f);
                    weatherData.setMeasurements(78, 90, 29.2f);
                }
            }


The Observer Pattern decouples the subject and the observers, promoting a more flexible and maintainable system where subjects and observers can vary independently.
