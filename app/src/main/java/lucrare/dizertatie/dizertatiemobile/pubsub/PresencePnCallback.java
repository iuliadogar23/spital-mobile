package lucrare.dizertatie.dizertatiemobile.pubsub;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import lucrare.dizertatie.dizertatiemobile.adapters.DoctorActivityAdapter;

public class PresencePnCallback extends SubscribeCallback {
    private static final String TAG = PresencePnCallback.class.getName();
    Gson gson;
    List<PresencePojo> presencePojos;
    public MutableLiveData<List<PresencePojo>> syncPresence;

    public PresencePnCallback() {
        this.gson = new Gson();
        this.presencePojos = new ArrayList<>();
        this.syncPresence = new MutableLiveData<>();
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
        addPresenceInList(pm);

    }

    public void addPresenceInList(PresencePojo pojo)
    {
            presencePojos.removeIf(p->p.getSender().equals(pojo.getSender()));
            presencePojos.add(pojo);
            syncPresence.postValue(presencePojos);
    }

    public List<PresencePojo> getPresencePojos() {
        return presencePojos;
    }
}
