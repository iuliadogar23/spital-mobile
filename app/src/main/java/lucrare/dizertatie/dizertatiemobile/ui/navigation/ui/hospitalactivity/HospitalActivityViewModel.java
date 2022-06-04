package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.hospitalactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.response.DoctorResponse;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalActivityViewModel extends AndroidViewModel {

    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;
    private MutableLiveData<DoctorResponse> doctors;

    public HospitalActivityViewModel(@NonNull Application application) {
        super(application);
        apiHelper = new ApiHelper(application.getApplicationContext());
        errorCode = new MutableLiveData<>();
        gson = new Gson();
        doctors = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public MutableLiveData<DoctorResponse> getAllDoctors() {
        apiHelper.getAllDoctors().enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
                DoctorResponse doctorResponse = new DoctorResponse();
                errorCode.postValue(null);

                doctorResponse.setDoctorList(gson.fromJson(gson.toJson(response.body()), TypeToken.getParameterized(ArrayList.class, Doctor.class).getType()));
                doctors.setValue(doctorResponse);
            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });

        return doctors;
    }
}