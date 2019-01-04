package ua.pt.solapp.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import ua.pt.solapp.database.converter.DBConverter;


@Entity
public class WeatherForecast {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    @SerializedName("owner")
    @Expose
    private String owner;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("data")
    @Expose
    private List<WeatherForecastData> data;

    @SerializedName("globalIdLocal")
    @Expose
    private int globalIdLocal;

    @SerializedName("dataUpdate")
    @Expose
    private String dataUpdate;

    private Date lastRefresh;


    public WeatherForecast(String owner, String country, List<WeatherForecastData> data, int globalIdLocal, String dataUpdate, Date lastRefresh) {
        this.owner = owner;
        this.country = country;
        this.data = data;
        this.globalIdLocal = globalIdLocal;
        this.dataUpdate = dataUpdate;
        this.lastRefresh = lastRefresh;
    }

    // GETTERS:
    @NonNull
    public long getId() { return id; }
    public String getOwner() { return owner; }
    public String getCountry() { return country; }
    public int getGlobalIdLocal() { return globalIdLocal; }
    public String getDataUpdate() { return dataUpdate; }
    public Date getLastRefresh() { return lastRefresh; }

    @TypeConverters(DBConverter.class)
    public List<WeatherForecastData> getData() {
        return data;
    }


    // SETTERS:
    public void setId(@NonNull long id) { this.id = id; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setCountry(String country) { this.country = country; }
    public void setGlobalIdLocal(int globalIdLocal) { this.globalIdLocal = globalIdLocal; }
    public void setDataUpdate(String dataUpdate) { this.dataUpdate = dataUpdate; }
    public void setLastRefresh(Date lastRefresh) { this.lastRefresh = lastRefresh; }

    @TypeConverters(DBConverter.class)
    public void setData(List<WeatherForecastData> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "WeatherForecast{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", country='" + country + '\'' +
                ", data=" + data.toString() +
                ", globalIdLocal=" + globalIdLocal +
                ", dataUpdate='" + dataUpdate + '\'' +
                ", lastRefresh=" + lastRefresh +
                '}';
    }
}
