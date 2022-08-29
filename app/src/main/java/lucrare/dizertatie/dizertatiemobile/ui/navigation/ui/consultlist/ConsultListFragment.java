package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.consultlist;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.ConsultListAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentConsultListBinding;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.enums.Status;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class ConsultListFragment extends Fragment {

    @BindView(R.id.consultRecyclerView)
    RecyclerView recyclerView;
    TabLayout tabLayout;



    private FragmentConsultListBinding binding;

    private ConsultListViewModel mViewModel;
    private ConsultListAdapter adapter;
    private List<Consult> items = new ArrayList<>();
    private Integer doctor;

    public static ConsultListFragment newInstance() {
        return new ConsultListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentConsultListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        mViewModel = new ViewModelProvider(this).get(ConsultListViewModel.class);


        doctor = SharedPreferencesUtil.getInstance(getContext()).getDoctor().getId();
        getConsultList(getActivity());

        tabLayout = binding.tabLayout;


        return root;
    }

    private void initComponent(List<Consult> consults) {
        //adapter here
        adapter = new ConsultListAdapter(consults, R.layout.item_consult_card);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((view, obj, position) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("consult", obj);
            Navigation.findNavController(view).navigate(R.id.action_nav_consult_list_to_dialogConsultFragment, bundle);
        });
        setupFragment();
    }

    private void getConsultList(LifecycleOwner lifecycleOwner)
    {
        mViewModel.findByConsults(doctor).observe(lifecycleOwner, consults -> {
            if (consults!=null && consults.getConsults()!=null) {
                items.addAll(consults.getConsults());
                initComponent(items.stream().filter(c->c.getStatus().equals(Status.ACCEPTAT.toString()) && c.getDoctorSolicitat().getId().equals(doctor)).collect(Collectors.toList()));
            }

        });

    }

    private void setupFragment()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getText().toString()) {
                    case "Programari":
                        initComponent(items.stream().filter(c->c.getStatus().equals(Status.ACCEPTAT.toString()) && c.getDoctorSolicitat().getId().equals(doctor)).collect(Collectors.toList()));
                        break;
                    case "In asteptare":
                        initComponent(items.stream().filter(c->c.getStatus().equals(Status.IN_ASTEPTARE.toString()) && c.getDoctorSolicitat().getId().equals(doctor)).collect(Collectors.toList()));
                        break;
                    case "Istoric":
                        initComponent(items.stream().filter(c->c.getStatus().equals(Status.ISTORIC.toString())).collect(Collectors.toList()));
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}