package lucrare.dizertatie.dizertatiemobile.model.doctormodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Adresa implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("judet")
    @Expose
    private String judet;
    @SerializedName("localitate")
    @Expose
    private String localitate;
    @SerializedName("nrBlScEtAp")
    @Expose
    private String nrBlScEtAp;
    @SerializedName("strada")
    @Expose
    private String strada;
    @SerializedName("tara")
    @Expose
    private String tara;
    @SerializedName("telefon")
    @Expose
    private String telefon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getNrBlScEtAp() {
        return nrBlScEtAp;
    }

    public void setNrBlScEtAp(String nrBlScEtAp) {
        this.nrBlScEtAp = nrBlScEtAp;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
