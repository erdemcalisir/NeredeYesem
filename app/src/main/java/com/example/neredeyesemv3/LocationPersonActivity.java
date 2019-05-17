package com.example.neredeyesemv3;

//necessary imports
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

//the main purpose is finding location
//if found location corecctly, next activty will be restaurant list
public class LocationPersonActivity extends AppCompatActivity {


    //necesarry definitions for location
    public static int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;
    TextView tvLocation;
    private boolean requestingLocationUpdate = true;

    //global variables for to put into intent
    double lastLat;
    double lastLon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_restaurant);

        tvLocation = findViewById(R.id.tv_location);


        fusedLocationProviderClient = new FusedLocationProviderClient(this);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {


                if (locationResult == null) {
                    return;
                }
                //find the location pieces which are lat and long
                for (Location location : locationResult.getLocations()) {
                    Double lat = location.getLatitude();
                    Double lon = location.getLongitude();
                    //display results
                    tvLocation.setText("Latitude: " + lat + "\n" + "Longitude: " + lon);

                    //assign values
                    lastLat = location.getLatitude();
                    lastLon = location.getLongitude();
                }

                // for to show results to user
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent;
                //create new intent
                intent = new Intent(LocationPersonActivity.this, ListRestaurant.class);
                //put extras
                //which is latitude and longitude
                //we will use in other activity for finding the closest restaurant
                intent.putExtra("lat", lastLat + "");
                intent.putExtra("longi", lastLon + "");
                startActivity(intent);

            }
        };

        locationRequest = new LocationRequest();
    }

    //after create life cycyle element, we continue resum method
    //we skipped the start element
    @Override
    protected void onResume() {
        super.onResume();
        if (requestingLocationUpdate) {
            startLocationUpdate();
        }
    }

    //start update locations
    //we need first Permissions granted
    //and check manifest file
    private void startLocationUpdate() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Requesting location permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        } else {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                // Requesting location permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            } else {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    return;
                }
                fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
            }
        }
    }
}

