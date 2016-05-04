package com.example.arthurnguyen.cmpe137project;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.audiofx.BassBoost;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Purchase extends AppCompatActivity implements OnClickListener {

    //    Initializations
    boolean design1, design2, design3;
    ImageButton bDesign1, bDesign2, bDesign3;
    int currentDesign;
    private LocationManager mLocationManager;
    private LocationListener mLocationListener;
    
    Button bGPS;
    
    double longitude;
    double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        bDesign1 = (ImageButton) findViewById(R.id.bDesign1);
        bDesign2 = (ImageButton) findViewById(R.id.bDesign2);
        bDesign3 = (ImageButton) findViewById(R.id.bDesign3);

        // Accept data
        Bundle extras = getIntent().getExtras();
        design1 = getIntent().getExtras().getBoolean("design1");
        design2 = getIntent().getExtras().getBoolean("design2");
        design3 = getIntent().getExtras().getBoolean("design3");
        currentDesign = extras.getInt("currentDesign", 1);

        if (currentDesign == 1) {
            Toast.makeText(Purchase.this, "1", Toast.LENGTH_SHORT).show();
        }
        if (currentDesign == 2) {
            Toast.makeText(Purchase.this, "2", Toast.LENGTH_SHORT).show();
        }
        if (currentDesign == 3) {
            Toast.makeText(Purchase.this, "3", Toast.LENGTH_SHORT).show();
        }

        bDesign1.setOnClickListener(this);
        bDesign2.setOnClickListener(this);
        bDesign3.setOnClickListener(this);

//        Location
        bGPS = (Button) findViewById(R.id.bGPS);
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude=location.getLatitude();
                longitude=location.getLongitude();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET
                    },10);
                    }
                return;
            }else{
                configureButton();
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch(requestCode){
            case 10:
                if(grantResults.length> 0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                    configureButton();
                    mLocationManager.requestLocationUpdates("gps", 5000, 0, mLocationListener);
                    return;
                }
        }
    }

    private void configureButton() {
        bGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocationManager.requestLocationUpdates("gps", 5000, 0, mLocationListener);
            }
        });
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.bDesign1:
                if(design1 == true) {
                    Toast.makeText(Purchase.this,"You already have this design",Toast.LENGTH_SHORT).show();
                }
                else{
                    new AlertDialog.Builder(Purchase.this).setTitle("Confirm Purchase").
                            setMessage("Would you like to purchase this design?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    design1 = true;    currentDesign=1;
                                    Toast.makeText(Purchase.this,"You acquired Squirtle design",Toast.LENGTH_SHORT).show();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                                }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();

                }
                break;
            case R.id.bDesign2:
                if(design2 == true) {
                    Toast.makeText(Purchase.this,"You already have this design",Toast.LENGTH_SHORT).show();
                }
                else{
                    new AlertDialog.Builder(Purchase.this).setTitle("Confirm Purchase").
                            setMessage("Would you like to purchase this design?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            design2 = true;   currentDesign=2;
                            Toast.makeText(Purchase.this,"You acquired Charmander design",Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();

                }
                break;
            
            case R.id.bDesign3:

            if(design2 == true) {
                Toast.makeText(Purchase.this,"You already have this design",Toast.LENGTH_SHORT).show();
            }
            else{
                if(Math.abs(latitude - 37.3352) < .1 && Math.abs(longitude - 12.1881) < .1){
                    design3 = true;
                    currentDesign = 3;
                }
                else{
                    Toast.makeText(Purchase.this,"You must be at SJSU to unlock this design",Toast.LENGTH_SHORT).show();
                    Toast.makeText(Purchase.this,String.valueOf(longitude) + String.valueOf(latitude),Toast.LENGTH_SHORT).show();

                }

            }
            break;
                



        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_user_area, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.home_id:

//                    Start activity
                Intent intent = new Intent(this, UserAreaActivity.class);
//                    Pass values
                intent.putExtra("design1", design1);
                intent.putExtra("design2", design2);
                intent.putExtra("design3", design3);
                intent.putExtra("currentDesign", currentDesign);
                startActivity(intent);

        }
        return true;
    }

}
