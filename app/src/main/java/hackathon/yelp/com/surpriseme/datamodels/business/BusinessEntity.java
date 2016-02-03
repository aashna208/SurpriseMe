package hackathon.yelp.com.surpriseme.datamodels.business;

import java.util.List;
import java.util.Map;

public class BusinessEntity {

    /**
     * The name of the business
     */
    public String name;

    /**
     * The image url for the business
     */
    public String imageUrl;

    /**
     * The website for business
     */
    public String url;

    /**
     * The mobile website for yelp
     * <p/>
     * this can be used for redirection to yelp
     */
    public String mobileUrl;

    /**
     * The phone number
     */
    public String phoneNumber;

    /**
     * The rating for business
     */
    public double rating;

    /**
     * The url to give image for ratings with stars
     * lowres
     */
    public String ratingImageUrlSmall;

    /**
     * The url to give image for rating with stars
     * hires
     */
    public String ratingImageUrlLarge;

    /**
     * the number of reviews for business
     */
    public int numberOfReviews;

    /**
     * List of category name and alias for the business
     * for e.g.     ["Active Life", "Active"], ["Media", "massmedia"]
     */
    public List<Map.Entry<String, String>> categories;

    public BusinessLocation location;

    /**
     * The url to reserve
     */
    public String seatMeUrl;

    /**
     * The url to order online
     */
    public String eat24url;

    /**
     * The time menu was updated
     * value in unix time
     */
    public long MenuUpdateTimestamp;

}
