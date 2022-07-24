package lucrare.dizertatie.dizertatiemobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;

public class NotificationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Notificare> items = new ArrayList<>();

    private Context ctx;

    @LayoutRes
    private int layout_id;

    public NotificationListAdapter(List<Notificare> items, Context ctx, int layout_id) {
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
        if (holder instanceof NotificationListAdapter.OriginalViewHolder) {
            NotificationListAdapter.OriginalViewHolder viewHolder = (NotificationListAdapter.OriginalViewHolder) holder;


            Notificare n = items.get(position);
            viewHolder.description.setText(n.getMesaj());
            viewHolder.date.setText(n.getDataOra());

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
        public TextView date;
        public View lyt_parent;

        public OriginalViewHolder(@NonNull View v) {
            super(v);
            description = v.findViewById(R.id.notificare_description);
            date = v.findViewById(R.id.notificare_date);
            lyt_parent = v.findViewById(R.id.lyt_parent);
        }
    }

}
