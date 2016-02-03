package hackathon.yelp.com.surpriseme.datamodels.business;


import java.util.List;

import hackathon.yelp.com.surpriseme.datamodels.Coordinate;

public class BusinessLocation {

    public String city;

    /**
     * state code
     * CA, NY, WA etc
     */
    public String stateCode;

    public String zipCode;

    public String countryCode;

    public String crossStreets;

    public List<String> displayAddresses;

    public List<String> address;

    public List<String> neighborhoods;

    public Coordinate locationCoordinate;

    public double locationAccuracy;
}
