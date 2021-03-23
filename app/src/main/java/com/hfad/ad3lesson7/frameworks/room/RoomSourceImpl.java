package com.hfad.ad3lesson7.frameworks.room;
import com.hfad.ad3lesson7.App;
import com.hfad.ad3lesson7.data.model.PolylineData;
import com.hfad.ad3lesson7.data.source.local.LatLngLocalSource;
import java.util.List;

public class RoomSourceImpl implements LatLngLocalSource {

    @Override
    public void addPolyline(PolylineData polylineData) {
        App.roomDb.latLngDao().insertPolyline(polylineData);
    }

    @Override
    public List<PolylineData> getPolyline() {
        return App.roomDb.latLngDao().getAll();
    }
}
