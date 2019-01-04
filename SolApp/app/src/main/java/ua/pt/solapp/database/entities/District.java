package ua.pt.solapp.database.entities;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import ua.pt.solapp.database.converter.DBConverter;

@Entity
public class District {

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
    private List<DistrictData> data;


    public District(String owner, String country, List<DistrictData> data) {
        this.owner = owner;
        this.country = country;
        this.data = data;
    }

    // GETTERS:
    @NonNull
    public Long getId() { return id; }
    public String getOwner() { return owner; }
    public String getCountry() { return country; }

    @TypeConverters(DBConverter.class)
    public List<DistrictData> getData() {
        return data;
    }


    // SETTERS:
    public void setId(@NonNull Long id) { this.id = id; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setCountry(String country) { this.country = country; }

    @TypeConverters(DBConverter.class)
    public void setData(List<DistrictData> data) {
        this.data = data;
    }


}
