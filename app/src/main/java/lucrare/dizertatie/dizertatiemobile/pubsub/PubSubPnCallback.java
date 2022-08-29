package lucrare.dizertatie.dizertatiemobile.pubsub;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;

import androidx.core.content.ContextCompat;

import com.google.gson.Gson;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;

import java.sql.Timestamp;
import java.util.Calendar;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification.NotificationHelper;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;
import lucrare.dizertatie.dizertatiemobile.util.Utils;

public class PubSubPnCallback extends SubscribeCallback {
    private static final String TAG = PubSubPnCallback.class.getName();


    Gson gson ;
    MenuItem notificationBell;
    Context context;
    NotificationHelper notificationHelper;

    public PubSubPnCallback(MenuItem button, Context context) {
        this.gson = new Gson();
        this.notificationBell = button;
        this.context=context;
        this.notificationHelper = new NotificationHelper(context);
    }


    @Override
    public void status(PubNub pubnub, PNStatus status) {

    }

    @Override
    public void message(PubNub pubnub, PNMessageResult message) {
        try {
            Log.v(TAG, "message(" + gson.toJson(message) + ")");
            PubSubPojo dsMsg = gson.fromJson(message.getMessage(), PubSubPojo.class);

            Notificare notificare = new Notificare();
            notificare.setDbName("administrativ");
            notificare.setMesaj(setNotificationMessage(dsMsg));
            notificare.setObiect(gson.toJson(dsMsg));
            notificare.setDataOra(dsMsg.getTimestamp());
            notificationBell.setIcon(ContextCompat.getDrawable(context, R.drawable.ic_new_notification));
            notificationHelper.saveNotificare(notificare);
//update adapters if needed
//            this.pubSubListAdapter.add(dsMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void presence(PubNub pubnub, PNPresenceEventResult presence) {
        // no presence handling for simplicity
    }

    private String setNotificationMessage(PubSubPojo pojo)
    {
        Doctor sender = gson.fromJson(pojo.getSender(), Doctor.class);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Utils.setDoctorTitle(sender))
                .append(Constants.SPACE)
                .append("v-a trimis o alerta:")
                .append(Constants.ENDLINE)
                .append(pojo.getMessage());
        return stringBuilder.toString();
    }

}
