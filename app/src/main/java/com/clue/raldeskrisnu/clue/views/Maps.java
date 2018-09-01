package com.clue.raldeskrisnu.clue.views;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.clue.raldeskrisnu.clue.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Maps extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String data;
    private String dataParse;
    private String username;
    private String kelurahan;
    private Float lat;
    private Float lng;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        username = extras.getString("ExtraUsername");
        kelurahan = extras.getString("ExtraKelurahan");
        lat = extras.getFloat("ExtraLat");
        lng = extras.getFloat("ExtraLng");

        //add logger
        Log.d("username", username);
        Log.d("kelurahan", kelurahan);
        Log.d("latitude", lat.toString());
        Log.d("longitude", lng.toString());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = 16.0f; //This goes up to 21
        LatLng latLng = new LatLng(lat ,lng);
        mMap.addMarker(new MarkerOptions().position(latLng).title(username).snippet(kelurahan)).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));

        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }
    }
}
