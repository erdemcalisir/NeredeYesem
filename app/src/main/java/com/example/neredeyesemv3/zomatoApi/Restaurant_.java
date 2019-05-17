package com.example.neredeyesemv3.zomatoApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Exampe restaurant class and their functions getter and setter
public class Restaurant_  implements Serializable {

    //constructor

    /*
    public Restaurant_(String name, Location location, UserRating userRating) {
        this.name = name;
        this.location = location;
        this.userRating = userRating;
    }

    public Restaurant_(String name, Location location, String id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }
    */

//not necessary getter and setter
    /*
    public R getR() {
        return r;
    }

    public String getApikey() {
        return apikey;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getSwitchToOrderMenu() {
        return switchToOrderMenu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public Integer getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public String getCurrency() {
        return currency;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public Integer getOpentableSupport() {
        return opentableSupport;
    }

    public Integer getIsZomatoBookRes() {
        return isZomatoBookRes;
    }

    public String getMezzoProvider() {
        return mezzoProvider;
    }

    public Integer getIsBookFormWebView() {
        return isBookFormWebView;
    }

    public String getBookFormWebViewUrl() {
        return bookFormWebViewUrl;
    }

    public String getBookAgainUrl() {
        return bookAgainUrl;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public Integer getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public Integer getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public Boolean getIncludeBogoOffers() {
        return includeBogoOffers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public Integer getIsTableReservationSupported() {
        return isTableReservationSupported;
    }

    public Integer getHasTableBooking() {
        return hasTableBooking;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public List<Object> getEstablishmentTypes() {
        return establishmentTypes;
    }

    public double getDistance() {
        return distance;
    }
    */

    public String getThumb() {
        return thumb;
    }

    @SerializedName("R")
    @Expose
    public R r;
    @SerializedName("apikey")
    @Expose
    public String apikey;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("switch_to_order_menu")
    @Expose
    public Integer switchToOrderMenu;
    @SerializedName("cuisines")
    @Expose
    public String cuisines;
    @SerializedName("average_cost_for_two")
    @Expose
    public Integer averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    public Integer priceRange;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("offers")
    @Expose
    public List<Object> offers = null;
    @SerializedName("opentable_support")
    @Expose
    public Integer opentableSupport;
    @SerializedName("is_zomato_book_res")
    @Expose
    public Integer isZomatoBookRes;
    @SerializedName("mezzo_provider")
    @Expose
    public String mezzoProvider;
    @SerializedName("is_book_form_web_view")
    @Expose
    public Integer isBookFormWebView;
    @SerializedName("book_form_web_view_url")
    @Expose
    public String bookFormWebViewUrl;
    @SerializedName("book_again_url")
    @Expose
    public String bookAgainUrl;
    @SerializedName("thumb")
    @Expose
    public String thumb;
    @SerializedName("user_rating")
    @Expose
    public UserRating userRating;
    @SerializedName("photos_url")
    @Expose
    public String photosUrl;
    @SerializedName("menu_url")
    @Expose
    public String menuUrl;
    @SerializedName("featured_image")
    @Expose
    public String featuredImage;
    @SerializedName("has_online_delivery")
    @Expose
    public Integer hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    @Expose
    public Integer isDeliveringNow;
    @SerializedName("include_bogo_offers")
    @Expose
    public Boolean includeBogoOffers;
    @SerializedName("deeplink")
    @Expose
    public String deeplink;
    @SerializedName("is_table_reservation_supported")
    @Expose
    public Integer isTableReservationSupported;
    @SerializedName("has_table_booking")
    @Expose
    public Integer hasTableBooking;
    @SerializedName("events_url")
    @Expose
    public String eventsUrl;
    @SerializedName("establishment_types")
    @Expose
    public List<Object> establishmentTypes = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEstablishmentTypes(List<Object> establishmentTypes) {
        this.establishmentTypes = establishmentTypes;
    }


    public double distance;


    public String[] detailList(){
        String[] list={"Id: " + id,"Address: "+location.address,"Cuisines: " + cuisines,
                "Average Cost For Two: " + averageCostForTwo,"Currency: " + currency,
                "Aggregate Rating: " + userRating.aggregateRating +
                "  ("+userRating.ratingText+")"+" \nVotes: "+userRating.votes,
                "\nPhotos Url: " + photosUrl, "\nMenu Url: " + menuUrl, "\nEvents Url: " + eventsUrl}  ;
        return  list;

    }


    public String detailListShow()
    {
        return
                "Address: "+location.address+
                        "\n\nCuisines: " + cuisines +
                        "\n\nAverage Cost For Two: " + averageCostForTwo +
                        "\n\nCurrency: " + currency+
                        "\n\nAggregate Rating" + userRating.aggregateRating +
                        ", ("+userRating.ratingText+")"+", Votes: "+userRating.votes+
                        "\n\nMenu Url: " + menuUrl+
                        "\n\nEvents Url: " + eventsUrl;
    }



    @Override
    public String toString() {
        return
                "Id: " + id + "\n\nAddress: "+location.address+
                "\n\nCuisines: " + cuisines +
                "\n\nAverage Cost For Two: " + averageCostForTwo +
                "\n\nCurrency: " + currency+
                "\n\nAggregate Rating" + userRating.aggregateRating +
                        ", ("+userRating.ratingText+")"+", Votes: "+userRating.votes;
    }


}
