package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.hospitalactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pubnub.api.PubNub;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.DoctorActivityAdapter;
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


    public static HospitalActivityFragment newInstance() {
        return new HospitalActivityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHospitalActivityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        recyclerView.setAdapter(((MainActivity)getActivity()).getAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }


}