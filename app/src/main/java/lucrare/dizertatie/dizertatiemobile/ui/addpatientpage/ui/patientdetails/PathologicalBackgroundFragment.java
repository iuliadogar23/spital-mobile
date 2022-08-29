package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.enums.IstoricPatologic;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class PathologicalBackgroundFragment extends Fragment {

    @BindView(R.id.et_anamneza)
    TextInputEditText anamnezaEditText;
    @BindView(R.id.et_tratamment_domiciliu)
    TextInputEditText tratamentDomiciliuEditText;
    @BindView(R.id.layout_pathological_background)
    LinearLayout linearLayout;

    List<IstoricPatologic> pathologicalBackground = new ArrayList<>();

    public static PathologicalBackgroundFragment newInstance() {
        return new PathologicalBackgroundFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.row_pathological_background, container, false);
        ButterKnife.bind(this, root);

        setupCheckBox();

        return root;
    }

    private void setupCheckBox() {
        for (IstoricPatologic istoricPatologic : IstoricPatologic.values()) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(istoricPatologic.getNume());
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (checkBox.isChecked())
                    pathologicalBackground.add(istoricPatologic);
                else
                    pathologicalBackground.remove(istoricPatologic);
            });
            checkBox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary, null)));
            checkBox.setTop(R.dimen.spacing_mlarge);
            linearLayout.addView(checkBox);
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible() && !isVisibleToUser) {
            SharedPreferencesUtil sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getContext());
            FisaMedicala fisaMedicala = sharedPreferencesUtil.getNewFisa();
            fisaMedicala.setAnamneza(anamnezaEditText.getText().toString());
            fisaMedicala.setTratamentDomiciliu(tratamentDomiciliuEditText.getText().toString());
            fisaMedicala.setAntecedentePatologice(pathologicalBackground);
            sharedPreferencesUtil.setNewFisa(fisaMedicala);
        }
    }
}