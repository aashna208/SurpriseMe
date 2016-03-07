package hackathon.yelp.com.surpriseme.datamodels.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.security.InvalidParameterException;

/**
 * Created by sushsh on 3/6/2016.
 */
public class UserPref extends UserPrefBase {

    @JsonIgnore
    public String username;
    @JsonIgnore
    private Firebase firebaseRef;

    UserPref() {
    }

    private UserPref(final String username, final Firebase firebaseRef) {
        this.firebaseRef = firebaseRef;
        this.username = username;

        if (username == null || username.length() == 0)
            throw new InvalidParameterException();

        //Lets try to get stuff from the online database
        firebaseRef.child(username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                UserPrefBase userPref1 = dataSnapshot.getValue(UserPrefBase.class);

                if (userPref1 == null) {

                    new DefaultUserPref(firebaseRef, new IUserPrefChangeListener() {
                        @Override
                        public void userPrefChanged(IUserPref userPref, boolean fChangedByUser) {
                            SetDataFromAndUpload((UserPrefBase) userPref);

                            userPref.removeUserPrefChangeListener(this);
                        }

                    });

                } else
                    SetDataFrom(userPref1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public static UserPref getNewInstance(final String username, final Firebase firebaseRef, IUserPrefChangeListener listener) {
        UserPref userPref = new UserPref(username, firebaseRef);
        userPref.addUserPrefChangeListener(listener);
        return userPref;
    }

    /*
        UserPref(String username, Firebase firebaseRef, double distancePref, double numberOfReviewsPref, double ratingPref, OnlineOrderPref onlineOrderPref, ReservationPref reservationPref)
        {
            super(distancePref, numberOfReviewsPref, ratingPref, onlineOrderPref, reservationPref);
            this.username = username;
            this.firebaseRef = firebaseRef;

            upload();
        }
    */
    public void SetDataFromAndUpload(UserPrefBase userPref) {
        SetDataFrom(userPref);
        upload();
    }

    public void upload() {
        firebaseRef.child(this.username).setValue(this);
    }

    @Override
    public void OnDataChange(boolean fChangedByUser) {
        super.OnDataChange(fChangedByUser);
        if (fChangedByUser)
            upload();
    }
}
