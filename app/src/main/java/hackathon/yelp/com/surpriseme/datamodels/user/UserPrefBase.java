package hackathon.yelp.com.surpriseme.datamodels.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sushsh on 3/6/2016.
 */
public class UserPrefBase implements IUserPref {

    protected double distancePref = 10.0;
    protected double numberOfReviewsPref = 0.5;
    protected double ratingPref = 0.8;
    protected double onlineOrderPref = 0.5;
    protected double reservationPref = 0.5;
    protected boolean isOnlineOrderRequired = false;
    protected boolean isReservationRequired = false;

    @JsonIgnore
    private List<IUserPrefChangeListener> mListeners;

    // This is for object creation from json
    UserPrefBase() {
    }

    UserPrefBase(double distancePref, double numberOfReviewsPref, double ratingPref, double onlineOrderPref, boolean isOnlineOrderRequired, double reservationPref, boolean isReservationRequired) {
        this.distancePref = distancePref;
        this.numberOfReviewsPref = numberOfReviewsPref;
        this.ratingPref = ratingPref;
        this.onlineOrderPref = onlineOrderPref;
        this.isOnlineOrderRequired = isOnlineOrderRequired;
        this.reservationPref = reservationPref;
        this.isReservationRequired = isReservationRequired;
    }

    private void NotifyChangeListeners(boolean fChangedByUser) {
        if (mListeners != null && mListeners.size() > 0) {
            for (IUserPrefChangeListener listener : mListeners) {
                listener.userPrefChanged(this, fChangedByUser);
            }
        }
    }

    public void OnDataChange(boolean fChangedByUser) {
        NotifyChangeListeners(fChangedByUser);
    }

    @Override
    public void addUserPrefChangeListener(IUserPrefChangeListener listener) {
        if (mListeners == null)
            mListeners = new ArrayList<>();
        mListeners.add(listener);
    }

    @Override
    public void removeUserPrefChangeListener(IUserPrefChangeListener listener) {
        if (mListeners != null &&
                mListeners.contains(listener))
            mListeners.remove(listener);
    }

    public void SetDataFrom(UserPrefBase userPref) {
        this.distancePref = userPref.distancePref;
        this.numberOfReviewsPref = userPref.numberOfReviewsPref;
        this.ratingPref = userPref.ratingPref;
        this.onlineOrderPref = userPref.onlineOrderPref;
        this.reservationPref = userPref.reservationPref;
        this.isOnlineOrderRequired = userPref.isOnlineOrderRequired;
        this.isReservationRequired = userPref.isReservationRequired;

        OnDataChange(false);
    }

    @Override
    public double getDistancePref() {
        return distancePref;
    }

    @Override
    public void setDistancePref(double distancePref) {
        if (this.distancePref != distancePref) {
            this.distancePref = distancePref;
            OnDataChange(true);
        }
    }

    @Override
    public double getNumberOfReviewsPref() {
        return numberOfReviewsPref;
    }

    @Override
    public void setNumberOfReviewsPref(double numberOfReviewsPref) {
        if (this.numberOfReviewsPref != numberOfReviewsPref) {
            this.numberOfReviewsPref = numberOfReviewsPref;
            OnDataChange(true);
        }
    }

    @Override
    public double getRatingPref() {
        return ratingPref;
    }

    @Override
    public void setRatingPref(double ratingPref) {
        if (this.ratingPref != ratingPref) {
            this.ratingPref = ratingPref;
            OnDataChange(true);
        }
    }

    @Override
    public double getOnlineOrderPref() {
        return onlineOrderPref;
    }

    @Override
    public void setOnlineOrderPref(double onlineOrderPref) {
        this.onlineOrderPref = onlineOrderPref;
        OnDataChange(true);
    }

    @Override
    public boolean getIsOnlineOrderRequired() {
        return isOnlineOrderRequired;
    }

    @Override
    public void setIsOnlineOrderRequired(boolean isRequired) {
        isOnlineOrderRequired = isRequired;
        OnDataChange(true);
    }

    @Override
    public boolean getIsReservationRequired() {
        return isReservationRequired;
    }

    @Override
    public void setIsReservationRequired(boolean isRequired) {
        isReservationRequired = isRequired;
        OnDataChange(true);
    }

    @Override
    public double getReservationPref() {
        return reservationPref;
    }

    @Override
    public void setReservationPref(double reservationPref) {
        this.reservationPref = reservationPref;
        OnDataChange(true);
    }
}
