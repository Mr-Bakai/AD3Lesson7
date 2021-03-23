package com.hfad.ad3lesson7.data.source.local;
import com.hfad.ad3lesson7.data.model.PolylineData;
import java.util.List;

public interface LatLngLocalSource {
    void addPolyline(PolylineData polylineData);
    List<PolylineData> getPolyline();
}
