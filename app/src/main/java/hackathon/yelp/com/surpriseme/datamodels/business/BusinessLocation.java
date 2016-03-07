package hackathon.yelp.com.surpriseme.datamodels.business;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import hackathon.yelp.com.surpriseme.datamodels.Coordinate;

public class BusinessLocation {

    public String city;

    /**
     * state code
     * CA, NY, WA etc
     */
    @SerializedName("state_code")
    public String stateCode;

    @SerializedName("postal_code")
    public String zipCode;

    @SerializedName("country_code")
    public String countryCode;

    @SerializedName("cross_streets")
    public String crossStreets;

    @SerializedName("display_address")
    public List<String> displayAddresses;

    public List<String> address;

    @SerializedName("neighborhoods")
    public List<String> neighborhoods;

    @SerializedName("coordinate")
    public Coordinate locationCoordinate;

    @SerializedName("geo_accuracy")
    public double locationAccuracy;
}
