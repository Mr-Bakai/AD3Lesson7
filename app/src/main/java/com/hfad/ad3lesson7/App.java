package com.hfad.ad3lesson7;

import android.app.Application;

import androidx.room.Room;

import com.hfad.ad3lesson7.data.repo.LatLngRepository;
import com.hfad.ad3lesson7.frameworks.room.AppDatabase;
import com.hfad.ad3lesson7.frameworks.room.RoomSourceImpl;

public class App extends Application {

    public static LatLngRepository latLngRepository;
    public static AppDatabase roomDb;

    @Override
    public void onCreate() {
        super.onCreate();
        roomDb = Room.databaseBuilder(
                this,
                AppDatabase.class,
                "app_database"
        )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        latLngRepository = new LatLngRepository(new RoomSourceImpl());
    }
}
