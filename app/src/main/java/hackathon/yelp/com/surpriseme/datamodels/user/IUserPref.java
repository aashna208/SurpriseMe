package hackathon.yelp.com.surpriseme.datamodels.user;

/**
 * Created by sushsh on 3/6/2016.
 */
public interface IUserPref {
    double getDistancePref();

    void setDistancePref(double distancePref);

    double getNumberOfReviewsPref();

    void setNumberOfReviewsPref(double numberOfReviewsPref);

    double getRatingPref();

    void setRatingPref(double ratingPref);

    double getOnlineOrderPref();

    void setOnlineOrderPref(double onlineOrderPref);

    boolean getIsOnlineOrderRequired();

    void setIsOnlineOrderRequired(boolean isRequired);

    double getReservationPref();

    void setReservationPref(double reservationPref);

    boolean getIsReservationRequired();

    void setIsReservationRequired(boolean isRequired);

    void addUserPrefChangeListener(IUserPrefChangeListener listener);

    void removeUserPrefChangeListener(IUserPrefChangeListener listener);
}
