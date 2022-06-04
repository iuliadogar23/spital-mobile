package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StarePacient {

    @SerializedName("av")
    @Expose
    private String av;
    @SerializedName("dataOra")
    @Expose
    private Integer dataOra;
    @SerializedName("frRes")
    @Expose
    private String frRes;
    @SerializedName("functiiVitale")
    @Expose
    private String functiiVitale;
    @SerializedName("gli")
    @Expose
    private String gli;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("puls")
    @Expose
    private String puls;
    @SerializedName("sato2")
    @Expose
    private String sato2;
    @SerializedName("starePacient")
    @Expose
    private String starePacient;
    @SerializedName("ta")
    @Expose
    private String ta;
    @SerializedName("temp")
    @Expose
    private String temp;

    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
    }

    public Integer getDataOra() {
        return dataOra;
    }

    public void setDataOra(Integer dataOra) {
        this.dataOra = dataOra;
    }

    public String getFrRes() {
        return frRes;
    }

    public void setFrRes(String frRes) {
        this.frRes = frRes;
    }

    public String getFunctiiVitale() {
        return functiiVitale;
    }

    public void setFunctiiVitale(String functiiVitale) {
        this.functiiVitale = functiiVitale;
    }

    public String getGli() {
        return gli;
    }

    public void setGli(String gli) {
        this.gli = gli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuls() {
        return puls;
    }

    public void setPuls(String puls) {
        this.puls = puls;
    }

    public String getSato2() {
        return sato2;
    }

    public void setSato2(String sato2) {
        this.sato2 = sato2;
    }

    public String getStarePacient() {
        return starePacient;
    }

    public void setStarePacient(String starePacient) {
        this.starePacient = starePacient;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

}
