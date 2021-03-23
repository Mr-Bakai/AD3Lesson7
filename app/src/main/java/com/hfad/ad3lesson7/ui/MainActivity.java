package com.hfad.ad3lesson7.ui;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.hfad.ad3lesson7.R;
import com.hfad.ad3lesson7.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
//        setUpListeners();

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }
//    private void setUpListeners() {
//        ui.btnHybird.setOnClickListener(v -> {
//            map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//        });
//
//        ui.btnNormal.setOnClickListener(v -> {
//            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        });
//
//        ui.btnStateLine.setOnClickListener(v -> {
//            map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//        });
//
//        ui.btnPolyLine.setOnClickListener(v -> {
//
//            PolylineOptions polylineOptions = new PolylineOptions();
//            polylineOptions.addAll(coordinations);
//            polylineOptions.width(13f);
//            polylineOptions.color(Color.DKGRAY);
//            map.addPolyline(polylineOptions);
//
//            polyline = map.addPolyline(
//                    new PolylineOptions()
//                            .clickable(true)
//                            .addAll(coordinations));
//            polyline.setTag("A");
//        });
//
//        ui.btnDraw.setOnClickListener( v -> {
//            stylePolyline(polyline);
//        });
//    }
//
//
//    private void stylePolyline(Polyline polyline) {
//        String type = "";
//        // Get the data object stored with the polyline.
//        if (polyline.getTag() != null) {
//            type = polyline.getTag().toString();
//        }
//
//        switch (type) {
//            // If no type is given, allow the API to use the default.
//            case "A":
//                // Use a custom bitmap as the cap at the start of the line.
//
//                PolylineOptions polylineOptions = new PolylineOptions();
//                polylineOptions.addAll(polyline.getPoints());
//                polylineOptions.width(13f);
//                polylineOptions.color(Color.DKGRAY);
//                map.addPolyline(polylineOptions);
//                break;
//
//            case "B":
//                // Use a round cap at the start of the line.
//                polyline.setStartCap(new RoundCap());
//                break;
//        }
//
//        polyline.setEndCap(new RoundCap());
//        polyline.setJointType(JointType.ROUND);
//    }
//
//    @Override
//    public void onMapClick(LatLng latLng) {
//        MarkerOptions markerOp = new MarkerOptions();
//        markerOp.title("Me");
//        markerOp.position(latLng);
//        markerOp.draggable(true);
//        map.addMarker(markerOp);
//        coordinations.add(latLng);
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        map = googleMap;
//        map.setOnMapClickListener(this);
//        map.setOnMarkerClickListener(this);
//
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED
//                &&
//                ActivityCompat.checkSelfPermission(
//                        this,
//                        Manifest.permission.ACCESS_COARSE_LOCATION
//                ) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
//            return;
//        }
//        map.setMyLocationEnabled(true);
////        position();
//    }
//
//    private void position() {
//        CameraPosition position =
//                CameraPosition
//                        .builder()
//                        .target(new LatLng(42.9198345, 74.5091569))
//                        .zoom(16.13f)
//                        .build();
//
//        map.animateCamera(CameraUpdateFactory.newCameraPosition(position), 4000, new GoogleMap.CancelableCallback() {
//            @Override
//            public void onFinish() {
//                Toast.makeText(MainActivity.this, "FINISH", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancel() {
//            }
//        });
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == LOCATION_REQUEST_CODE) {
//            if (grantResults.length > 0 &&
//                    grantResults[0] == PackageManager.PERMISSION_GRANTED)
//                if (ActivityCompat.checkSelfPermission(this,
//                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                    map.setMyLocationEnabled(true);
//                }
//        }
//    }
//
//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        marker.remove();
//        return false;
//    }
}