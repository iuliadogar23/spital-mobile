package lucrare.dizertatie.dizertatiemobile.pubsub;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;

import java.sql.Timestamp;
import java.util.Calendar;

import lucrare.dizertatie.dizertatiemobile.adapters.DoctorActivityAdapter;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.ui.mainpage.MainActivity;

public class PresencePnCallback extends SubscribeCallback {
    private static final String TAG = PresencePnCallback.class.getName();
    Gson gson;
    Context context;
    private final DoctorActivityAdapter presenceListAdapter;

    public PresencePnCallback(DoctorActivityAdapter presenceListAdapter, Context context) {
        this.gson = new Gson();
        this.presenceListAdapter = presenceListAdapter;
        this.context = context;
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

        Doctor sender = ((MainActivity) context).getDoctors().stream().filter(d -> d.getId().toString().equals(presence.getUuid())).findFirst().orElse(null);
        if (sender != null) ;
        {
            String presenceString = presence.getEvent();
            String timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis()).toString();

            PresencePojo pm = new PresencePojo(gson.toJson(sender), presenceString, timestamp);
            presenceListAdapter.add(pm);
        }

    }

}
