package hackathon.yelp.com.surpriseme.networkrequest;

/**
 * Async listener interface
 */
public interface AsyncListener<T> {

    void OnResponseReceived(T response);
}
