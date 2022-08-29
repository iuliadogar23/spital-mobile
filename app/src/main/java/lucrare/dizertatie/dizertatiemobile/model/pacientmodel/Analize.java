package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Calendar;

public class Analize implements Serializable {

    @SerializedName("denumire")
    @Expose
    private String denumire;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ora")
    @Expose
    private Long ora;
    @SerializedName("valoare")
    @Expose
    private String valoare;

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOra() {
        return ora;
    }

    public void setOra(Long ora) {
        this.ora = ora;
    }

    public String getValoare() {
        return valoare;
    }

    public void setValoare(String valoare) {
        this.valoare = valoare;
    }

    public Analize(String denumire, String valoare) {
        this.denumire = denumire;
        this.ora = Calendar.getInstance().getTimeInMillis();
        this.valoare = valoare;
    }

    public Analize() {
    }
}
