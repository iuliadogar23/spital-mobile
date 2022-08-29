package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScorGlagow {

    @SerializedName("deschidereaOchilor")
    @Expose
    private String deschidereaOchilor;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("raspunsMotor")
    @Expose
    private String raspunsMotor;
    @SerializedName("raspunsVerbal")
    @Expose
    private String raspunsVerbal;
    @SerializedName("total")
    @Expose
    private Integer total;

    public ScorGlagow(Integer id, String deschidereaOchilor, String raspunsMotor, String raspunsVerbal, Integer total) {
        this.deschidereaOchilor = deschidereaOchilor;
        this.id = id;
        this.raspunsMotor = raspunsMotor;
        this.raspunsVerbal = raspunsVerbal;
        this.total = total;
    }

    public ScorGlagow() {
    }

    public String getDeschidereaOchilor() {
        return deschidereaOchilor;
    }

    public void setDeschidereaOchilor(String deschidereaOchilor) {
        this.deschidereaOchilor = deschidereaOchilor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaspunsMotor() {
        return raspunsMotor;
    }

    public void setRaspunsMotor(String raspunsMotor) {
        this.raspunsMotor = raspunsMotor;
    }

    public String getRaspunsVerbal() {
        return raspunsVerbal;
    }

    public void setRaspunsVerbal(String raspunsVerbal) {
        this.raspunsVerbal = raspunsVerbal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}