package lucrare.dizertatie.dizertatiemobile.model.notificare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mesaj {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("dataOra")
    @Expose
    private String dataOra;
    @SerializedName("sender")
    @Expose
    private String sender;
    @SerializedName("receiver")
    @Expose
    private String receiver;
    @SerializedName("mesaj")
    @Expose
    private String mesaj;
    @SerializedName("reply")
    @Expose
    private boolean reply;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getDataOra() {
        return dataOra;
    }

    public void setDataOra(String dataOra) {
        this.dataOra = dataOra;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }
}
