package lucrare.dizertatie.dizertatiemobile.pubsub;

import android.util.Log;

import com.google.gson.Gson;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;

import java.sql.Timestamp;
import java.util.Calendar;

public class PresencePnCallback extends SubscribeCallback {
    private static final String TAG = PresencePnCallback.class.getName();
    Gson gson;

    public PresencePnCallback() {
        gson = new Gson();
    }

    @Override
    public void status(PubNub pubnub, PNStatus status) {
        // no status handling for simplicity
    }

    @Override
    public void message(PubNub pubnub, PNMessageResult message) {
        // no message handling for simplicity
    }

    @Override
    public void presence(PubNub pubnub, PNPresenceEventResult presence) {
        try {
            Log.v(TAG, "presenceP(" + gson.toJson(presence) + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sender = presence.getUuid();
        String presenceString = presence.getEvent().toString();
        String timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis()).toString();

        PresencePojo pm = new PresencePojo(sender, presenceString, timestamp);
//        presenceListAdapter.add(pm);
    }

}
