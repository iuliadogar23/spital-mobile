package lucrare.dizertatie.dizertatiemobile.model.resourcesmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pat {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nrPat")
    @Expose
    private String nrPat;
    @SerializedName("blocOperator")
    @Expose
    private String blocOperator;
    @SerializedName("nrFisa")
    @Expose
    private Integer nrFisa;
    @SerializedName("aparatura")
    @Expose
    private Boolean aparatura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNrPat() {
        return nrPat;
    }

    public void setNrPat(String nrPat) {
        this.nrPat = nrPat;
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

    public Integer getNrFisa() {
        return nrFisa;
    }

    public void setNrFisa(Integer nrFisa) {
        this.nrFisa = nrFisa;
    }

    public Boolean getAparatura() {
        return aparatura;
    }

    public void setAparatura(Boolean aparatura) {
        this.aparatura = aparatura;
    }
}
