package ua.pt.solapp.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class WeatherData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("descIdWeatherTypeEN")
    @Expose
    private String descIdWeatherTypeEN;

    @SerializedName("descIdWeatherTypePT")
    @Expose
    private String descIdWeatherTypePT;

    @SerializedName("idWeatherType")
    @Expose
    private int idWeatherType;


    public WeatherData(String descIdWeatherTypeEN, String descIdWeatherTypePT, int idWeatherType) {
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
        this.descIdWeatherTypePT = descIdWeatherTypePT;
        this.idWeatherType = idWeatherType;
    }


    @NonNull
    public long getId() {
        return id;
    }
    public String getDescIdWeatherTypeEN() {
        return descIdWeatherTypeEN;
    }
    public int getIdWeatherType() {
        return idWeatherType;
    }
    public String getDescIdWeatherTypePT() {
        return descIdWeatherTypePT;
    }


    public void setId(@NonNull long id) {
        this.id = id;
    }
    public void setDescIdWeatherTypeEN(String descIdWeatherTypeEN) {
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
    }
    public void setDescIdWeatherTypePT(String descIdWeatherTypePT) {
        this.descIdWeatherTypePT = descIdWeatherTypePT;
    }
    public void setIdWeatherType(int idWeatherType) {
        this.idWeatherType = idWeatherType;
    }
}
