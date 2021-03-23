package com.hfad.ad3lesson7.frameworks.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.google.android.gms.maps.model.LatLng;
import com.hfad.ad3lesson7.data.model.PolylineData;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface LatLngSDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPolyline(PolylineData polylineData);

    @Query("SELECT * FROM polylinedata")
    List<PolylineData> getAll();

    @Query("DELETE  FROM polylinedata")
    void deleteAll();

//    @Query("DELETE FROM polylinedata WHERE latLngList = :latLngMap")
//    void deleteLatLng(LatLng latLngMap);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListPolyline(ArrayList<PolylineData> listPolyline);

    @Delete
    void deletePolyline(PolylineData polylineData);

    @Update
    void updatePolyline(PolylineData polylineData);
}