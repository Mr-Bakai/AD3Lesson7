package com.hfad.ad3lesson7.data.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.google.android.gms.maps.model.LatLng;
import com.hfad.ad3lesson7.converter.LatLngConverter;

import java.util.List;

@Entity
public class PolylineData {

    @PrimaryKey()
    private int id = 1;

    @TypeConverters(LatLngConverter.class)
    public  List<LatLng> latLngList;

    public List<LatLng> getLatLngList() {
        return latLngList;
    }

    public void setLatLngList(List<LatLng> latLngList) {
        this.latLngList = latLngList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
