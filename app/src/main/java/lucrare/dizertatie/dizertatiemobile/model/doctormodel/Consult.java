package lucrare.dizertatie.dizertatiemobile.model.doctormodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Consult implements Serializable {

    @SerializedName("doctorSolicitant")
    @Expose
    private Doctor doctorSolicitant;
    @SerializedName("doctorSolicitat")
    @Expose
    private Doctor doctorSolicitat;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mesajSolicitare")
    @Expose
    private String mesajSolicitare;
    @SerializedName("nrFisa")
    @Expose
    private Integer nrFisa;
    @SerializedName("oraPrezentarii")
    @Expose
    private Long oraPrezentarii;
    @SerializedName("oraSolicitarii")
    @Expose
    private Long oraSolicitarii;
    @SerializedName("recomandareConsult")
    @Expose
    private String recomandareConsult;
    @SerializedName("sectie")
    @Expose
    private String sectie;
    @SerializedName("status")
    @Expose
    private String status;

    public Doctor getDoctorSolicitant() {
        return doctorSolicitant;
    }

    public void setDoctorSolicitant(Doctor doctorSolicitant) {
        this.doctorSolicitant = doctorSolicitant;
    }

    public Doctor getDoctorSolicitat() {
        return doctorSolicitat;
    }

    public void setDoctorSolicitat(Doctor doctorSolicitat) {
        this.doctorSolicitat = doctorSolicitat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMesajSolicitare() {
        return mesajSolicitare;
    }

    public void setMesajSolicitare(String mesajSolicitare) {
        this.mesajSolicitare = mesajSolicitare;
    }

    public Integer getNrFisa() {
        return nrFisa;
    }

    public void setNrFisa(Integer nrFisa) {
        this.nrFisa = nrFisa;
    }

    public Long getOraPrezentarii() {
        return oraPrezentarii;
    }

    public void setOraPrezentarii(Long oraPrezentarii) {
        this.oraPrezentarii = oraPrezentarii;
    }

    public Long getOraSolicitarii() {
        return oraSolicitarii;
    }

    public void setOraSolicitarii(Long oraSolicitarii) {
        this.oraSolicitarii = oraSolicitarii;
    }

    public String getRecomandareConsult() {
        return recomandareConsult;
    }

    public void setRecomandareConsult(String recomandareConsult) {
        this.recomandareConsult = recomandareConsult;
    }

    public String getSectie() {
        return sectie;
    }

    public void setSectie(String sectie) {
        this.sectie = sectie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
