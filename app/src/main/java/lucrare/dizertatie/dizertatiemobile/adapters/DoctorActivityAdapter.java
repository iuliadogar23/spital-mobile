package lucrare.dizertatie.dizertatiemobile.adapters;

import android.content.Context;
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

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.util.Utils;

public class DoctorActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Doctor> items;
    private Context ctx;

    @LayoutRes
    private int layout_id;

    public DoctorActivityAdapter(List<Doctor> items, Context ctx, int layout_id) {
        this.items = items;
        this.ctx = ctx;
        this.layout_id = layout_id;
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
            viewHolder.sendIcon.setStartIconOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //aici se face send la notificaiton
                }
            });

        }

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
