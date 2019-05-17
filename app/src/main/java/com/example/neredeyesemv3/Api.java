package com.example.neredeyesemv3;

import com.example.neredeyesemv3.zomatoApi.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

//API interface
//user-key: 7d081e047da517bf8b91ec2908c9c124
//if doesn't return restaurants, API key must be make over

public interface Api {


    //use key to use zomato api
    @Headers({
            "Accept: application/json","user-key: 7d081e047da517bf8b91ec2908c9c124"
    })//take restaurant information from zomato api with location parameters
    @GET("search")
    Observable<Example> getRestaurantsBySearch(@Query("lat") Double latitude,
                                               @Query("lon") Double longtitude,
                                               @Query("sort") String string,
                                               @Query("count") int count);

}
