package lucrare.dizertatie.dizertatiemobile.pubsub;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PubSubPojo {

    private final String sender;
    private final String message;
    private final String timestamp;
    private final String receiver;

    public PubSubPojo(@JsonProperty("sender") String sender, @JsonProperty("message") String message, @JsonProperty("timestamp") String timestamp, @JsonProperty("receiver") String receiver) {
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
        this.receiver = receiver;
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

}
