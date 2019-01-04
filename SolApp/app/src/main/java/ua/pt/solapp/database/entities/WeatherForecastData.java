package ua.pt.solapp.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class WeatherForecastData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("precipitaProb")
    @Expose
    private String precipitaProb;

    @SerializedName("tMin")
    @Expose
    private String tempMin;

    @SerializedName("tMax")
    @Expose
    private String tempMax;

    @SerializedName("predWindDir")
    @Expose
    private String predWindDir;

    @SerializedName("idWeatherType")
    @Expose
    private int idWeatherType;

    @SerializedName("classWindSpeed")
    @Expose
    private int classWindSpeed;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    @SerializedName("forecastDate")
    @Expose
    private String forecastDate;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    public WeatherForecastData(String precipitaProb, String tempMin, String tempMax, String predWindDir, int idWeatherType, int classWindSpeed, String longitude, String forecastDate, String latitude) {
        this.precipitaProb = precipitaProb;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.predWindDir = predWindDir;
        this.idWeatherType = idWeatherType;
        this.classWindSpeed = classWindSpeed;
        this.longitude = longitude;
        this.forecastDate = forecastDate;
        this.latitude = latitude;
    }


    @NonNull
    public long getId() { return id; }
    public String getPrecipitaProb() { return precipitaProb; }
    public String getPredWindDir() { return predWindDir; }
    public int getIdWeatherType() { return idWeatherType; }
    public int getClassWindSpeed() { return classWindSpeed; }
    public String getLongitude() { return longitude; }
    public String getForecastDate() { return forecastDate; }
    public String getLatitude() { return latitude; }
    public String getTempMin() {
        return tempMin;
    }
    public String getTempMax() {
        return tempMax;
    }



    public void setId(@NonNull long id) {
        this.id = id;
    }
    public void setPrecipitaProb(String precipitaProb) { this.precipitaProb = precipitaProb; }
    public void setPredWindDir(String predWindDir) { this.predWindDir = predWindDir; }
    public void setIdWeatherType(int idWeatherType) { this.idWeatherType = idWeatherType; }
    public void setClassWindSpeed(int classWindSpeed) { this.classWindSpeed = classWindSpeed; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public void setForecastDate(String forecastDate) { this.forecastDate = forecastDate; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }
    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }


    @Override
    public String toString() {
        return "WeatherForecastData{" +
                "id=" + id +
                ", precipitaProb='" + precipitaProb + '\'' +
                ", tempMin='" + tempMin + '\'' +
                ", tempMax='" + tempMax + '\'' +
                ", predWindDir='" + predWindDir + '\'' +
                ", idWeatherType=" + idWeatherType +
                ", classWindSpeed=" + classWindSpeed +
                ", longitude='" + longitude + '\'' +
                ", forecastDate='" + forecastDate + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
