package lucrare.dizertatie.dizertatiemobile.ui.loginpage;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.api.LoginHelper;
import lucrare.dizertatie.dizertatiemobile.api.service.SpitalApiService;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.request.AuthenticationRequest;
import lucrare.dizertatie.dizertatiemobile.model.response.AuthenticationResponse;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {

    private LoginHelper apiHelper;
    private ApiHelper apiAppHelper;
    private MutableLiveData<AuthenticationResponse> tokenValue;
    private MutableLiveData<Doctor> doctorMutableLiveData;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        apiHelper = new LoginHelper(application.getApplicationContext());
        apiAppHelper = new ApiHelper(application.getApplicationContext());
        tokenValue = new MutableLiveData<>();
        errorCode = new MutableLiveData<>();
        doctorMutableLiveData = new MutableLiveData<>();
        gson = new Gson();
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public MutableLiveData<AuthenticationResponse> loginUser(AuthenticationRequest authenticationRequest) {
        apiHelper.login(authenticationRequest).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);
                if (response.isSuccessful())
                    tokenValue.postValue(gson.fromJson(response.body().toString(), AuthenticationResponse.class));
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }

        });
        return tokenValue;
    }

    public MutableLiveData<Doctor> findDoctorByUsername(String doctor) {
        apiAppHelper.findDoctorByUsername(doctor).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);
                if (response.isSuccessful())
                    doctorMutableLiveData.postValue(gson.fromJson(response.body().toString(), Doctor.class));
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
        return doctorMutableLiveData;

    }

}
