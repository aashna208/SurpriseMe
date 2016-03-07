package hackathon.yelp.com.surpriseme.networkrequest;

import android.os.AsyncTask;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import hackathon.yelp.com.surpriseme.GsonHelper;

/**
 * Network Async Task
 *
 * @param <T>
 */
public class NetworkAsyncTask<T> extends AsyncTask<UserRequest, Void, T> {

    private final Token accessToken;
    private AsyncListener<T> asyncListener;

    private static String CONSUMER_KEY = "EdAF-wmlMi22hsT0Q15rxA";
    private static String CONSUMER_SECRET = "Qx7g28y6vepX74AEAyee_qNbjmg";
    private static String TOKEN = "_n3ctvndhxT2bBezwCkbxRg3g-nfFAp3";
    private static String TOKEN_SECRET = "iDY6Rj2EIm8rmeo6r8EJmnJOS74";
    OAuthService service;

    public NetworkAsyncTask(AsyncListener<T> asyncListener) {
        this.asyncListener = asyncListener;
        this.service = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(CONSUMER_KEY)
                .apiSecret(CONSUMER_SECRET).build();
        this.accessToken = new Token(TOKEN, TOKEN_SECRET);
    }

    @Override
    protected T doInBackground(UserRequest... userRequests) {
        UserRequest userRequest = userRequests[0];
        OAuthRequest request = new OAuthRequest(Verb.GET, userRequest.url);
        String response = sendRequestAndGetResponse(request);
        if (response != null) {

            T entity = (T) GsonHelper.deserialize(response, userRequest.classType, userRequest.typeAdapters);


            return entity;
        }

        return null;
    }

    /**
     * Sends an {@link OAuthRequest} and returns the {@link Response} body.
     *
     * @param request {@link OAuthRequest} corresponding to the API request
     * @return <tt>String</tt> body of API response
     */

    private String sendRequestAndGetResponse(OAuthRequest request) {
        System.out.println("Querying " + request.getCompleteUrl() + " ...");
        this.service.signRequest(this.accessToken, request);
        Response response = request.send();
        return response.getBody();
    }

    @Override
    protected void onPostExecute(T httpResponse) {
        asyncListener.OnResponseReceived(httpResponse);
    }
}
