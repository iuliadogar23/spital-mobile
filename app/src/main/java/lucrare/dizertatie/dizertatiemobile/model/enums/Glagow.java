package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum Glagow {
    EYES_SPONTANEOUS("Deschiderea ochilor", "Spontana", 4),
    EYES_VERBAL_STIMULATION("Deschiderea ochilor", "La stimulare verbala", 3),
    EYES_PAINFUL_STIMULATION("Deschiderea ochilor", "La stimulare dureroasa", 2),
    EYES_NO_REPLY("Deschiderea ochilor", "Fara raspuns", 1),
    MOTOR_ON_DEMAND("Raspuns motor", "La cerere", 6),
    MOTOR_LOCALIZE_TO_HARDNESS("Raspuns motor", "Localizeaza la durere", 5),
    MOTOR_WITHDRAW_AT_PAIN("Raspuns motor", "Retrage la durere", 4),
    MOTOR_FLEX_TO_PAIN("Raspuns motor", "Flexie la durere", 3),
    MOTOR_STRETCH_AT_PAIN("Raspuns motor", "Extensie la durere", 2),
    MOTOR_NO_RETURN("Raspuns motor", "Fara raspuns", 1),
    VERBAL_ORIENTED("Raspuns verbal", "Orientat", 5),
    VERBAL_CONFUSED("Raspuns verbal", "Confuz", 4),
    VERBAL_WORDS_WITHOUT_MEANING("Raspuns verbal", "Cuvinte fara sens", 3),
    VERBAL_NOISES("Raspuns verbal", "Zgomote", 2),
    NO_VERBAL("Raspuns verbal", "Fara raspuns", 1);

    private final String categorie;
    private final String descriereSeveritate;
    private final Integer severitate;

    Glagow(String category, String severityExplained, Integer severity) {
        this.categorie = category;
        this.descriereSeveritate = severityExplained;
        this.severitate = severity;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescriereSeveritate() {
        return descriereSeveritate;
    }

    public Integer getSeveritate() {
        return severitate;
    }

    public static Glagow findBySeverityDescription(String severityDescription)
    {
        for (Glagow g: Glagow.values())
        {
            if (g.getDescriereSeveritate().equals(severityDescription))
                return g;
        }
        return null;
    }
}
