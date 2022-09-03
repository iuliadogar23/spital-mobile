package lucrare.dizertatie.dizertatiemobile.pubsub;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.google.gson.Gson;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Mesaj;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;
import lucrare.dizertatie.dizertatiemobile.model.response.MesajResponse;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification.NotificationHelper;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import lucrare.dizertatie.dizertatiemobile.util.Utils;

public class PubSubPnCallback extends SubscribeCallback {
    private static final String TAG = PubSubPnCallback.class.getName();


    Gson gson ;
    MenuItem notificationBell;
    Context context;
    NotificationHelper notificationHelper;
    LifecycleOwner lifecycleOwner;

    public PubSubPnCallback(MenuItem button, Context context, LifecycleOwner lifecycleOwner) {
        this.gson = new Gson();
        this.notificationBell = button;
        this.context=context;
        this.lifecycleOwner = lifecycleOwner;
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
            Mesaj mesaj = gson.fromJson(message.getMessage(), Mesaj.class);
                    Notificare notificare = new Notificare();
            notificare.setDbName("administrativ");
            notificare.setMesaj(setNotificationMessage(dsMsg));
            notificare.setObiect(gson.toJson(dsMsg));
            notificare.setDataOra(dsMsg.getTimestamp());
            notificationBell.setIcon(ContextCompat.getDrawable(context, R.drawable.ic_new_notification));
            notificationHelper.saveNotificare(notificare);
            if (mesaj.getUid()!=null) {
                notificationHelper.getMesajeByUid(mesaj.getUid()).observe(lifecycleOwner, new Observer<MesajResponse>() {
                    @Override
                    public void onChanged(MesajResponse mesajResponse) {
//                        if (!mesajResponse.getMesaje().isEmpty() && mesajResponse.getMesaje().size()<2)
//                        {
//                            Mesaj updateMesaj = mesajResponse.getMesaje().get(0);
//                            updateMesaj.setReply(true);
//                        }
                    }
                });
            }
            else
            {
                notificationHelper.saveMesaj(mesaj);
            }



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
