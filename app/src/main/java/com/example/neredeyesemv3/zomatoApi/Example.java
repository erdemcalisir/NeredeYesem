package com.example.neredeyesemv3.zomatoApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


//example  restaurant class for ListRestaurant activty
public class Example {

    @SerializedName("results_found")
    @Expose
    private Integer resultsFound;
    @SerializedName("results_start")
    @Expose
    private Integer resultsStart;
    @SerializedName("results_shown")
    @Expose
    private Integer resultsShown;
    @SerializedName("restaurants")
    @Expose
    public List<Restaurant> restaurants = null;



    public List<Restaurant> getRestaurants() {
        return restaurants;
    }



}