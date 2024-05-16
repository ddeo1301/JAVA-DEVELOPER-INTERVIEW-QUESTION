package cmdPattern;

import corPattern.EngineIssueRequest;

public class EngageBreakCommand implements Command{

    BreakMechanism breakMechanism;

    public EngageBreakCommand(BreakMechanism breakiii) {
        this.breakMechanism = breakiii;
    }

    @Override
    public void execute() {
        breakMechanism.applyBreak();
    }
}
