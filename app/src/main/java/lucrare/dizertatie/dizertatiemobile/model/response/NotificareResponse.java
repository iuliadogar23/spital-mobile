package lucrare.dizertatie.dizertatiemobile.model.response;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;

public class NotificareResponse {

    private List<Notificare> notificareList;

    public List<Notificare> getNotificareList() {
        return notificareList;
    }

    public void setNotificareList(List<Notificare> notificareList) {
        this.notificareList = notificareList;
    }
}
