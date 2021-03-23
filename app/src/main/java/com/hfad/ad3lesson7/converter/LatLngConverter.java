package com.hfad.ad3lesson7.converter;
import androidx.room.TypeConverter;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class LatLngConverter {
    Gson gson = new Gson();
    @TypeConverter
    public List<LatLng> stringToLatLngList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<LatLng>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String latLngListToString(List<LatLng> latLng) {
        return gson.toJson(latLng);
    }
}