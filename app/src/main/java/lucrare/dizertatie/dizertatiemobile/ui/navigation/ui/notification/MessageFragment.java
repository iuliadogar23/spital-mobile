package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.DoctorReplyActivityAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentNotificationBinding;
import lucrare.dizertatie.dizertatiemobile.ui.mainpage.MainActivity;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class MessageFragment extends Fragment {

    @BindView(R.id.notificare_recycle_view)
    RecyclerView recyclerView;

    private FragmentNotificationBinding binding;
    SharedPreferencesUtil sharedPreferencesUtil;
    NotificationHelper notificationHelper;
    DoctorReplyActivityAdapter adapterReply;

    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getContext());
        notificationHelper = new NotificationHelper(getContext());

        setupViewModel();

        return root;
    }

    private void setupViewModel() {

        notificationHelper.getMesajeByReceiver(sharedPreferencesUtil.getDoctor().getId().toString()).observe(((MainActivity)getActivity()), mesajResponse -> {
            if (mesajResponse!=null && mesajResponse.getMesaje()!=null)
            {
                adapterReply = new DoctorReplyActivityAdapter(mesajResponse.getMesaje(), getContext(), R.layout.item_message_card, ((MainActivity)getContext()).getmPubnub_DataStream(), sharedPreferencesUtil);
                recyclerView.setAdapter(adapterReply);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }

}