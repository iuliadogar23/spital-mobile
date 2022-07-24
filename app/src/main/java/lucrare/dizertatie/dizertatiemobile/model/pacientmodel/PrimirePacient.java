package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PrimirePacient implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("preluatDe")
    @Expose
    private String preluatDe;
    @SerializedName("dataOra")
    @Expose
    private Integer dataOra;
    @SerializedName("oraPrimConsult")
    @Expose
    private Integer oraPrimConsult;
    @SerializedName("motivulPrezentarii")
    @Expose
    private String motivulPrezentarii;
    @SerializedName("adusDe")
    @Expose
    private String adusDe;
    @SerializedName("adusDeLa")
    @Expose
    private String adusDeLa;
    @SerializedName("nrFisaExterna")
    @Expose
    private String nrFisaExterna;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreluatDe() {
        return preluatDe;
    }

    public void setPreluatDe(String preluatDe) {
        this.preluatDe = preluatDe;
    }

    public Integer getDataOra() {
        return dataOra;
    }

    public void setDataOra(Integer dataOra) {
        this.dataOra = dataOra;
    }

    public Integer getOraPrimConsult() {
        return oraPrimConsult;
    }

    public void setOraPrimConsult(Integer oraPrimConsult) {
        this.oraPrimConsult = oraPrimConsult;
    }

    public String getMotivulPrezentarii() {
        return motivulPrezentarii;
    }

    public void setMotivulPrezentarii(String motivulPrezentarii) {
        this.motivulPrezentarii = motivulPrezentarii;
    }

    public String getAdusDe() {
        return adusDe;
    }

    public void setAdusDe(String adusDe) {
        this.adusDe = adusDe;
    }

    public String getAdusDeLa() {
        return adusDeLa;
    }

    public void setAdusDeLa(String adusDeLa) {
        this.adusDeLa = adusDeLa;
    }

    public String getNrFisaExterna() {
        return nrFisaExterna;
    }

    public void setNrFisaExterna(String nrFisaExterna) {
        this.nrFisaExterna = nrFisaExterna;
    }

}
