package com.example.neredeyesemv3.zomatoApi;

        import java.io.Serializable;
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

//Zomato API
public class Zomato implements Serializable {

    @SerializedName("results_found")
    @Expose
    public Integer resultsFound;
    @SerializedName("results_start")
    @Expose
    public Integer resultsStart;
    @SerializedName("results_shown")
    @Expose
    public Integer resultsShown;
    @SerializedName("restaurants")
    @Expose
    public List<Restaurant> restaurants = null;

}