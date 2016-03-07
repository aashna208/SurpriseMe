package hackathon.yelp.com.surpriseme.yelpinteraction;

import hackathon.yelp.com.surpriseme.datamodels.business.BusinessEntity;
import hackathon.yelp.com.surpriseme.datamodels.business.BusinessResult;
import hackathon.yelp.com.surpriseme.networkrequest.AsyncListener;

public interface IBusinessInteraction {

    /**
     * Gets the best matched results
     * refer https://www.yelp.com/developers/documentation/v2/all_category_list
     * for supported category list
     * search term can be food, restaurant, bar, restaurant name etc can be empty too
     */
    void getBestMatchedResults(String searchTerm, String category, int number, AsyncListener<BusinessResult> asyncListener);


    void getNearestResults(String searchTerm, String category, int number, AsyncListener<BusinessResult> asyncListener);

    /**
     * Gets the highest rated results - with highest rating at top which is normalized to get the
     * correct ordering based on rating and number of ratings
     * @param searchTerm
     * @param category
     * @param number
     * @return
     */
    void getHighestRatedResults(String searchTerm, String category, int number, AsyncListener<BusinessResult> asyncListener);

    void getBusinessDetails(String businessId, AsyncListener<BusinessEntity> asyncListener);
}
