package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.databinding.RowPacientDetailsBinding;
import lucrare.dizertatie.dizertatiemobile.model.enums.AdusDe;
import lucrare.dizertatie.dizertatiemobile.model.enums.AdusDeLa;
import lucrare.dizertatie.dizertatiemobile.model.enums.GrupaSanguina;
import lucrare.dizertatie.dizertatiemobile.model.enums.Sex;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.Pacient;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.PrimirePacient;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;
import lucrare.dizertatie.dizertatiemobile.util.Utils;

public class PatientDetailsFragment extends Fragment {

    @BindView(R.id.et_blood)
    EditText grupaSanguina;
    @BindView(R.id.et_gender)
    EditText sex;
    @BindView(R.id.et_brought_by)
    EditText adusDe;
    @BindView(R.id.et_brought_from)
    EditText adusDeLa;
    @BindView(R.id.et_motivul_prezentarii)
    EditText motivulPrezentarii;
    @BindView(R.id.et_fisa_externa)
    EditText fisaExterna;

    PrimirePacient primirePacient = new PrimirePacient();


    RowPacientDetailsBinding binding;

    public static PatientDetailsFragment newInstance() {
        return new PatientDetailsFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.row_pacient_details, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        binding.setVariable(BR.pacient, new Pacient());

        setupSpinners();
        setupEditText();


        return root;
    }

    private void setupEditText() {
        motivulPrezentarii.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                primirePacient.setMotivulPrezentarii(motivulPrezentarii.getText().toString());
            }
        });
        fisaExterna.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                primirePacient.setNrFisaExterna(fisaExterna.getText().toString());
            }
        });
    }

    private void setupSpinners() {
        sex.setOnClickListener(v -> setupSex(v));
        grupaSanguina.setOnClickListener(v -> setupGrupaSanguina(v));
        adusDe.setOnClickListener(v -> setupAdusDe(v));
        adusDeLa.setOnClickListener(v -> setupAdusDeLa(v));
    }

    private void setupGrupaSanguina(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(GrupaSanguina.values()).map(s -> s.getNume()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            binding.getPacient().setSange(GrupaSanguina.getByName(array[i]).toString());
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupAdusDe(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(AdusDe.values()).map(s -> s.getNume()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            primirePacient.setAdusDe(AdusDe.findByName(array[i]).toString());
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupAdusDeLa(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(AdusDeLa.values()).map(s -> s.getNume()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            primirePacient.setAdusDe(AdusDeLa.findByName(array[i]).toString());
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupSex(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(Sex.values()).map(s -> s.toString()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            binding.getPacient().setSex(array[i]);
            dialogInterface.dismiss();
        });
        builder.show();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (binding != null && binding.getPacient() != null && this.isVisible() && !isVisibleToUser) {
            FisaMedicala fisaMedicala;
            SharedPreferencesUtil sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getContext());
            if (sharedPreferencesUtil.getNewFisa() == null || sharedPreferencesUtil.getNewFisa().getStarePacient() == null) {
                fisaMedicala = new FisaMedicala();
                fisaMedicala.setStarePacient(new ArrayList<>());
                fisaMedicala.setAntecedentePatologice(new ArrayList<>());
                fisaMedicala.setTriaj(new ArrayList<>());
                fisaMedicala.setProceduri(new ArrayList<>());
                fisaMedicala.setAnalize(new ArrayList<>());
                fisaMedicala.setScorGlagow(new ArrayList<>());
                sharedPreferencesUtil.setNewFisa(fisaMedicala);
            } else {
                fisaMedicala = sharedPreferencesUtil.getNewFisa();
            }
            Long date = Calendar.getInstance().getTimeInMillis();
            Pacient pacient = binding.getPacient();
            pacient.setUltimaSchimbare(date);
            fisaMedicala.setPacient(pacient);

            if (fisaMedicala.getNrFisa() == null) {
                primirePacient.setDataOra(date);
                primirePacient.setOraPrimConsult(date);
                primirePacient.setPreluatDe(Utils.setDoctorTitle(sharedPreferencesUtil.getDoctor()));
            }
            fisaMedicala.setPrimirePacient(primirePacient);

            sharedPreferencesUtil.setNewFisa(fisaMedicala);
        }
    }
}