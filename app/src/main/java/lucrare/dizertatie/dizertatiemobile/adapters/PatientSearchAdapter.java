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
import java.util.stream.Collectors;

import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.util.Utils;


public class PatientSearchAdapter extends ArrayAdapter<FisaMedicala> {

    private List<FisaMedicala> fisaMedicalaList;
    List<FisaMedicala> fisaMedicalaSuggestions;

    public PatientSearchAdapter(@NonNull Context context, @NonNull List<FisaMedicala> objects) {
        super(context, 0, objects);
        fisaMedicalaList = objects;
        fisaMedicalaSuggestions = new ArrayList<>();
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

            if (constraint == null || constraint.length() == 0)
                fisaMedicalaSuggestions.addAll(fisaMedicalaList);
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                fisaMedicalaSuggestions = fisaMedicalaList.stream()
                        .filter(p -> p.getNrFisa().toString().startsWith(filterPattern) || Utils.setPatientName(p.getPacient()).contains(filterPattern) || (p.getPacient().getCnp() != null && p.getPacient().getCnp().startsWith(filterPattern)))
                        .collect(Collectors.toList());
            }
            results.values = fisaMedicalaSuggestions;
            results.count = fisaMedicalaSuggestions.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            clear();
//            List<Object> resultList = new ArrayList<>();
//            resultList.add(results.values);
//            addAll( (results.values));
            if (results.values != null) {
                List<FisaMedicala> fisaMedicalaSuggestions = (List<FisaMedicala>) results.values;
                addAll((List<FisaMedicala>) results.values);
            }


//            add((FisaMedicala) results.values);

        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((FisaMedicala) resultValue).getNrFisa().toString();
        }

    };

}