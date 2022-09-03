package lucrare.dizertatie.dizertatiemobile.pubsub;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PubSubPojo {

    private final String uid;
    private final String sender;
    private final String message;
    private final String timestamp;
    private final String receiver;
    private boolean reply;
    private boolean accepted;

    public PubSubPojo(@JsonProperty("uid") String uid, @JsonProperty("sender") String sender, @JsonProperty("message") String message, @JsonProperty("timestamp") String timestamp, @JsonProperty("receiver") String receiver, @JsonProperty("reply") boolean reply, @JsonProperty("accepted") boolean accepted) {
        this.uid = uid;
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
        this.receiver = receiver;
        this.reply =reply;
        this.accepted =accepted;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getReceiver() {
        return receiver;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public String getUid() {
        return uid;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
