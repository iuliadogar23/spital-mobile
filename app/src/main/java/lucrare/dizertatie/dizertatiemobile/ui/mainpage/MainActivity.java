package lucrare.dizertatie.dizertatiemobile.ui.mainpage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.databinding.ActivityMainBinding;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.consultlist.ConsultListFragment;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.home.HomeFragment;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.patientregister.PatientRegisterFragment;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.newconsult.NewConsultFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActionBar actionBar;
    @BindView(R.id.nav_view)
    public NavigationView navigationView;
    public DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ButterKnife.bind(this);
        initDrawer();
        initToolbar();
        initNavigationMenu();

    }

    private void initToolbar() {
//        actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setTitle("");
        setSupportActionBar(binding.appBarGeneral.toolbar);
        getSupportActionBar().setTitle("");
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_patient_registration, R.id.nav_consult_registration, R.id.nav_consult_list)
                .setOpenableLayout(drawerLayout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_general);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    private void initDrawer() {
        drawerLayout = binding.mainDrawerLayout;

        binding.menuHome.setOnClickListener(this);
        binding.menuPatientRegister.setOnClickListener(this);
        binding.menuPatientSearch.setOnClickListener(this);
    }

    private void initNavigationMenu() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

//        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_message, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_general);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.menu_home:
                getSupportFragmentManager().popBackStack();
                navigationView.setCheckedItem(R.id.nav_home);
                getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment_content_general, new HomeFragment()).addToBackStack(null).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.menu_patient_register:
                getSupportFragmentManager().popBackStack();
                navigationView.setCheckedItem(R.id.nav_patient_registration);
                drawerLayout.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.nav_host_fragment_content_general, new PatientRegisterFragment()).addToBackStack(null).commit();
                break;
            case R.id.menu_patient_search:
                getSupportFragmentManager().popBackStack();
                navigationView.setCheckedItem(R.id.nav_consult_registration);
                drawerLayout.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_general, new NewConsultFragment()).addToBackStack(null).commit();
                break;
            case R.id.menu_all_consults:
                getSupportFragmentManager().popBackStack();
                navigationView.setCheckedItem(R.id.nav_consult_list);
                drawerLayout.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_general, new ConsultListFragment()).addToBackStack(null).commit();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null && result.getContents() != null)
        {
            //aici return fisa nr => open fisa nr detalii
        }

    }
}
