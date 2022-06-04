package lucrare.dizertatie.dizertatiemobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;


public class PatientSearchAdapter extends ArrayAdapter<FisaMedicala> {

    private List<FisaMedicala> fisaMedicalaList;

    public PatientSearchAdapter(@NonNull Context context, @NonNull List<FisaMedicala> objects) {
        super(context, 0, objects);
        fisaMedicalaList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.patient_search_row, parent, false);
        }

        TextView tvFisaNr = convertView.findViewById(R.id.tv_fisa_nr);
        TextView tvDetalii = convertView.findViewById(R.id.tv_detalii);

        FisaMedicala fisaMedicala = getItem(position);
        if (fisaMedicala != null) {
            tvFisaNr.setText("Nr." + fisaMedicala.getNrFisa().toString());
            tvDetalii.setText(getDetaliiForTextView(fisaMedicala));
        }

        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return fisaMedicalaFilter;
    }

    private String getDetaliiForTextView(FisaMedicala fisaMedicala) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fisaMedicala.getPacient().getNume())
                .append(" ")
                .append(fisaMedicala.getPacient().getPrenume())
                .append(", ")
                .append(fisaMedicala.getPacient().getVarsta())
                .append(" ani");

        return stringBuilder.toString();
    }

    private Filter fisaMedicalaFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<FisaMedicala> fisaMedicalaSuggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0)
                fisaMedicalaSuggestions.addAll(fisaMedicalaList);
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (FisaMedicala fisaMedicala : fisaMedicalaList)
                    if (fisaMedicala.getNrFisa().toString().startsWith(filterPattern) || fisaMedicala.getPacient().getCnp().startsWith(filterPattern))
                        fisaMedicalaSuggestions.add(fisaMedicala);
            }
            results.values = fisaMedicalaSuggestions;
            results.count = fisaMedicalaSuggestions.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            clear();
            addAll((List) results.values);

        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((FisaMedicala) resultValue).getNrFisa().toString();
        }

    };

}