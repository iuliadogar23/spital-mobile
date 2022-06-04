package lucrare.dizertatie.dizertatiemobile.model.enums;

public enum Status {
    IN_ASTEPTARE("In asteptare"),
    ACCEPTAT("Acceptat"),
    ISTORIC("Istoric");

    private String nume;

    Status(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
