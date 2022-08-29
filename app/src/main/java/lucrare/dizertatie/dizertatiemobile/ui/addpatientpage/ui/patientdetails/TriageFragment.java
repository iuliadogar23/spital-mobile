package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.enums.Triaj;
import lucrare.dizertatie.dizertatiemobile.model.enums.Triaj;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class TriageFragment extends Fragment {

    @BindView(R.id.layout_checkbox)
    LinearLayout checkboxLayout;
    @BindView(R.id.et_inaltime)
    EditText talieEditText;
    @BindView(R.id.et_greutate)
    EditText greutateEditText;

    List<Triaj> selected = new ArrayList<>();

    public static TriageFragment newInstance() {
        return new TriageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.row_triage, container, false);
        ButterKnife.bind(this, root);

        setupLayout();

        return root;
    }

    private void setupLayout()
    {
        Map<String, List<Triaj>> triajByCategorii = Arrays.stream(Triaj.values()).collect(Collectors.groupingBy(Triaj::getCategorie));
        int limit = 0;
        LinearLayout ll= new LinearLayout(getContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        checkboxLayout.addView(ll);

        for (String categorie: triajByCategorii.keySet())
        {

            if (limit>17)
            {
                ll = new LinearLayout(getContext());
                ll.setOrientation(LinearLayout.VERTICAL);
                checkboxLayout.addView(ll);
                limit=0;
            }
            TextView textView = new TextView(getContext());
            textView.setText(categorie);
            textView.setTypeface(null, Typeface.BOLD);
            ll.addView(textView);
            for (Triaj p: triajByCategorii.get(categorie))
            {
                CheckBox checkBox = new CheckBox(getContext());
                checkBox.setText(p.getNume());
                checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (checkBox.isChecked())
                        selected.add(p);
                    else
                        selected.remove(p);
                });
                checkBox.setButtonTintList(ColorStateList.valueOf(getResources() .getColor(R.color.colorPrimary, null)));
                checkBox.setTop(R.dimen.spacing_mlarge);
                ll.addView(checkBox);
                limit++;
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible() && !isVisibleToUser) {
            SharedPreferencesUtil sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getContext());
            FisaMedicala fisaMedicala = sharedPreferencesUtil.getNewFisa();
            fisaMedicala.setGreutate(greutateEditText.getText().toString());
            fisaMedicala.setTalie(talieEditText.getText().toString());
            fisaMedicala.setTriaj(selected);

            sharedPreferencesUtil.setNewFisa(fisaMedicala);
        }
    }
}