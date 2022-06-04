package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.newconsult;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import lucrare.dizertatie.dizertatiemobile.databinding.FragmentNewConsultBinding;

//ex slideshow
public class NewConsultFragment extends Fragment {

    private FragmentNewConsultBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewConsultViewModel newConsultViewModel =
                new ViewModelProvider(this).get(NewConsultViewModel.class);

        binding = FragmentNewConsultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}