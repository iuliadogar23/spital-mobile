package lucrare.dizertatie.dizertatiemobile.ui.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.presence.PNHereNowChannelData;
import com.pubnub.api.models.consumer.presence.PNHereNowOccupantData;
import com.pubnub.api.models.consumer.presence.PNHereNowResult;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.adapters.DoctorActivityAdapter;
import lucrare.dizertatie.dizertatiemobile.databinding.ActivityMainBinding;
import lucrare.dizertatie.dizertatiemobile.pubsub.PresencePnCallback;
import lucrare.dizertatie.dizertatiemobile.pubsub.PresencePojo;
import lucrare.dizertatie.dizertatiemobile.pubsub.PubSubPnCallback;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.consultlist.ConsultListFragment;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.home.HomeFragment;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.newconsult.NewConsultFragment;
import lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification.NotificationFragment;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.nav_view)
    public NavigationView navigationView;
    Menu bellMenu;
    MenuItem menuItem;
    public DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;
    ActivityMainBinding binding;

    private PubNub mPubnub_DataStream;
    private PubSubPnCallback mPubSubPnCallback;

    private PresencePnCallback mPresencePnCallback;
    SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ButterKnife.bind(this);
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
        initDrawer();
        initToolbar();
        initNavigationMenu();
    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
    }

    private void initToolbar() {

        setActionBarTitleFragment();
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_consult_registration, R.id.nav_consult_list, R.id.patientMedicalHistoryFragment) //poate aici vine notification nav daca faci idk
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
        bellMenu = menu;
        menuItem = bellMenu.findItem(R.id.action_notifications);
//        menuItem.setOnMenuItemClickListener(item -> {
//            drawerLayout.closeDrawer(GravityCompat.START);
//            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_general, new NotificationFragment()).addToBackStack(null).commit();
//            return true;
//        });
        this.mPubSubPnCallback = new PubSubPnCallback(menuItem, getApplicationContext());
        this.mPresencePnCallback = new PresencePnCallback();
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
        initPubNub();
        initChannels();

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_general);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == R.id.action_notifications) {
            drawerLayout.closeDrawer(GravityCompat.START);
            getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.nav_host_fragment_content_general, new NotificationFragment()).addToBackStack(null).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.menu_home:
                getSupportFragmentManager().popBackStack();
                navigationView.setCheckedItem(R.id.nav_home);
                getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment_content_general, new HomeFragment()).addToBackStack(null).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
//            case R.id.menu_patient_register:
//                getSupportFragmentManager().popBackStack();
//                navigationView.setCheckedItem(R.id.nav_patient_registration);
//                drawerLayout.closeDrawer(GravityCompat.START);
//                getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.nav_host_fragment_content_general, new PatientRegisterFragment()).addToBackStack(null).commit();
//                break;
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
                getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment_content_general, new ConsultListFragment()).addToBackStack(null).commit();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null && result.getContents() != null){

        }

    }

    private void initPubNub() {

        String uuid = String.valueOf(sharedPreferencesUtil.getDoctor().getId());
        PNConfiguration config = new PNConfiguration();
        config.setPublishKey(Constants.PUBNUB_PUBLISH_KEY);
        config.setSubscribeKey(Constants.PUBNUB_SUBSCRIBE_KEY);
        config.setUuid(uuid);
        config.setSecure(true);
        mPubnub_DataStream = new PubNub(config);
//        this.mPubnub_Multi = new PubNub(config);
    }

    private void initChannels() {
        String channel = String.valueOf(sharedPreferencesUtil.getDoctor().getId());
        mPubnub_DataStream.addListener(mPubSubPnCallback);
        mPubnub_DataStream.addListener(mPresencePnCallback);
        mPubnub_DataStream.subscribe().channels(Arrays.asList(channel)).execute();
        this.mPubnub_DataStream.hereNow().channels(Arrays.asList("common")).async(new PNCallback<PNHereNowResult>() {
            @Override
            public void onResponse(PNHereNowResult result, PNStatus status) {
                if (status.isError()) {
                    return;
                }

                try {

                    for (Map.Entry<String, PNHereNowChannelData> entry : result.getChannels().entrySet()) {
                        for (PNHereNowOccupantData occupant : entry.getValue().getOccupants()) {
                            MainActivity.this.mPresencePnCallback.addPresenceInList(new PresencePojo(occupant.getUuid(), "join", new Timestamp(Calendar.getInstance().getTimeInMillis()).toString()));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });    }

    public PubNub getmPubnub_DataStream() {
        return mPubnub_DataStream;
    }

    public PresencePnCallback getmPresencePnCallback() {
        return mPresencePnCallback;
    }

    public void setActionBarTitleFragment()
    {
        setSupportActionBar(binding.appBarGeneral.toolbar);
        getSupportActionBar().setTitle("");
    }

    private void disconnectAndCleanup() {
        getSharedPreferences(Constants.DATASTREAM_PREFS, MODE_PRIVATE).edit().clear().commit();

        if (this.mPubnub_DataStream != null) {
            this.mPubnub_DataStream.unsubscribe().execute();
            this.mPubnub_DataStream.removeListener(this.mPubSubPnCallback);
            this.mPubnub_DataStream.removeListener(this.mPresencePnCallback);
            this.mPubnub_DataStream.stop();
            this.mPubnub_DataStream = null;
        }

    }
}
