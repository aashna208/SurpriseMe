package hackathon.yelp.com.surpriseme.networkrequest;

public class ServerResult<T> {

    public T result;

    public ServerResult(T result, int httpStatus) {
        this.result = result;
        this.httpStatus = httpStatus;
    }

    public int httpStatus;


}
