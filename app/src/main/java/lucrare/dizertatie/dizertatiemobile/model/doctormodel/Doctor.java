package lucrare.dizertatie.dizertatiemobile.model.doctormodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Doctor implements Serializable {

    @SerializedName("adresa")
    @Expose
    private Adresa adresa;
    @SerializedName("cnp")
    @Expose
    private String cnp;
    @SerializedName("cont")
    @Expose
    private Cont cont;
    @SerializedName("dataNasterii")
    @Expose
    private Integer dataNasterii;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nume")
    @Expose
    private String nume;
    @SerializedName("prenume")
    @Expose
    private String prenume;
    @SerializedName("specializare")
    @Expose
    private String specializare;
    @SerializedName("titlu")
    @Expose
    private String titlu;
    @SerializedName("blocOperator")
    @Expose
    private String blocOperator;

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Cont getCont() {
        return cont;
    }

    public void setCont(Cont cont) {
        this.cont = cont;
    }

    public Integer getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Integer dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getBlocOperator() {
        return blocOperator;
    }

    public void setBlocOperator(String blocOperator) {
        this.blocOperator = blocOperator;
    }
}
