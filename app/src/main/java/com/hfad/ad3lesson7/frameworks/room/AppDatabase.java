package com.hfad.ad3lesson7.frameworks.room;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.hfad.ad3lesson7.data.model.PolylineData;
import com.hfad.ad3lesson7.frameworks.room.dao.LatLngSDao;

@Database(entities = {PolylineData.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LatLngSDao latLngDao();
}