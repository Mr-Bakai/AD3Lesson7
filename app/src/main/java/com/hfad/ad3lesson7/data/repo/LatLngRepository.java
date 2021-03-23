package com.hfad.ad3lesson7.data.repo;
import com.hfad.ad3lesson7.data.model.PolylineData;
import com.hfad.ad3lesson7.data.source.local.LatLngLocalSource;
import java.util.List;

public class LatLngRepository {

    private final LatLngLocalSource latLngLocalSource;

    public LatLngRepository(LatLngLocalSource latLngLocalSource) {
        this.latLngLocalSource = latLngLocalSource;}


    public void addPolyline(PolylineData film){
        latLngLocalSource.addPolyline(film);}


    public List<PolylineData> getPolyline(){
        return latLngLocalSource.getPolyline();}
}
