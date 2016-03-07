package hackathon.yelp.com.surpriseme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import hackathon.yelp.com.surpriseme.datamodels.business.BusinessResult;
import hackathon.yelp.com.surpriseme.networkrequest.AsyncListener;
import hackathon.yelp.com.surpriseme.yelpinteraction.BusinessInteraction;

public class MainActivity extends AppCompatActivity {


    BusinessInteraction businessInteraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        businessInteraction = new BusinessInteraction();
    }

    @Override
    protected void onResume() {
        super.onResume();
        final TextView textView = (TextView) findViewById(R.id.text_view);
        businessInteraction.getBestMatchedResults("food", null, 20, new AsyncListener<BusinessResult>() {
            @Override
            public void OnResponseReceived(BusinessResult response) {
                textView.setText(response == null ? String.valueOf(0) : String.valueOf(response.numberOfResults));

            }
        });

    }
}
