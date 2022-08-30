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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.PatientsMedicalHistoryAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentPatientMedicalHistoryBinding;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.ui.mainpage.MainActivity;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.home.HomeViewModel;

public class PatientMedicalHistoryFragment extends Fragment {

    @BindView(R.id.consultRecyclerView)
    RecyclerView recyclerView;

    private PatientsMedicalHistoryAdapter adapter;
    private List<FisaMedicala> items = new ArrayList<>();

    private HomeViewModel mViewModel;
    private FragmentPatientMedicalHistoryBinding binding;

    public static PatientMedicalHistoryFragment newInstance() {
        return new PatientMedicalHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPatientMedicalHistoryBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        ((MainActivity)getActivity()).setActionBarTitleFragment();
        getPatientsHistory();

        return root;
    }

    private void initComponent(List<FisaMedicala> fisaMedicalaList)
    {
        adapter = new PatientsMedicalHistoryAdapter(fisaMedicalaList, R.layout.item_consult_card);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

//        adapter.setOnItemClickListener((view, obj, position) -> {
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("fisa", obj);
//            Intent intent = new Intent();
//            startActivity(intent, bundle);
//        });
    }

    private void getPatientsHistory()
    {
        mViewModel.getAllActiveFisaMedicala().observe(getActivity(), fisaMedicalaResponse -> initComponent(fisaMedicalaResponse.getFisaMedicalaList()));
    }

}