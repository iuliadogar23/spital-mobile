package lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;

public class TriageViewFragment extends Fragment {
    public static TriageViewFragment newInstance() {
        return new TriageViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.row_triage_view, container, false);
        ButterKnife.bind(this, root);

        return root;
    }
}