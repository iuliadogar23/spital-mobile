package lucrare.dizertatie.dizertatiemobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.enums.Stare;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;

public class PatientsMedicalHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @LayoutRes
    private int layout_id;

    private List<FisaMedicala> items;

    private PatientsMedicalHistoryAdapter.OnItemClickListener onItemClickListener;

    public PatientsMedicalHistoryAdapter(List<FisaMedicala> items, int layout_id) {
        this.layout_id = layout_id;
        this.items = items;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, FisaMedicala obj, int position);
    }

    public void setOnItemClickListener(final PatientsMedicalHistoryAdapter.OnItemClickListener mItemClickListener) {
        this.onItemClickListener = mItemClickListener;
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

            FisaMedicala p = items.get(position);
            viewHolder.name.setText(p.getPacient().getNume()+" "+p.getPacient().getPrenume());
            viewHolder.documentNr.setText(p.getNrFisa());
            viewHolder.state.setText(Stare.getByName(p.getStarePacient().get(p.getStarePacient().size()-1).getStarePacient()).getNume());

            viewHolder.lyt_parent.setOnClickListener(v->{
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
        public TextView name;
        public TextView documentNr;
        public TextView state;
        public View lyt_parent;

        public OriginalViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.consult_description);
            documentNr = v.findViewById(R.id.consult_severity);
            state = v.findViewById(R.id.consult_date);
            lyt_parent = v.findViewById(R.id.lyt_parent);
        }
    }
}
