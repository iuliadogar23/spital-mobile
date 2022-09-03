package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.databinding.RowStateBindingImpl;
import lucrare.dizertatie.dizertatiemobile.model.enums.FunctiiVitale;
import lucrare.dizertatie.dizertatiemobile.model.enums.Glagow;
import lucrare.dizertatie.dizertatiemobile.model.enums.ScorNaca;
import lucrare.dizertatie.dizertatiemobile.model.enums.Sex;
import lucrare.dizertatie.dizertatiemobile.model.enums.Stare;
import lucrare.dizertatie.dizertatiemobile.model.enums.StatusR;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.ScorGlagow;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.StarePacient;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.Pat;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.SalaOperatie;
import lucrare.dizertatie.dizertatiemobile.ui.loginpage.LoginViewModel;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;


public class StateFragment extends Fragment {

    @BindView(R.id.et_naca)
    EditText nacaEditText;
    @BindView(R.id.et_functii_vitale)
    EditText functiiVitaleEditText;
    @BindView(R.id.et_stare_pacient)
    EditText starePacientEditText;
    @BindView(R.id.et_glagow_ochi)
    EditText glagowOchiEditText;
    @BindView(R.id.et_glagow_motor)
    EditText glagowMotorEditText;
    @BindView(R.id.et_glagow_verbal)
    EditText glagowVerbalEditText;
    @BindView(R.id.btn_pat)
    Button patButton;
    @BindView(R.id.btn_sala_operatii)
    Button salaOperatieButton;

    Glagow valMotor;
    Glagow valVerbal;
    Glagow valOchi;
    String valNaca;

    RowStateBindingImpl binding;
    SharedPreferencesUtil sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getContext());

    private StateViewModel stateViewModel;

    public static StateFragment newInstance() {
        return new StateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.row_state, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        binding.setVariable(BR.stare, new StarePacient());
        stateViewModel = ViewModelProviders.of(this).get(StateViewModel.class);

        setupSpinners();
        setupButtons();

        return root;
    }

    private void setupSpinners() {

        nacaEditText.setOnClickListener(v -> setupNaca(v));
        functiiVitaleEditText.setOnClickListener(v -> setupFunctiiVitale(v));
        starePacientEditText.setOnClickListener(v -> setupStare(v));
        glagowMotorEditText.setOnClickListener(v -> setupGlagowMotor(v));
        glagowOchiEditText.setOnClickListener(v -> setupGlagowOchi(v));
        glagowVerbalEditText.setOnClickListener(v -> setupGlagowVerbal(v));

    }

    private void setupButtons() {
        salaOperatieButton.setOnClickListener(v -> setupSalaOperatii());
        patButton.setOnClickListener(v -> setupPat());
    }

    private void setupNaca(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(ScorNaca.values()).map(s -> s.getDescriere()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            valNaca = ScorNaca.getByDescription(array[i]).toString();
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupFunctiiVitale(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(FunctiiVitale.values()).map(s -> s.getNume()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            binding.getStare().setFunctiiVitale(FunctiiVitale.getByNume(array[i]).toString());
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupStare(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(Stare.values()).map(s -> s.getNume()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            binding.getStare().setStarePacient(Stare.getByName(array[i]).toString());
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupGlagowMotor(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(Glagow.values()).filter(s -> s.getCategorie().equals("Raspuns motor")).map(s -> s.getDescriereSeveritate()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            valMotor = Glagow.findBySeverityDescription(array[i]);
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupGlagowVerbal(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(Glagow.values()).filter(s -> s.getCategorie().equals("Raspuns verbal")).map(s -> s.getDescriereSeveritate()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            valVerbal = Glagow.findBySeverityDescription(array[i]);
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupGlagowOchi(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = Arrays.stream(Glagow.values()).filter(s -> s.getCategorie().equals("Deschiderea ochilor")).map(s -> s.getDescriereSeveritate()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            valOchi = Glagow.findBySeverityDescription(array[i]);
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupSalaOperatii() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Disponibilitate");
        alertDialog.setMessage("Alege ora si data operatiei");




        final EditText oraStart = new EditText(getContext());
        final EditText oraEnd= new EditText(getContext());

        LinearLayout lp =new LinearLayout(getContext());
        lp.setOrientation(LinearLayout.VERTICAL);
        lp.addView(oraStart);
        lp.addView(oraEnd);

        oraEnd.setHint("Ora inceperii HH:mm");
        oraStart.setHint("Ora sfarsit HH:mm");

        alertDialog.setView(lp);



        alertDialog.setPositiveButton("Confirmare", (dialogInterface, i) -> {

            Date date = new Date();
            date.setTime(Calendar.getInstance().getTimeInMillis());
            String[] start = splitString(oraStart.getText().toString());
            String[] end = splitString(oraEnd.getText().toString());
            SalaOperatie salaOperatie = new SalaOperatie();
            salaOperatie.setBlocOperator(sharedPreferencesUtil.getDoctor().getBlocOperator());
            salaOperatie.setStatus(StatusR.OCUPAT.toString());

            date.setHours(Integer.valueOf(start[0]));
            date.setMinutes(Integer.valueOf(start[1]));
            salaOperatie.setOraIncepere(date.getTime());

            date.setHours(Integer.valueOf(end[0]));
            date.setMinutes(Integer.valueOf(end[1]));
            salaOperatie.setDurata(date.getTime());
            salaOperatie.setDoctor(sharedPreferencesUtil.getDoctor().getId());

            if (sharedPreferencesUtil.getNewFisa().getNrFisa()==null)
                sharedPreferencesUtil.setNewFisa(stateViewModel.saveFisaMedicala(sharedPreferencesUtil.getNewFisa(), getContext()).getValue());
            stateViewModel.saveSalaOperatie(salaOperatie);
            Toast.makeText(getContext(), "Solicitarea dumneavoastra a fost efectuata!", Toast.LENGTH_LONG).show();
        });
        alertDialog.setNegativeButton("Anulare", (dialogInterface, i) -> dialogInterface.dismiss());

        alertDialog.show();
    }

    private void setupPat()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Disponibilitate");
        alertDialog.setMessage("Va fi pacientul legat la aparatele post-operationale?");
        Pat pat = new Pat();
        pat.setStatus(StatusR.OCUPAT.toString());
        pat.setBlocOperator(sharedPreferencesUtil.getDoctor().getBlocOperator());


        alertDialog.setPositiveButton("Da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (sharedPreferencesUtil.getNewFisa().getNrFisa()==null)
                    stateViewModel.saveFisaMedicala(sharedPreferencesUtil.getNewFisa(), getContext()).observe(getActivity(), fisaMedicala -> {
                        sharedPreferencesUtil.setNewFisa(fisaMedicala);
                        pat.setNrFisa(fisaMedicala.getNrFisa());
                        pat.setAparatura(true);
                        stateViewModel.savePat(pat);
                    });
                else {
                    pat.setNrFisa(sharedPreferencesUtil.getNewFisa().getNrFisa());
                    pat.setAparatura(true);
                    stateViewModel.savePat(pat);
                }
                Toast.makeText(getContext(), "Solicitarea dumneavoastra a fost efectuata!", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.setNegativeButton("Nu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (sharedPreferencesUtil.getNewFisa().getNrFisa()==null)
                    stateViewModel.saveFisaMedicala(sharedPreferencesUtil.getNewFisa(), getContext()).observe(getActivity(), fisaMedicala -> {
                        sharedPreferencesUtil.setNewFisa(fisaMedicala);
                        pat.setNrFisa(fisaMedicala.getNrFisa());
                        pat.setAparatura(false);
                        stateViewModel.savePat(pat);
                    });
                else {
                    pat.setNrFisa(sharedPreferencesUtil.getNewFisa().getNrFisa());
                    pat.setAparatura(false);
                    stateViewModel.savePat(pat);
                }
                Toast.makeText(getContext(), "Solicitarea dumneavoastra a fost efectuata!", Toast.LENGTH_LONG).show();
            }
        });

        alertDialog.show();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (binding != null && binding.getStare() != null && this.isVisible() && !isVisibleToUser) {

            FisaMedicala fisaMedicala = sharedPreferencesUtil.getNewFisa();

            StarePacient starePacient = binding.getStare();
            starePacient.setDataOra(Calendar.getInstance().getTimeInMillis());
            fisaMedicala.getStarePacient().add(starePacient);
            if (valNaca != null)
                fisaMedicala.setScorNaca(valNaca);
            if (valOchi!=null && valVerbal!=null &&valMotor!=null)
                fisaMedicala.getScorGlagow().add(new ScorGlagow(null, valOchi.toString(), valMotor.toString(), valVerbal.toString(), valVerbal.getSeveritate()+valMotor.getSeveritate()+ valOchi.getSeveritate()));
            sharedPreferencesUtil.setNewFisa(fisaMedicala);

        }
    }

    private String[] splitString(String value)
    {
        return value.split(":");
    }
}