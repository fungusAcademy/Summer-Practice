package com.example.summerpractice;

//import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;

import android.os.Bundle;
import android.Manifest;
import android.widget.Toast;
import android.content.pm.PackageManager;
import android.location.Location;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MapsActivity extends AppCompatActivity
        implements OnMapReadyCallback, OnCameraIdleListener
{
    private static final float MIN_ZOOM = 10.0f;
    private static final float MAX_ZOOM = 18.0f;

    private static final LatLngBounds   VLADIVOSTOK        = new LatLngBounds(
            new LatLng(42.967996, 131.780831), new LatLng(43.241732, 132.039988));
    private static final CameraPosition VLADIVOSTOK_CAMERA = new CameraPosition.Builder()
            .target(new LatLng(43.116418, 131.882475)).zoom(MIN_ZOOM).bearing(0).tilt(0).build();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mMap = null;

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        mMap.setMinZoomPreference(MIN_ZOOM);
        mMap.setMaxZoomPreference(MAX_ZOOM);

        mMap.setLatLngBoundsForCameraTarget(VLADIVOSTOK);
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(VLADIVOSTOK_CAMERA));
    }

    private void enableMyLocation() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            // Permission to access the location is missing.
//            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
//                    Manifest.permission.ACCESS_FINE_LOCATION, true);
//        } else if (mMap != null) {
//            // Access to the location has been granted to the app.
//            mMap.setMyLocationEnabled(true);
//        }
    }

    @Override
    public void onCameraIdle() {}
}
