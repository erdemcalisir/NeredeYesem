package com.example.neredeyesemv3;

//necessary imports

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neredeyesemv3.zomatoApi.Restaurant_;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

//this activty show that restaurant information
public class RestaurantDetail extends AppCompatActivity {

    //inital definitions
    ImageView imageView;
    TextView restaurantName;
    TextView restaurantDetails;
    List<Restaurant_> dataList = new ArrayList<>();

    //to use find which restaurant seleceted
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        // content definition
        contentUpdate();

        //call data function
        getData();

    }

    // content definition
    public void contentUpdate() {
        restaurantName = findViewById(R.id.restaurantName);
        restaurantDetails = findViewById(R.id.restaurantDetails);
        imageView = findViewById(R.id.restaurantPhoto);
    }

    //Data function
    public void getData() {
        //get and bundle operations
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //get selected restaurant position with bundle
        position = (int) bundle.getSerializable("position");


        for (int i = 0; i < 5; i++) {
            String str = "dataList" + i;
            dataList.add((Restaurant_) bundle.getSerializable(str));
        }

        // photos_url is not empty  show
        try {
            Picasso.get().load(dataList.get(position).getThumb()).into(imageView);
        } catch (Exception e) {

        }
        //restaurant name and other details
        //we can change or add Restaurant_ class
        restaurantName.setText(dataList.get(position).getName());
        restaurantDetails.setText(dataList.get(position).detailListShow());
    }
}
