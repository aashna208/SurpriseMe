package hackathon.yelp.com.surpriseme.datamodels;

import com.google.gson.annotations.SerializedName;

public class Coordinate {

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("longitude")
    public double longitude;
}
