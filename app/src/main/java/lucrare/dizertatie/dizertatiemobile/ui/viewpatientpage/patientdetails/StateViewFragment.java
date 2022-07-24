package lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;

public class StateViewFragment extends Fragment {

    public static StateViewFragment newInstance() {
        return new StateViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.row_state_view, container, false);
        ButterKnife.bind(this, root);

        return root;
    }
}