package com.example.neredeyesemv3;

//necessary imports

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.neredeyesemv3.zomatoApi.Example;
import com.example.neredeyesemv3.zomatoApi.Restaurant_;

import java.io.Serializable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

//this main method purpose to list restaurant
public class ListRestaurant extends AppCompatActivity {

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    ListView listView;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);

        //we create intent to get other Activity extras
        Intent intent = getIntent();
        //get lat and lon elements
        double lat = Double.parseDouble(intent.getStringExtra("lat"));
        double longi = Double.parseDouble(intent.getStringExtra("longi"));

        //inital define for listView type
        listView = (ListView) findViewById(R.id.restaurantListView);

        //we use retrofit for create object
        Retrofit retrofit = ApiClient.getClient();
        api = retrofit.create(Api.class);
        // create restaurant object use retrofit
        compositeDisposable.add(api.getRestaurantsBySearch(lat, longi, "real_distance", 5).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Example>() {
                            @Override
                            public void accept(Example example) throws Exception {
                                getData(example);

                            }
                        })
                //need datas
        );

    }

    //and we use data type which is example
    // we define and create zomatoApi file
    public void getData(Example example) {

        String[] nameList = new String[5];
        final Bundle bundle = new Bundle();

        //we need 5 nearly restaurant
        //restaurant objects send to restaurant detail activty to use bundle
        for (int i = 0; i < 5; i++) {

            Restaurant_ restaurant = example.restaurants.get(i).getRestaurant();
            bundle.putSerializable("dataList" + i, (Serializable) restaurant);

            nameList[i] = example.restaurants.get(i).getRestaurant().getName();
        }
        //listed restaurant's name in ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, nameList);
        listView.setAdapter(adapter);
        //ListView clickListener  position send to DetailsActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //create intent for pass the other activty which is detail restaurant
                Intent i = new Intent(ListRestaurant.this, RestaurantDetail.class);
                //we put position
                //we can use each restaurant from list with position
                bundle.putSerializable("position", position);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
