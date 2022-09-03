package lucrare.dizertatie.dizertatiemobile.model.response;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.notificare.Mesaj;

public class MesajResponse {

    List<Mesaj> mesaje;

    public List<Mesaj> getMesaje() {
        return mesaje;
    }

    public void setMesaje(List<Mesaj> mesaje) {
        this.mesaje = mesaje;
    }
}
