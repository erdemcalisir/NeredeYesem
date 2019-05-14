package com.example.neredeyesemv3;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.neredeyesemv3.zomatoApi.Restaurant_;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class RestaurantDetail extends AppCompatActivity {

    ImageView imageView;
    TextView restaurantName;
    TextView restaurantDetails;

    List<Restaurant_> dataList = new ArrayList<>();
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

    //Data funtion
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
        restaurantName.setText(dataList.get(position).getName());
        restaurantDetails.setText(dataList.get(position).detailListShow());


    }


}
