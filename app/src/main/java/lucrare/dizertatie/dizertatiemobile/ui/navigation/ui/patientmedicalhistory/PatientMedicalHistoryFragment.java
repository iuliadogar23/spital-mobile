package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.patientmedicalhistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.PatientsMedicalHistoryAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentPatientMedicalHistoryBinding;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;

public class PatientMedicalHistoryFragment extends Fragment {

    @BindView(R.id.consultRecyclerView)
    RecyclerView recyclerView;

    private PatientsMedicalHistoryAdapter adapter;
    private List<FisaMedicala> items = new ArrayList<>();

    private PatientMedicalHistoryViewModel mViewModel;
    private FragmentPatientMedicalHistoryBinding binding;

    public static PatientMedicalHistoryFragment newInstance() {
        return new PatientMedicalHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPatientMedicalHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);

        return root;
    }

    private void initComponent(List<FisaMedicala> fisaMedicalaList)
    {
        adapter = new PatientsMedicalHistoryAdapter(fisaMedicalaList, R.layout.item_consult_card);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((view, obj, position) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("fisa", obj);
            Intent intent = new Intent();
            startActivity(intent, bundle);
        });
    }

    private void getPatientsHistory(LifecycleOwner lifecycleOwner)
    {
        //call request din view model pentru get all fisa medicala
    }

}