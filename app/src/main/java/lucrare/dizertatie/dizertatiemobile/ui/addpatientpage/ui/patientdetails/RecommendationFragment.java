package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;

public class RecommendationFragment extends Fragment {

    public static RecommendationFragment newInstance() {
        return new RecommendationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.row_recommendation, container, false);
        ButterKnife.bind(this, root);

        return root;
    }
}