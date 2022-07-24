package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.ViewPagerAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.ActivityPatientBinding;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.AnalysisFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.EkgFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.PathologicalBackgroundFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.PatientDetailsFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.RecommendationFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.StateFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.TriageFragment;

public class PatientActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_pacient_view)
    ViewPager viewPager;

    ActivityPatientBinding binding;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPatientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ButterKnife.bind(this);

        setupViewPager();

    }

    private void setupViewPager() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        new Handler().post(() -> {

            viewPagerAdapter.addFragment(PatientDetailsFragment.newInstance(), "Pacient");
            viewPagerAdapter.addFragment(StateFragment.newInstance(), "Stare");
            viewPagerAdapter.addFragment(PathologicalBackgroundFragment.newInstance(), "Antecedente");
            viewPagerAdapter.addFragment(TriageFragment.newInstance(), "Triaj");
            viewPagerAdapter.addFragment(EkgFragment.newInstance(), "Observatii");
            viewPagerAdapter.addFragment(AnalysisFragment.newInstance(), "Analize");
            viewPagerAdapter.addFragment(RecommendationFragment.newInstance(), "Recomandari");

            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        });

    }

}