package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum Procedura {

    COLOANA_CERVICALA_R(1, "Radiologice", "Coloana cervicala"),
    COLOANA_DORSALA(2, "Radiologice", "Coloana dorsala"),
    COLOANA_LOMBARA(3, "Radiologice", "Coloana lombara"),
    TORACE_R(4, "Radiologice", "Torace"),
    STERN(5, "Radiologice", "Stern"),
    BAZIN(6, "Radiologice", "Bazin"),
    ABDOMEN_R(7, "Radiologice", "Abdomen"),
    MEMBRU_SUPERIOR(8, "Radiologice", "Membru superior"),
    MEMBRU_INFERIOR(9, "Radiologice", "Membru inferior"),
    ALTE_R(10, "Radiologice", "Alte"),
    CRANIU_CT(11, "CT", "Craniu"),
    COLOANA_CERVICALA_CT(12, "CT", "Coloana cervicala"),
    TORACE_CT(13, "CT", "Torace"),
    ABDOMEN_CT(14, "CT", "Abdomen"),
    ALTE_CT(15, "CT", "Alte"),
    CRANIU_RMN(16, "RMN", "Craniu"),
    COLOANA_CERVICALA_RMN(17, "RMN", "Coloana cervicala"),
    TORACE_RMN(18, "RMN", "Torace"),
    ABDOMEN_RMN(19, "RMN", "Abdomen"),
    ALTE_RMN(20, "RMN", "Alte"),
    RITM_SINUSA(21, "EKG", "Ritm sinusal"),
    FRECV(22, "EKG", "Frecv"),
    STT_NORMAL(23, "EKG", "ST-T normal"),
    FIA(24, "EKG", "FiA"),
    FV_TV(25, "EKG", "FV/TV"),
    TPSV(26, "EKG", "TPSV"),
    ASISTOLIE(27, "EKG", "Asistolie");

    private final Integer id;
    private final String categorie;
    private final String nume;

    Procedura(Integer id, String category, String name) {
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
