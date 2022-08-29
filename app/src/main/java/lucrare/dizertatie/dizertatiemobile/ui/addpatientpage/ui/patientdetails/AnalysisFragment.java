package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.enums.DenumireMedicala;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.Analize;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class AnalysisFragment extends Fragment {

    @BindView(R.id.analysis_layout)
    LinearLayout analysisLayout;

    List<Analize> analize = new ArrayList<>();

    public static AnalysisFragment newInstance() {
        return new AnalysisFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.row_analysis, container, false);
        ButterKnife.bind(this, root);

        setupLayout();

        return root;
    }

    private void setupLayout() {
        int limit = 0;
        LinearLayout ll = new LinearLayout(getContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);

        for (DenumireMedicala d : DenumireMedicala.values()) {
            if (limit > 2) {
                ll = new LinearLayout(getContext());
                ll.setOrientation(LinearLayout.HORIZONTAL);
                analysisLayout.addView(ll);

            }
            TextInputLayout tl = new TextInputLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            layoutParams.topMargin = R.dimen.spacing_xlarge;
            tl.setLayoutParams(layoutParams);

            AutoCompleteTextView at = new AutoCompleteTextView(getContext());
            at.setHeight(-2);
            at.setWidth(-1);
            at.setTextColor(getResources().getColor(R.color.grey_80));
            at.setMaxLines(1);
            at.setSingleLine(true);
            at.setHint(d.toString());
            at.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    analize.add(new Analize(d.toString(), at.getText().toString()));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            tl.addView(at);
            ll.addView(tl);

            limit++;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible() && !isVisibleToUser) {
            SharedPreferencesUtil sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getContext());
            FisaMedicala fisaMedicala = sharedPreferencesUtil.getNewFisa();
            fisaMedicala.setAnalize(analize);

            sharedPreferencesUtil.setNewFisa(fisaMedicala);
        }
    }
}