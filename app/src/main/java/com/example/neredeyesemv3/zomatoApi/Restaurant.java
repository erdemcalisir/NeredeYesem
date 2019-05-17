package com.example.neredeyesemv3.zomatoApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//API restaurant class

public class Restaurant implements Serializable {

    @SerializedName("restaurant")
    @Expose
    public Restaurant_ restaurant;

    public Restaurant_ getRestaurant() {
        return restaurant;
    }

}