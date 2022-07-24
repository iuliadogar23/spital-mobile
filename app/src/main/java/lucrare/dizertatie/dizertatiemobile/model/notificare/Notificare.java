package lucrare.dizertatie.dizertatiemobile.model.notificare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notificare {

    @SerializedName("dbName")
    @Expose
    private String dbName;
    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("dataOra")
    @Expose
    private String dataOra;
    @SerializedName("obiect")
    @Expose
    private String obiect;
    @SerializedName("mesaj")
    @Expose
    private String mesaj;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getDataOra() {
        return dataOra;
    }

    public void setDataOra(String dataOra) {
        this.dataOra = dataOra;
    }

    public String getObiect() {
        return obiect;
    }

    public void setObiect(String obiect) {
        this.obiect = obiect;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}
