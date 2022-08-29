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
import lucrare.dizertatie.dizertatiemobile.model.enums.Procedura;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class EkgFragment extends Fragment {

    @BindView(R.id.layout_checkbox)
    LinearLayout checkboxLayout;
    @BindView(R.id.et_ekg)
    EditText ekgEditText;
    @BindView(R.id.et_radiologie)
    EditText radiologieEditText;
    @BindView(R.id.et_ecografie)
    EditText ecografieEditText;

    List<Procedura> selected = new ArrayList<>();

    public static EkgFragment newInstance() {
        return new EkgFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.row_ekg, container, false);
        ButterKnife.bind(this, root);
        setupLayout();

        return root;
    }

    private void setupLayout()
    {
        Map<String, List<Procedura>> proceduriByCategorii = Arrays.stream(Procedura.values()).collect(Collectors.groupingBy(Procedura::getCategorie));
        int limit = 0;
        LinearLayout ll= new LinearLayout(getContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        checkboxLayout.addView(ll);

        for (String categorie: proceduriByCategorii.keySet())
        {

            if (limit>6)
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
            for (Procedura p: proceduriByCategorii.get(categorie))
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
            fisaMedicala.setEkg(ekgEditText.getText().toString());
            fisaMedicala.setEcografie(ecografieEditText.getText().toString());
            fisaMedicala.setRadiologie(ecografieEditText.getText().toString());
            fisaMedicala.setProceduri(selected);

            sharedPreferencesUtil.setNewFisa(fisaMedicala);
        }
    }
}