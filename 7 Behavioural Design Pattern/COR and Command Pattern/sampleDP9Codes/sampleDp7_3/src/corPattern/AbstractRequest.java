package corPattern;

public abstract class AbstractRequest {

    private int requestCode;// sbse imporatant hai request ka code

    AbstractRequest(int reqCode) {
        this.requestCode = reqCode;
    }

    public int getRequestCode() { // request fetch krna hai
        
        return requestCode;
    }

}
