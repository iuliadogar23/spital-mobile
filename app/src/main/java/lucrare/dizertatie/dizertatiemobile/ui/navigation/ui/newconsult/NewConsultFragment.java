package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.newconsult;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import butterknife.BindView;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentNewConsultBinding;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.enums.GrupaSanguina;
import lucrare.dizertatie.dizertatiemobile.model.enums.Status;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.hospitalactivity.HospitalActivityViewModel;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

//ex slideshow
public class NewConsultFragment extends Fragment {

    @BindView(R.id.et_sectie)
    EditText sectieEditText;
    @BindView(R.id.et_doctor)
    EditText doctorEditText;
    @BindView(R.id.et_nr_fisa)
    TextInputEditText nrFisaEditText;
    @BindView(R.id.et_mesaj_solicitare)
    TextInputEditText solicitareEditText;
    @BindView(R.id.fab_ok)
    FloatingActionButton okButton;


    private FragmentNewConsultBinding binding;
    NewConsultViewModel newConsultViewModel;
    HospitalActivityViewModel hospitalActivityViewModel;
    Map<String, List<Doctor>> doctorsBySectie;
    Consult consult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNewConsultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        newConsultViewModel = new ViewModelProvider(this).get(NewConsultViewModel.class);
        hospitalActivityViewModel = new ViewModelProvider(this).get(HospitalActivityViewModel.class);

        consult = new Consult();

        hospitalActivityViewModel.getAllDoctors().observe(getActivity(), doctorResponse -> {
            doctorsBySectie = doctorResponse.getDoctorList().stream().collect(Collectors.groupingBy(Doctor::getSpecializare));
        });

        setupLayouts();

        return root;
    }

    private void setupLayouts() {
        okButton.setOnClickListener(v -> setupConsultOnButton());
        sectieEditText.setOnClickListener(v -> setupSectie(v));
        doctorEditText.setOnClickListener(v -> setupDoctor(v));
        setupNrFisa();
    }

    private void setupConsultOnButton()
    {
        consult.setMesajSolicitare(solicitareEditText.getText().toString());
        consult.setDoctorSolicitant(SharedPreferencesUtil.getInstance(getContext()).getDoctor());
        consult.setStatus(Status.IN_ASTEPTARE.toString());
        consult.setOraSolicitarii(Calendar.getInstance().getTimeInMillis());
        newConsultViewModel.saveConsult(consult);
    }

    private void setupSectie(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = (String[]) doctorsBySectie.keySet().toArray();
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            consult.setSectie(array[i]);
            doctorEditText.setClickable(true);
            dialogInterface.dismiss();
        });
        builder.show();
    }
    private void setupDoctor(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] array = doctorsBySectie.get(consult.getSectie()).stream().map(d->d.getNume()+" "+d.getPrenume()).toArray(String[]::new);
        builder.setSingleChoiceItems(array, -1, (dialogInterface, i) -> {
            ((EditText) v).setText(array[i]);
            consult.setSectie(array[i]);
            consult.setDoctorSolicitat(doctorsBySectie.get(consult.getSectie()).stream().filter(d->array[i].contains(d.getNume()) && array[i].contains(d.getPrenume())).findFirst().get());
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void setupNrFisa()
    {
        nrFisaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                newConsultViewModel.getFisaMedicalaMutableLiveData(Integer.valueOf(nrFisaEditText.getText().toString())).observe(getActivity(), response ->{
                    if (response==null)
                        Toast.makeText(getContext(),"Nr. fisa invalid, Introdu numarul unei fise existente", Toast.LENGTH_LONG).show();
                    else{
                        okButton.setClickable(true);
                        consult.setNrFisa(Integer.valueOf(nrFisaEditText.getText().toString()));
                    }
                });
            }
        });
    }

    @Override

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}