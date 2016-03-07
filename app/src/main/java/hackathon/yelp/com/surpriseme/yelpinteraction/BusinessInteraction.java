package hackathon.yelp.com.surpriseme.yelpinteraction;

import hackathon.yelp.com.surpriseme.datamodels.business.BusinessResult;
import hackathon.yelp.com.surpriseme.networkrequest.AsyncListener;
import hackathon.yelp.com.surpriseme.networkrequest.NetworkAsyncTask;
import hackathon.yelp.com.surpriseme.networkrequest.UserRequest;

/**
 * business interaction
 */
public class BusinessInteraction implements IBusinessInteraction {

    private static String YELP_SEARCH =
            "https://api.yelp.com/v2/search?term={term}&limit={limit}&sort={sort}&location=San+Fransisco";
    private static int SORT_BEST_MATCHED = 0;
    private static int SORT_NEAREST = 1;
    private static int SORT_HIGHEST_RATED = 2;

    @Override
    public void getBestMatchedResults(String searchTerm, String category, int number, AsyncListener asyncListener) {
        yelpSearch(searchTerm, number, SORT_BEST_MATCHED, asyncListener);
    }

    @Override
    public void getNearestResults(String searchTerm, String category, int number, AsyncListener asyncListener) {
        yelpSearch(searchTerm, number, SORT_NEAREST, asyncListener);
    }

    @Override
    public void getHighestRatedResults(String searchTerm, String category, int number, AsyncListener asyncListener) {
        yelpSearch(searchTerm, number, SORT_HIGHEST_RATED, asyncListener);
    }

    @Override
    public void getBusinessDetails(String businessId, AsyncListener asyncListener) {
        // yelpSearch(searchTerm, number, SORT_BEST_MATCHED, asyncListener);
    }

    private static void yelpSearch(String searchTerm, int number, int sort, AsyncListener asyncListener) {
        String url = YELP_SEARCH;
        url = url.replace("{term}", searchTerm);
        url = url.replace("{limit}", String.valueOf(number));
        url = url.replace("{sort}", String.valueOf(SORT_BEST_MATCHED));

        NetworkAsyncTask<BusinessInteraction> networkAsyncTask =
                new NetworkAsyncTask(asyncListener);
        UserRequest<BusinessResult> userRequest =
                new UserRequest<BusinessResult>(url, BusinessResult.class, null);
        networkAsyncTask.execute(userRequest);
    }
}
