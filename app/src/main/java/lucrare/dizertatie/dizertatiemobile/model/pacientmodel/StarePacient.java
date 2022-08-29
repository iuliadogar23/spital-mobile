package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lucrare.dizertatie.dizertatiemobile.model.enums.Stare;

public class StarePacient extends BaseObservable implements Serializable {

    @SerializedName("av")
    @Expose
    private String av;
    @SerializedName("dataOra")
    @Expose
    private Long dataOra;
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

    @Bindable
    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
    }

    @Bindable
    public Long getDataOra() {
        return dataOra;
    }

    public void setDataOra(Long dataOra) {
        this.dataOra = dataOra;
    }

    @Bindable
    public String getFrRes() {
        return frRes;
    }

    public void setFrRes(String frRes) {
        this.frRes = frRes;
    }

    @Bindable
    public String getFunctiiVitale() {
        return functiiVitale;
    }

    public void setFunctiiVitale(String functiiVitale) {
        this.functiiVitale = functiiVitale;
    }

    @Bindable
    public String getGli() {
        return gli;
    }

    public void setGli(String gli) {
        this.gli = gli;
    }

    @Bindable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Bindable
    public String getPuls() {
        return puls;
    }

    public void setPuls(String puls) {
        this.puls = puls;
    }

    @Bindable
    public String getSato2() {
        return sato2;
    }

    public void setSato2(String sato2) {
        this.sato2 = sato2;
    }

    @Bindable
    public String getStarePacient() {
        return starePacient;
    }

    public void setStarePacient(String starePacient) {
        this.starePacient = starePacient;
    }

    @Bindable
    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    @Bindable
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

}
