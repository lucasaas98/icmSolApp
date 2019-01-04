package ua.pt.solapp.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class WindSpeedData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    @SerializedName("descClassWindSpeedDailyEN")
    @Expose
    private String descClassWindSpeedDailyEN;

    @SerializedName("descClassWindSpeedDailyPT")
    @Expose
    private String descClassWindSpeedDailyPT;

    @SerializedName("classWindSpeed")
    @Expose
    private String classWindSpeed;

    public WindSpeedData(String descClassWindSpeedDailyEN, String descClassWindSpeedDailyPT, String classWindSpeed) {
        this.descClassWindSpeedDailyEN = descClassWindSpeedDailyEN;
        this.descClassWindSpeedDailyPT = descClassWindSpeedDailyPT;
        this.classWindSpeed = classWindSpeed;
    }


    @NonNull
    public long getId() {
        return id;
    }
    public String getDescClassWindSpeedDailyEN() { return descClassWindSpeedDailyEN; }
    public String getDescClassWindSpeedDailyPT() { return descClassWindSpeedDailyPT; }
    public String getClassWindSpeed() { return classWindSpeed; }



    public void setId(@NonNull long id) {
        this.id = id;
    }
    public void setDescClassWindSpeedDailyEN(String descClassWindSpeedDailyEN) { this.descClassWindSpeedDailyEN = descClassWindSpeedDailyEN; }
    public void setDescClassWindSpeedDailyPT(String descClassWindSpeedDailyPT) { this.descClassWindSpeedDailyPT = descClassWindSpeedDailyPT; }
    public void setClassWindSpeed(String classWindSpeed) { this.classWindSpeed = classWindSpeed; }
}
