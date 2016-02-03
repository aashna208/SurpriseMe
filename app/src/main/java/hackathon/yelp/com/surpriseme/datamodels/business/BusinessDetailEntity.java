package hackathon.yelp.com.surpriseme.datamodels.business;

import java.util.List;

import hackathon.yelp.com.surpriseme.datamodels.user.UserReview;

/**
 * The entity returned when the business is query by id
 */
public class BusinessDetailEntity extends BusinessEntity {

    public List<UserReview> reviews;
}
