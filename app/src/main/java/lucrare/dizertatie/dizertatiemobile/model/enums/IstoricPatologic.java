package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum IstoricPatologic {

    CARDIAC(1, "Cardiace"),
    NEUROLOGICAL(2, "Neurologice"),
    RENAL(3, "Renale"),
    PULMONARY(4, "Pulmonare"),
    TBC(5, "TBC"),
    HEPATIC(6, "Hepatice"),
    GASTRIC(7, "Gastrice"),
    DIABETES(8, "Diabet zaharat"),
    INFECTIOUS_CONTAGIOUS(9, "Boli infectioase contagioase"),
    STD(10, "Boli cu transmitere sexuala"),
    OTHER(11, "Altele");

    private final Integer id;

    private final String nume;

    IstoricPatologic(Integer id, String name) {
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
