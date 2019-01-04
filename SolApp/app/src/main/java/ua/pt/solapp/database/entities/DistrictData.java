package ua.pt.solapp.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class DistrictData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("idRegiao")
    @Expose
    private int idRegiao;

    @SerializedName("idAreaAviso")
    @Expose
    private String idAreaAviso;

    @SerializedName("idConcelho")
    @Expose
    private int idConcelho;

    @SerializedName("globalIdLocal")
    @Expose
    private int globalIdLocal;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("idDistrito")
    @Expose
    private int idDistrito;

    @SerializedName("local")
    @Expose
    private String local;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    public DistrictData(int idRegiao, String idAreaAviso, int idConcelho, int globalIdLocal, String latitude, int idDistrito, String local, String longitude) {
        this.idRegiao = idRegiao;
        this.idAreaAviso = idAreaAviso;
        this.idConcelho = idConcelho;
        this.globalIdLocal = globalIdLocal;
        this.latitude = latitude;
        this.idDistrito = idDistrito;
        this.local = local;
        this.longitude = longitude;
    }


    @NonNull
    public long getId() {
        return id;
    }
    public int getIdRegiao() { return idRegiao; }
    public String getIdAreaAviso() { return idAreaAviso; }
    public int getIdConcelho() { return idConcelho; }
    public int getGlobalIdLocal() { return globalIdLocal; }
    public String getLatitude() { return latitude; }
    public int getIdDistrito() { return idDistrito; }
    public String getLocal() { return local; }
    public String getLongitude() { return longitude; }



    public void setId(@NonNull long id) {
        this.id = id;
    }
    public void setIdRegiao(int idRegiao) { this.idRegiao = idRegiao; }
    public void setIdAreaAviso(String idAreaAviso) { this.idAreaAviso = idAreaAviso; }
    public void setIdConcelho(int idConcelho) { this.idConcelho = idConcelho; }
    public void setGlobalIdLocal(int globalIdLocal) { this.globalIdLocal = globalIdLocal; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public void setIdDistrito(int idDistrito) { this.idDistrito = idDistrito; }
    public void setLocal(String local) { this.local = local; }
    public void setLongitude(String longitude) { this.longitude = longitude; }


    @Override
    public String toString() {
        return "DistrictData{" +
                "id=" + id +
                ", idRegiao=" + idRegiao +
                ", idAreaAviso='" + idAreaAviso + '\'' +
                ", idConcelho=" + idConcelho +
                ", globalIdLocal=" + globalIdLocal +
                ", latitude='" + latitude + '\'' +
                ", idDistrito=" + idDistrito +
                ", local='" + local + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
