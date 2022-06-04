package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum AdusDe {

    SAJ(1, "SAJ"),
    SMURD(2, "SMURD"),
    ON_THEIR_OWN(3, "Mijloace proprii"),
    OTHERS(4, "Alt");

    private final Integer id;

    private final String nume;

    AdusDe(Integer id, String name) {
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
