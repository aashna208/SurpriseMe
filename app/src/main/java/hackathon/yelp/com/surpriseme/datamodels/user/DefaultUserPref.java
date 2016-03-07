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
public class DefaultUserPref extends UserPrefBase {

    @JsonIgnore
    private static final String mDefaultUsername = "default";
    @JsonIgnore
    private Firebase firebaseRef;

    DefaultUserPref() {
    }

    DefaultUserPref(final Firebase firebaseRef, IUserPrefChangeListener listener) {
        if (firebaseRef == null)
            throw new InvalidParameterException();

        this.firebaseRef = firebaseRef;

        // Add the listener
        addUserPrefChangeListener(listener);

        //Lets try to get stuff from the online database
        firebaseRef.child(mDefaultUsername).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DefaultUserPref defaultPref = dataSnapshot.getValue(DefaultUserPref.class);
                if (defaultPref == null) {
                    //the user is not present
                    throw new UnknownError("This is not expected. Default pref missing in the DB?");
                }
                SetDataFrom(defaultPref);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
