package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pacient implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ultimaSchimbare")
    @Expose
    private Integer ultimaSchimbare;
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
    private Integer dataNastere;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUltimaSchimbare() {
        return ultimaSchimbare;
    }

    public void setUltimaSchimbare(Integer ultimaSchimbare) {
        this.ultimaSchimbare = ultimaSchimbare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getVarsta() {
        return varsta;
    }

    public void setVarsta(String varsta) {
        this.varsta = varsta;
    }

    public Integer getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Integer dataNastere) {
        this.dataNastere = dataNastere;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSange() {
        return sange;
    }

    public void setSange(String sange) {
        this.sange = sange;
    }

    public String getAlergic() {
        return alergic;
    }

    public void setAlergic(String alergic) {
        this.alergic = alergic;
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

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNrBlScEtAp() {
        return nrBlScEtAp;
    }

    public void setNrBlScEtAp(String nrBlScEtAp) {
        this.nrBlScEtAp = nrBlScEtAp;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
