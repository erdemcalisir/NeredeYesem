package com.example.neredeyesem;

import android.Manifest;
import android.app.KeyguardManager;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button mainButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateContent();
        clickButton();


    }

    //7d081e047da517bf8b91ec2908c9c124
    //zomato key

    private void updateContent()
    {

        mainButton = (Button) findViewById(R.id.mainButton);
    }

    private void clickButton()
    {

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //fingerprintCall();

            Intent intent;
            intent = new Intent(MainActivity.this,LocationActivity.class);
            startActivity(intent);


            }
        });

    }



}
