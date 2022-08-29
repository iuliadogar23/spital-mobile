package lucrare.dizertatie.dizertatiemobile.pubsub;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PresencePojo {
    private final String sender;
    private final String presence;
    private final String timestamp;

    public PresencePojo(@JsonProperty("sender") String sender, @JsonProperty("presence") String presence, @JsonProperty("timestamp") String timestamp) {
        this.sender = sender;
        this.presence = presence;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public String getPresence() {
        return presence;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
