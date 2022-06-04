package lucrare.dizertatie.dizertatiemobile.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.model.request.AuthenticationRequest;
import lucrare.dizertatie.dizertatiemobile.ui.mainpage.MainActivity;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.text_input_login_username)
    TextInputEditText username;
    @BindView(R.id.text_input_login_password)
    TextInputEditText password;
    @BindView(R.id.button_login)
    Button button;

    private LoginViewModel viewModel;
    private SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginButtonClicked(this);
    }

    private void loginButtonClicked(LifecycleOwner lifecycleOwner)
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthenticationRequest authenticationRequest = new AuthenticationRequest();
                authenticationRequest.setUsername(username.getText().toString());
                authenticationRequest.setPassword(password.getText().toString());

                viewModel.loginUser(authenticationRequest).observe(lifecycleOwner, token -> {
                    sharedPreferencesUtil.setToken(token.getToken());
                    sharedPreferencesUtil.setDoctor(token.getId());
                });

                viewModel.getErrorCode().observe(lifecycleOwner, errorCode -> {
                    if (errorCode!=null && errorCode == Constants.NETWORK_ERROR)
                        Toast.makeText(getApplicationContext(), "Autentificarea a esuat!", Toast.LENGTH_LONG);
                    else
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

}