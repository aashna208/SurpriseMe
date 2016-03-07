package hackathon.yelp.com.surpriseme.datamodels.user;

/**
 * Created by sushsh on 3/6/2016.
 */
public interface IUserPrefChangeListener {
    void userPrefChanged(IUserPref userPref, boolean fChangedByUser);
}
