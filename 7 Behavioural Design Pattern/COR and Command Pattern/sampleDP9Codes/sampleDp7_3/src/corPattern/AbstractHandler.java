package corPattern;

public abstract class AbstractHandler {
    private AbstractHandler nextHandler; // handle iss prakar s likhenge ki hme next handler ka reference stored hai

    public AbstractHandler(AbstractHandler next) {
        this.nextHandler = next;
    }

    public void handleRequest(AbstractRequest request) {
        if(nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
