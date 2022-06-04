package lucrare.dizertatie.dizertatiemobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.util.Utils;

public class AdapterListConsult extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Consult> items = new ArrayList<>();

    private Context ctx;

    @LayoutRes
    private int layout_id;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Consult obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.onItemClickListener = mItemClickListener;
    }

    public AdapterListConsult(List<Consult> items, Context ctx, int layout_id) {
        this.items = items;
        this.ctx = ctx;
        this.layout_id = layout_id;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(layout_id, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder viewHolder = (OriginalViewHolder) holder;


            Consult c = items.get(position);
            viewHolder.description.setText(c.getMesajSolicitare());
            viewHolder.doctorName.setText(Utils.setDoctorTitle(c.getDoctorSolicitant()));
            viewHolder.date.setText(Utils.convertLongToDate(c.getOraPrezentarii()));

            viewHolder.lyt_parent.setOnClickListener(v -> {
                if (onItemClickListener == null)
                    return;
                onItemClickListener.onItemClick(v, items.get(position), position);
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
        public TextView description;
        public TextView doctorName;
        public TextView date;
        public View lyt_parent;

        public OriginalViewHolder(@NonNull View v) {
            super(v);
            description = v.findViewById(R.id.consult_description);
            doctorName = v.findViewById(R.id.consult_severity);
            date = v.findViewById(R.id.consult_date);
            lyt_parent = v.findViewById(R.id.lyt_parent);
        }
    }

}
