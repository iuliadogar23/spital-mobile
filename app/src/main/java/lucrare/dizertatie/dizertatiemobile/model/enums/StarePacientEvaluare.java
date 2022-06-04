package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum StarePacientEvaluare {
    EXAMINATION("Examinare"),
    TREATMENT("Tratament"),
    CHECK_IN("Internare"),
    TRANSFERRED("Transferat"),
    RECOMMENDATION("Recomandari");

    private final String nume;

    StarePacientEvaluare(String name) {
        this.nume = name;
    }

    public String getNume() {
        return nume;
    }
}
