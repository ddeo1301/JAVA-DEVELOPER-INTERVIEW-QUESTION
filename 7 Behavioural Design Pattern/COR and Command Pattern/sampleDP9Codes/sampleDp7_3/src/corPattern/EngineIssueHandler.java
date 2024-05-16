package corPattern;

public class EngineIssueHandler extends AbstractHandler{

    public static int code = 302;


    public EngineIssueHandler(AbstractHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(AbstractRequest request) {
        if(request.getRequestCode() == code) {
            System.out.println("EngineIssueHandler is handling request");
        }
        else {
            super.handleRequest(request);
        }
    }
}
