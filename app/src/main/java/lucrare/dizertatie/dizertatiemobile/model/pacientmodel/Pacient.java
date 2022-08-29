package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pacient extends BaseObservable implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ultimaSchimbare")
    @Expose
    private Long ultimaSchimbare;
    @SerializedName("nume")
    @Expose
    private String nume;
    @SerializedName("prenume")
    @Expose
    private String prenume;
    @SerializedName("varsta")
    @Expose
    private String varsta;
    @SerializedName("dataNastere")
    @Expose
    private String dataNastere;
    @SerializedName("cnp")
    @Expose
    private String cnp;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("sange")
    @Expose
    private String sange;
    @SerializedName("alergic")
    @Expose
    private String alergic;
    @SerializedName("judet")
    @Expose
    private String judet;
    @SerializedName("localitate")
    @Expose
    private String localitate;
    @SerializedName("strada")
    @Expose
    private String strada;
    @SerializedName("nrBlScEtAp")
    @Expose
    private String nrBlScEtAp;
    @SerializedName("telefon")
    @Expose
    private String telefon;

    @Bindable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Bindable
    public Long getUltimaSchimbare() {
        return ultimaSchimbare;
    }

    public void setUltimaSchimbare(Long ultimaSchimbare) {
        this.ultimaSchimbare = ultimaSchimbare;
    }

    @Bindable
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Bindable
    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Bindable
    public String getVarsta() {
        return varsta;
    }

    public void setVarsta(String varsta) {
        this.varsta = varsta;
    }

    @Bindable
    public String getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    @Bindable
    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Bindable
    public String getSange() {
        return sange;
    }

    public void setSange(String sange) {
        this.sange = sange;
    }

    @Bindable
    public String getAlergic() {
        return alergic;
    }

    public void setAlergic(String alergic) {
        this.alergic = alergic;
    }

    @Bindable
    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    @Bindable
    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    @Bindable
    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    @Bindable
    public String getNrBlScEtAp() {
        return nrBlScEtAp;
    }

    public void setNrBlScEtAp(String nrBlScEtAp) {
        this.nrBlScEtAp = nrBlScEtAp;
    }

    @Bindable
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
