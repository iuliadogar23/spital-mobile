package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum ScorNaca {

    NACA0("Fara nici o leziune sau afectiune"),
    NACA1("Afectiune sau leziune minora ce nu necesita tratament medical"),
    NACA2("Afectiune sau leziune care necesita evaluare si tratament ambulatoriu dar nu necesita internare"),
    NACA3("Afectiune sau leziune care necesita internare in spital"),
    NACA4("Afectiune sau leziune care poate influenta functiile vitale"),
    NACA5("Afectiune sau leziune care determina un risc vital"),
    NACA6("Afectiune sau leziune care determina un risc vital stare dupa stop cardiorespirator resuscitat"),
    NACA7("Afectiune sau leziune care determinä decesul (cu sau fara incercare de resuscitare)");

    private final String descriere;

    ScorNaca(String description) {
        this.descriere = description;
    }

    public String getDescriere() {
        return descriere;
    }

    public static ScorNaca getByDescription(String description)
    {
        for(ScorNaca n: ScorNaca.values())
            if (n.getDescriere().equals(description))
                return n;
        return null;
    }

}
