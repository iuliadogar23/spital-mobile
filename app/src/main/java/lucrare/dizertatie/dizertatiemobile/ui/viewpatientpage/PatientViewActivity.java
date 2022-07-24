package lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage;

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
import lucrare.dizertatie.dizertatiemobile.databinding.ActivityPatientViewBinding;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.AnalysisFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.EkgFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.PathologicalBackgroundFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.PatientDetailsFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.RecommendationFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.StateFragment;
import lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails.TriageFragment;
import lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails.AnalysisViewFragment;
import lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails.EkgViewFragment;
import lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails.PathologicalBackgroundViewFragment;
import lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails.PatientDetailsViewFragment;
import lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails.RecommendationViewFragment;
import lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails.StateViewFragment;
import lucrare.dizertatie.dizertatiemobile.ui.viewpatientpage.patientdetails.TriageViewFragment;

public class PatientViewActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_pacient_view)
    ViewPager viewPager;

    ActivityPatientViewBinding binding;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPatientViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ButterKnife.bind(this);

        setupViewPager();
    }

    private void setupViewPager() {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        new Handler().post(() -> {

            viewPagerAdapter.addFragment(PatientDetailsViewFragment.newInstance(), "Pacient");
            viewPagerAdapter.addFragment(StateViewFragment.newInstance(), "Stare");
            viewPagerAdapter.addFragment(PathologicalBackgroundViewFragment.newInstance(), "Antecedente");
            viewPagerAdapter.addFragment(TriageViewFragment.newInstance(), "Triaj");
            viewPagerAdapter.addFragment(EkgViewFragment.newInstance(), "Observatii");
            viewPagerAdapter.addFragment(AnalysisViewFragment.newInstance(), "Analize");
            viewPagerAdapter.addFragment(RecommendationViewFragment.newInstance(), "Recomandari");

            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        });

    }
}