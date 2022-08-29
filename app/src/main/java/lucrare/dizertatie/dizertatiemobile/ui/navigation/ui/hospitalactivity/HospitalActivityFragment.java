package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.hospitalactivity;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pubnub.api.PubNub;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.DoctorActivityAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentConsultListBinding;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentHospitalActivityBinding;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.ui.mainpage.MainActivity;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class HospitalActivityFragment extends Fragment {

    @BindView(R.id.consultRecyclerView)
    RecyclerView recyclerView;

    private DoctorActivityAdapter adapter;
    private HospitalActivityViewModel mViewModel;
    private FragmentHospitalActivityBinding binding;
    private List<Doctor> items = new ArrayList<>();
    private PubNub pubNub;
    SharedPreferencesUtil sharedPreferencesUtil;

    public static HospitalActivityFragment newInstance() {
        return new HospitalActivityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHospitalActivityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getContext());
        pubNub = ((MainActivity)getActivity()).getmPubnub_DataStream();

        setupViewModel();
        initComponent();

        return root;
    }

    private void initComponent()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }

    private void setupViewModel()
    {
        mViewModel = new ViewModelProvider(this).get(HospitalActivityViewModel.class);
        mViewModel.getAllDoctors().observe(getActivity(), doctorResponse -> {
            if (doctorResponse!=null && doctorResponse.getDoctorList()!=null)
                items.addAll(doctorResponse.getDoctorList());
            adapter = new DoctorActivityAdapter(items, getContext(), R.layout.item_doctor_activity, pubNub, sharedPreferencesUtil);
            recyclerView.setAdapter(adapter);

        });
    }

}