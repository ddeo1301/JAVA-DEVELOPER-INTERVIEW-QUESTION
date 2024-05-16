package cmdPattern;

public class AirSuspensionCommand implements Command{

    AirSuspensionMechanism airSuspensionMechanism;

    public AirSuspensionCommand(AirSuspensionMechanism airSuspension) {
        this.airSuspensionMechanism = airSuspension;
    }

    @Override
    public void execute() {
        airSuspensionMechanism.liftSuspension();
    }

}
