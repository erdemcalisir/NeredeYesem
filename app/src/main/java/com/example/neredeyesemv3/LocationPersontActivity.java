package com.example.neredeyesemv3;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;


import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;


public class LocationPersontActivity extends AppCompatActivity  {



    public static int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;
    TextView tvLocation;
    private boolean requestingLocationUpdate = true;

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
                for (Location location : locationResult.getLocations()) {
                    Double lat = location.getLatitude();
                    Double lon = location.getLongitude();
                    tvLocation.setText("Lat: " + lat + ", Lon: " + lon);

                    lastLat= location.getLatitude();
                    lastLon= location.getLongitude();
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent;
                intent = new Intent(LocationPersontActivity.this,ListRestaurant.class);
                intent.putExtra("lat",lastLat +"");
                intent.putExtra("longi",lastLon+"");
                startActivity(intent);

            }
        };

        locationRequest = new LocationRequest();

    }



    @Override
    protected void onResume() {
        super.onResume();
        if (requestingLocationUpdate) {
            startLocationUpdate();
        }
    }

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











    // we build google api client



//To be sure to avoid to request permissions
// if the user has already granted them,
// we add the permissions to the list only
// if the permissions is not already granted

    //In the onResume method,
    //we need to check if the user’s device has the Google Play Services installed.
    //This check is made inside a checkPlayServices method


        // Permissions ok, we get last location


//we check the request code to be sure to manage the correct call.
//It is important in an application in which several permissions are requested
