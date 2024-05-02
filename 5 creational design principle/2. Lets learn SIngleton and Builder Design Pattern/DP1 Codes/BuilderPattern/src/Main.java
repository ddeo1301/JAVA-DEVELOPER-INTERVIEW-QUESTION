import Models.ICar;

public class Main {
    public static void main(String[] args) {
        ICarBuilder builder = new ScorpioBuilder();
        // Scorpio Engine getting inserted
        // Scorpio Tyre getting inserted
        // Scorpio Chassis getting inserted
        // Scorpio Body getting inserted
        // Scorpio tyaar hai, le jao
        Director director = new Director(builder);
        //guidance dedo
        director.construct(false, false, false);

        ICar car = builder.build();

    }
}