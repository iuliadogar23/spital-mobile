package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum Triaj {

    FEVER(1,"General","Febra"),
    ASTHENIA(2,"General","Astenie"),
    DIZZINESS(3,"General","Ameteli"),
    RESPIRATORY_TRACT_AFFECTED(4,"Arsuri","Cai respiratorii afectate"),
    FLAME(5,"Arsuri","Flacara"),
    SOLID(6,"Arsuri","Solid"),
    LIQUID(7,"Arsuri","Lichid"),
    VAPOUR_GAS(8,"Arsuri","Vapori/gaz"),
    CHEMICAL(9,"Arsuri","Chimic"),
    DEPRESSION(10,"Psihiatric","Depresie"),
    BEHAVIOURAL_DISORDERS(11,"Psihiatric","Tulb. comport."),
    SUICIDE(12,"Psihiatric","Suicid"),
    HALLUCINATIONS(13,"Psihiatric","Halucinatii"),
    DELIRIUM(14,"Psihiatric","Delir"),
    CONVULSION(15,"Neurologic","Convulsii"),
    MYOCLONUS(16,"Neurologic","Mioclonii"),
    HEADACHE(17,"Neurologic","Cefalee"),
    PARALYSIS(18,"Neurologic","Paralizie"),
    HOT(19,"Tegumente","Calde"),
    COLD(20,"Tegumente","Reci"),
    WET(21,"Tegumente","Umede"),
    PALE(22,"Tegumente","Palide"),
    CYANOTIC(23,"Tegumente","Cianotice"),
    JAUDICE(24,"Tegumente","Icterice"),
    ECCHYMOSIS(25,"Tegumente","Echimoze"),
    RASH(26,"Tegumente","Eruptii"),
    ITCHING(27,"Tegumente","Prurit"),
    BURNS(28,"Tegumente","Arsuri"),
    ACCIDENTAL_LOSS_OF_VISION(29, "Ochi", "Pierderea vederii"),
    VISUAL_DISORDER(30, "Ochi", "Tulburari de vedere"),
    INTRAOCULAR_STRAIN_BODY(31, "Ochi", "Corp strain intraocular"),
    OTHER_OCULAR_MANIFESTATIONS(32, "Ochi", "Alte manifestari oculare"),
    CHEST_PAIN(33, "Torace-respiratie", "Durere toracica"),
    DYSPNEA(34, "Torace-respiratie", "Dispnee"),
    HAEMOPTYSIS(35, "Torace-respiratie", "Hemoptizie"),
    COUGH(36, "Torace-respiratie", "Tuse"),
    EXPECTORATION(37, "Torace-respiratie", "Expectoratie"),
    GASPING(38, "Gastro-intestinal", "Greata"),
    VOMITING(39, "Gastro-intestinal", "Voma"),
    DISTURBANCE_TRANZIT(40, "Gastro-intestinal", "Tulburari transit"),
    RETORTION(41, "Gastro-intestinal", "Rectoragie"),
    MELENA(42, "Gastro-intestinal", "Melena"),
    HEMATEMESIS(43, "Gastro-intestinal", "Hematemeza"),
    ABDOMINAL_PAIN(44, "Gastro-intestinal", "Dureri abdominale"),
    EMOTIONAL_DISORDERS(45, "Genito-urinar", "Tulburari mictionale"),
    DYSURIA(46, "Genito-urinar", "Disurie"),
    POLAKIURIA(47, "Genito-urinar", "Polakiurie"),
    OLIGURIA(48, "Genito-urinar", "Oligurie"),
    HEMATURIA(49, "Genito-urinar", "Hematurie"),
    VAGINAL_BLEEDING(50, "Genito-urinar", "Sangerare vaginala"),
    PREGNANCY(51, "Genito-urinar", "Sarcina"),
    INFLAMMATION(52, "Ap. locomotor", "Inflamatie"),
    TUEFACTION(53, "Ap. locomotor", "Tumefactie"),
    PAIN(54, "Ap. locomotor", "Durere"),
    FUNCTIONAL(55, "Ap. locomotor", "Imp. funct.");

    private final Integer id;

    private final String categorie;

    private final String nume;

    Triaj(Integer id, String category, String name) {
        this.id = id;
        this.categorie = category;
        this.nume = name;
    }

    public Integer getId() {
        return id;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getNume() {
        return nume;
    }

}
