package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.patientregister;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import lucrare.dizertatie.dizertatiemobile.databinding.FragmentPatientRegisterBinding;
 //ex gallery
public class PatientRegisterFragment extends Fragment {

    private FragmentPatientRegisterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PatientRegisterViewModel galleryViewModel =
                new ViewModelProvider(this).get(PatientRegisterViewModel.class);

        binding = FragmentPatientRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}