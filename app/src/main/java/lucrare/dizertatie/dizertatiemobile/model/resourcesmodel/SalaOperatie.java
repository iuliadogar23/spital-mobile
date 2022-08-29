package lucrare.dizertatie.dizertatiemobile.model.resourcesmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalaOperatie {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nrSala")
    @Expose
    private String nrSala;
    @SerializedName("blocOperator")
    @Expose
    private String blocOperator;
    @SerializedName("doctor")
    @Expose
    private Integer doctor;
    @SerializedName("oraIncepere")
    @Expose
    private Long oraIncepere;
    @SerializedName("durata")
    @Expose
    private Long durata;

    public SalaOperatie(Integer id, String status, String blocOperator, Integer doctor, Long oraIncepere, Long durata) {
        this.id = id;
        this.status = status;
        this.blocOperator = blocOperator;
        this.doctor = doctor;
        this.oraIncepere = oraIncepere;
        this.durata = durata;
    }

    public SalaOperatie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNrSala() {
        return nrSala;
    }

    public void setNrSala(String nrSala) {
        this.nrSala = nrSala;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBlocOperator() {
        return blocOperator;
    }

    public void setBlocOperator(String blocOperator) {
        this.blocOperator = blocOperator;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Long getOraIncepere() {
        return oraIncepere;
    }

    public void setOraIncepere(Long oraIncepere) {
        this.oraIncepere = oraIncepere;
    }

    public Long getDurata() {
        return durata;
    }

    public void setDurata(Long durata) {
        this.durata = durata;
    }
}
