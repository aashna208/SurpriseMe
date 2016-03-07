package hackathon.yelp.com.surpriseme.datamodels.business;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusinessResult {

    @SerializedName("businesses")
    public List<BusinessSearchEntity> businessEntities;

    /**
     * Gets the total number of results
     */
    @SerializedName("total")
    public int numberOfResults;
}
