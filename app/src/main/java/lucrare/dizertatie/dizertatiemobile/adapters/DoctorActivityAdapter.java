package lucrare.dizertatie.dizertatiemobile.adapters;

import android.content.Context;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;
import lucrare.dizertatie.dizertatiemobile.util.Utils;

public class DoctorActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Doctor> items;
    private Context ctx;
    private Gson gson;
    private PubNub pubNub;
    private SharedPreferencesUtil sharedPreferencesUtil;

    @LayoutRes
    private int layout_id;

    public DoctorActivityAdapter(List<Doctor> items, Context ctx, int layout_id, PubNub pubNub, SharedPreferencesUtil sharedPreferencesUtil) {
        this.items = items;
        this.ctx = ctx;
        this.layout_id = layout_id;
        this.pubNub = pubNub;
        this.gson = new Gson();
        this.sharedPreferencesUtil = sharedPreferencesUtil;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(layout_id, parent, false);
        vh = new DoctorActivityAdapter.OriginalViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof DoctorActivityAdapter.OriginalViewHolder) {
            DoctorActivityAdapter.OriginalViewHolder viewHolder = (DoctorActivityAdapter.OriginalViewHolder) holder;

            Doctor d = items.get(position);
            viewHolder.doctor.setText(Utils.setDoctorTitle(d));
            viewHolder.status.setText("Activ"); //Add la doctor status activ inactiv whatever
            viewHolder.sectie.setText(d.getSpecializare());
//            viewHolder.mesaj.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                }
//            });
            viewHolder.sendIcon.setStartIconOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    publish(gson.toJson(sharedPreferencesUtil.getDoctor()), viewHolder.mesaj.getText().toString(), d.getId().toString(), viewHolder.mesaj);
                }
            });

        }

    }

    public void publish(String sender, String message, String receiver, TextInputEditText editText)
    {
        final Map<String, String> publish = new HashMap<String, String>();
        publish.put("sender", sender);
        publish.put("receiver", receiver);
        publish.put("message", message);
        publish.put("timestamp", new Timestamp(Calendar.getInstance().getTimeInMillis()).toString());

        pubNub.publish().channel(receiver).message(publish).async(
                new PNCallback<PNPublishResult>() {
                    @Override
                    public void onResponse(PNPublishResult result, PNStatus status) {
                        try {
                            if (!status.isError()) {
                                editText.setClickable(false);
                                editText.setEnabled(false);
                                editText.setText("Mesaj trimis!");
                                Log.v("DoctorActivity", "publish(" + gson.toJson(result) + ")");
                            } else {
                                Log.v("DoctorActivity", "publishErr(" + gson.toJson(status) + ")");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        public TextView doctor;
        public TextView sectie;
        public TextView status;
        public TextInputEditText mesaj;
        private TextInputLayout sendIcon;
        public View lyt_parent;


        public OriginalViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor = itemView.findViewById(R.id.tv_titlu_doctor);
            sectie = itemView.findViewById(R.id.tv_sectie);
            status = itemView.findViewById(R.id.tv_status_doctor);
            mesaj = itemView.findViewById(R.id.tiet_mesaj);
            sendIcon = itemView.findViewById(R.id.et_notificaiton_details);
            lyt_parent = itemView.findViewById(R.id.lyt_parent);
        }
    }

}
