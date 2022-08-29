package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum FunctiiVitale {

    DEAD(1, "Decedat"),
    STOP_CR(2, "Stop cardiorespirator"),
    RESUSCITATE(3, "Cu manevra de resuscitare in curs de desfasurare"),
    TRAUMA(4, "Trauma");

    private final Integer id;

    private final String nume;

    FunctiiVitale(Integer id, String name) {
        this.id = id;
        this.nume = name;
    }

    public Integer getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public static FunctiiVitale getByNume(String description)
    {
        for (FunctiiVitale f: FunctiiVitale.values())
            if (f.getNume().equals(description))
                return f;
        return null;
    }

}
