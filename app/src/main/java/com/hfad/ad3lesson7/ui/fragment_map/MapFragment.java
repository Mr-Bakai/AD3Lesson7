package com.hfad.ad3lesson7.ui.fragment_map;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.hfad.ad3lesson7.App;
import com.hfad.ad3lesson7.R;
import com.hfad.ad3lesson7.data.model.PolylineData;
import com.hfad.ad3lesson7.databinding.FragmentMapBinding;
import com.hfad.ad3lesson7.ui.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapFragment extends BaseFragment<FragmentMapBinding> implements
        OnMapReadyCallback,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMarkerClickListener {

    public static final int LOCATION_REQUEST_CODE = 101;
    private final List<LatLng> coordinationA = new ArrayList<>();
    private List<LatLng> coordinationR = new ArrayList<>();
    private GoogleMap map;

    public MapFragment(){}

    @Override
    protected FragmentMapBinding bind() {
        return FragmentMapBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!App.latLngRepository.getPolyline().isEmpty()) {
            List<PolylineData> listPolyline = App.latLngRepository.getPolyline();
            PolylineData polylineData = listPolyline.get(0);
            coordinationR = polylineData.getLatLngList();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.btn_hybrid:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            case R.id.btn_normal:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.btn_state_line:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.btn_poly_line:
                addPolylineOptions(coordinationA);
                PolylineData polylineData = new PolylineData();
                polylineData.setLatLngList(coordinationA);
                App.latLngRepository.addPolyline(polylineData);
                return true;

            case R.id.btn_draw:
                addPolylineOptions(coordinationR);
                return true;

            case R.id.btn_clear:
                map.clear();
                coordinationA.clear();
                coordinationR.clear();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Marker marker = map.addMarker(
                new MarkerOptions()
                        .title("ME")
                        .position(latLng)
                        .snippet("Bitch you are here")
                        .draggable(true)
        );
        marker.showInfoWindow();
        coordinationA.add(latLng);
    }

    private void addPolylineOptions(List<LatLng> coordination) {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.addAll(coordination);
        polylineOptions.width(13f);
        polylineOptions.color(Color.DKGRAY);
        map.addPolyline(polylineOptions);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(this);
        map.setOnMarkerClickListener(this);

        if (ActivityCompat.checkSelfPermission(
                Objects.requireNonNull(getContext()),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                &&
                ActivityCompat.checkSelfPermission(
                        getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity()), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            return;
        }
        map.setMyLocationEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED)
                if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getContext()),
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                }
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.remove();
        return false;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_options, menu);
    }
}