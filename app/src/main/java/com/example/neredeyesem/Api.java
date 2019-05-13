package com.example.neredeyesem;

import com.example.neredeyesem.zomatoApi.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

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
