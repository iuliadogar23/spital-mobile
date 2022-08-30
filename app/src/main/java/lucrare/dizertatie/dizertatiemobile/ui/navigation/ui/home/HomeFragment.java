package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.PatientSearchAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentHomeBinding;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.PatientActivity;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    @BindView(R.id.new_patient_button)
    CardView newPatientButton;
    @BindView(R.id.new_consult_button)
    CardView newConsultButton;
    @BindView(R.id.consult_list_button)
    CardView consultListButton;
    @BindView(R.id.hospital_activity_button)
    CardView hospitalActivityButton;
    @BindView(R.id.view_patient_button)
    CardView patientMedicalHistoryButton;
    @BindView(R.id.et_search)
    AutoCompleteTextView search;
    @BindView(R.id.fab)
    FloatingActionButton searchButton;
    @BindView(R.id.fab_qr)
    FloatingActionButton qrButton;

    PatientSearchAdapter adapter;
    HomeViewModel homeViewModel;

    //get all fise from request
    private List<FisaMedicala> fiseReturn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ButterKnife.bind(this, root);
        getAllFisaMedicala(getActivity());
        setNavigationToOptions(root);
        initButtons();

        return root;
    }

    private void setNavigationToOptions(View view) {
        newPatientButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), PatientActivity.class);
            startActivity(intent);
        });

        patientMedicalHistoryButton.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.patientMedicalHistoryFragment));

        newConsultButton.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_new_consult));

        consultListButton.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_nav_home_to_consultListFragment));

        hospitalActivityButton.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_nav_home_to_hospitalActivityFragment));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getAllFisaMedicala(LifecycleOwner lifecycleOwner) {
        homeViewModel.getAllFisaMedicala().observe(lifecycleOwner, fisa -> {
            if (fisa.getFisaMedicalaList() != null && !fisa.getFisaMedicalaList().isEmpty()) {
                fiseReturn = fisa.getFisaMedicalaList();
                adapter = new PatientSearchAdapter(getContext(), fiseReturn);
                search.setAdapter(adapter);
            } else {
                Toast.makeText(getContext(), "Niciun pacient gasit!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initButtons() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setAdapter(adapter);
            }
        });

        qrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = IntentIntegrator.forSupportFragment(HomeFragment.this);

                integrator.setOrientationLocked(false);
                integrator.setPrompt("Scaneaza cod QR");
                integrator.setBeepEnabled(true);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);

                integrator.initiateScan();

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}