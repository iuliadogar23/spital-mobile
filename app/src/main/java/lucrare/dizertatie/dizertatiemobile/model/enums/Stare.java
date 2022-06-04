package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum Stare {

    IMPROVED(1, "Ameliorat"),
    STATIONARY(2, "Stationar"),
    AGRAVATED(3, "Agravat"),
    DECEASED(4, "Decedat");

    private final Integer id;
    private final String nume;

    Stare(Integer id, String name) {
        this.id = id;
        this.nume = name;
    }

    public Integer getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

}
