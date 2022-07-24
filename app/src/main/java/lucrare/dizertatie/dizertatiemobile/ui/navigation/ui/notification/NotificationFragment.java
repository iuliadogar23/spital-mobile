package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.NotificationListAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentNotificationBinding;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;

public class NotificationFragment extends Fragment {

    @BindView(R.id.notificare_recycle_view)
    RecyclerView recyclerView;

    private NotificationViewModel mViewModel;
    private NotificationListAdapter adapter;
    private FragmentNotificationBinding binding;
    private List<Notificare> items = new ArrayList<>();

    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);

        setupViewModel();

        return root;
    }

    private void setupViewModel() {
        mViewModel = new ViewModelProvider(this).get(NotificationViewModel.class);
        mViewModel.getAllNotificare().observe(getViewLifecycleOwner(), notificareResponse -> {
            if (notificareResponse.getNotificareList() != null)
                items.addAll(notificareResponse.getNotificareList());
            adapter = new NotificationListAdapter(items, getContext(), R.layout.item_notificare_card);
            recyclerView.setAdapter(adapter);

        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }

}