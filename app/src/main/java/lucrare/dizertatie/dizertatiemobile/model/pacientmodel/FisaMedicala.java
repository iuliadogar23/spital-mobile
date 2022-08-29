package lucrare.dizertatie.dizertatiemobile.model.pacientmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.enums.IstoricPatologic;
import lucrare.dizertatie.dizertatiemobile.model.enums.Procedura;
import lucrare.dizertatie.dizertatiemobile.model.enums.Triaj;

public class FisaMedicala implements Serializable {


    @SerializedName("nrFisa")
    @Expose
    private Integer nrFisa;
    @SerializedName("pacient")
    @Expose
    private Pacient pacient;
    @SerializedName("primirePacient")
    @Expose
    private PrimirePacient primirePacient;
    @SerializedName("motivulPrezentarii")
    @Expose
    private String motivulPrezentarii;
    @SerializedName("starePacient")
    @Expose
    private List<StarePacient> starePacient = null;
    @SerializedName("scorGlagow")
    @Expose
    private List<ScorGlagow> scorGlagow = null;
    @SerializedName("scorNaca")
    @Expose
    private String scorNaca;
    @SerializedName("antecedentePatologice")
    @Expose
    private List<IstoricPatologic> antecedentePatologice = null;
    @SerializedName("anamneza")
    @Expose
    private String anamneza;
    @SerializedName("observatiiAnamneza")
    @Expose
    private String observatiiAnamneza;
    @SerializedName("tratamentDomiciliu")
    @Expose
    private String tratamentDomiciliu;
    @SerializedName("greutate")
    @Expose
    private String greutate;
    @SerializedName("talie")
    @Expose
    private String talie;
    @SerializedName("triaj")
    @Expose
    private List<Triaj> triaj = null;
    @SerializedName("observatiiTriaj")
    @Expose
    private String observatiiTriaj;
    @SerializedName("detaliiTriaj")
    @Expose
    private String detaliiTriaj;
    @SerializedName("alteAfectiuni")
    @Expose
    private String alteAfectiuni;
    @SerializedName("proceduri")
    @Expose
    private List<Procedura> proceduri = null;
    @SerializedName("ekg")
    @Expose
    private String ekg;
    @SerializedName("radiologie")
    @Expose
    private String radiologie;
    @SerializedName("ecografie")
    @Expose
    private String ecografie;
    @SerializedName("examenUrina")
    @Expose
    private String examenUrina;
    @SerializedName("analize")
    @Expose
    private List<Analize> analize = null;
    @SerializedName("recomandare")
    @Expose
    private String recomandare;
    @SerializedName("codDG")
    @Expose
    private String codDG;
    @SerializedName("starePacientEvaluare")
    @Expose
    private String starePacientEvaluare;
    @SerializedName("oraEvaluare")
    @Expose
    private Integer oraEvaluare;
    @SerializedName("decizie")
    @Expose
    private String decizie;
    @SerializedName("doctorAsignat")
    @Expose
    private Integer doctorAsignat;

    public Integer getNrFisa() {
        return nrFisa;
    }

    public void setNrFisa(Integer nrFisa) {
        this.nrFisa = nrFisa;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public PrimirePacient getPrimirePacient() {
        return primirePacient;
    }

    public void setPrimirePacient(PrimirePacient primirePacient) {
        this.primirePacient = primirePacient;
    }

    public String getMotivulPrezentarii() {
        return motivulPrezentarii;
    }

    public void setMotivulPrezentarii(String motivulPrezentarii) {
        this.motivulPrezentarii = motivulPrezentarii;
    }

    public List<StarePacient> getStarePacient() {
        return starePacient;
    }

    public void setStarePacient(List<StarePacient> starePacient) {
        this.starePacient = starePacient;
    }

    public List<ScorGlagow> getScorGlagow() {
        return scorGlagow;
    }

    public void setScorGlagow(List<ScorGlagow> scorGlagow) {
        this.scorGlagow = scorGlagow;
    }

    public String getScorNaca() {
        return scorNaca;
    }

    public void setScorNaca(String scorNaca) {
        this.scorNaca = scorNaca;
    }

    public List<IstoricPatologic> getAntecedentePatologice() {
        return antecedentePatologice;
    }

    public void setAntecedentePatologice(List<IstoricPatologic> antecedentePatologice) {
        this.antecedentePatologice = antecedentePatologice;
    }

    public String getAnamneza() {
        return anamneza;
    }

    public void setAnamneza(String anamneza) {
        this.anamneza = anamneza;
    }

    public String getObservatiiAnamneza() {
        return observatiiAnamneza;
    }

    public void setObservatiiAnamneza(String observatiiAnamneza) {
        this.observatiiAnamneza = observatiiAnamneza;
    }

    public String getTratamentDomiciliu() {
        return tratamentDomiciliu;
    }

    public void setTratamentDomiciliu(String tratamentDomiciliu) {
        this.tratamentDomiciliu = tratamentDomiciliu;
    }

    public String getGreutate() {
        return greutate;
    }

    public void setGreutate(String greutate) {
        this.greutate = greutate;
    }

    public String getTalie() {
        return talie;
    }

    public void setTalie(String talie) {
        this.talie = talie;
    }

    public List<Triaj> getTriaj() {
        return triaj;
    }

    public void setTriaj(List<Triaj> triaj) {
        this.triaj = triaj;
    }

    public String getObservatiiTriaj() {
        return observatiiTriaj;
    }

    public void setObservatiiTriaj(String observatiiTriaj) {
        this.observatiiTriaj = observatiiTriaj;
    }

    public String getDetaliiTriaj() {
        return detaliiTriaj;
    }

    public void setDetaliiTriaj(String detaliiTriaj) {
        this.detaliiTriaj = detaliiTriaj;
    }

    public String getAlteAfectiuni() {
        return alteAfectiuni;
    }

    public void setAlteAfectiuni(String alteAfectiuni) {
        this.alteAfectiuni = alteAfectiuni;
    }

    public List<Procedura> getProceduri() {
        return proceduri;
    }

    public void setProceduri(List<Procedura> proceduri) {
        this.proceduri = proceduri;
    }

    public String getEkg() {
        return ekg;
    }

    public void setEkg(String ekg) {
        this.ekg = ekg;
    }

    public String getRadiologie() {
        return radiologie;
    }

    public void setRadiologie(String radiologie) {
        this.radiologie = radiologie;
    }

    public String getEcografie() {
        return ecografie;
    }

    public void setEcografie(String ecografie) {
        this.ecografie = ecografie;
    }

    public String getExamenUrina() {
        return examenUrina;
    }

    public void setExamenUrina(String examenUrina) {
        this.examenUrina = examenUrina;
    }

    public List<Analize> getAnalize() {
        return analize;
    }

    public void setAnalize(List<Analize> analize) {
        this.analize = analize;
    }

    public String getRecomandare() {
        return recomandare;
    }

    public void setRecomandare(String recomandare) {
        this.recomandare = recomandare;
    }

    public String getCodDG() {
        return codDG;
    }

    public void setCodDG(String codDG) {
        this.codDG = codDG;
    }

    public String getStarePacientEvaluare() {
        return starePacientEvaluare;
    }

    public void setStarePacientEvaluare(String starePacientEvaluare) {
        this.starePacientEvaluare = starePacientEvaluare;
    }

    public Integer getOraEvaluare() {
        return oraEvaluare;
    }

    public void setOraEvaluare(Integer oraEvaluare) {
        this.oraEvaluare = oraEvaluare;
    }

    public String getDecizie() {
        return decizie;
    }

    public void setDecizie(String decizie) {
        this.decizie = decizie;
    }

    public Integer getDoctorAsignat() {
        return doctorAsignat;
    }

    public void setDoctorAsignat(Integer doctorAsignat) {
        this.doctorAsignat = doctorAsignat;
    }
}
