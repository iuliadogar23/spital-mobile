package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum AdusDeLa {

    HOME(1, "Domiciliu"),
    HEALTH_UNIT(2, "Unitate sanitara"),
    PUBLIC_PLACE(3, "Loc public"),
    WORK_PLACE(4, "Loc munca"),
    OTHERS(5, "Alt");
    private final Integer id;

    private final String nume;

    AdusDeLa(Integer id, String name) {
        this.id = id;
        this.nume = name;
    }

    public Integer getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public static AdusDeLa findByName(String name)
    {
        for (AdusDeLa adusDeLa: AdusDeLa.values())
            if (adusDeLa.getNume().equals(name))
                return adusDeLa;
        return null;
    }

}
