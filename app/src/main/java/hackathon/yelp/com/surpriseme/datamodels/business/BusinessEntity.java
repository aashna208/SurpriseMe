package hackathon.yelp.com.surpriseme.datamodels.business;

import com.google.gson.annotations.SerializedName;

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
    @SerializedName("image_url")
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
    @SerializedName("mobile_url")
    public String mobileUrl;

    /**
     * The phone number
     */
    @SerializedName("phone")
    public String phoneNumber;

    /**
     * The rating for business
     */
    @SerializedName("rating")
    public double rating;

    /**
     * The url to give image for ratings with stars
     * lowres
     */
    @SerializedName("rating_img_url_small")
    public String ratingImageUrlSmall;

    /**
     * The url to give image for rating with stars
     * hires
     */
    @SerializedName("rating_img_url")
    public String ratingImageUrlLarge;

    /**
     * the number of reviews for business
     */
    @SerializedName("review_count")
    public int numberOfReviews;

    /**
     * List of category name and alias for the business
     * for e.g.     ["Active Life", "Active"], ["Media", "massmedia"]
     */
    public List<List<String>> categories;

    public BusinessLocation location;

    /**
     * The url to reserve
     */
    @SerializedName("reservation_url")
    public String seatMeUrl;

    /**
     * The url to order online
     */
    @SerializedName("eat24_url")
    public String eat24url;

    /**
     * The time menu was updated
     * value in unix time
     */
    @SerializedName("menu_date_updated")
    public long MenuUpdateTimestamp;

    @SerializedName("snippet_text")
    public String snippetText;

}
