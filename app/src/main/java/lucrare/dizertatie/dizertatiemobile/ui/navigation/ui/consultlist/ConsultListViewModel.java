package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.consultlist;

import android.app.Application;
import android.util.JsonReader;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.response.AuthenticationResponse;
import lucrare.dizertatie.dizertatiemobile.model.response.ConsultResponse;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultListViewModel extends AndroidViewModel {

    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;
    private MutableLiveData<ConsultResponse> consults;

    public ConsultListViewModel(@NonNull Application application) {
        super(application);
        apiHelper = new ApiHelper(application.getApplicationContext());
        errorCode = new MutableLiveData<>();
        gson = new Gson();
        consults = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public MutableLiveData<ConsultResponse> findByConsults(Integer doctorId) {

        apiHelper.findConsultsBy(doctorId).enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {

                ConsultResponse consultResponse = new ConsultResponse();
                errorCode.postValue(null);

                consultResponse.setConsults(gson.fromJson(gson.toJson(response.body()), TypeToken.getParameterized(ArrayList.class, Consult.class).getType()));
                consults.postValue(consultResponse);

            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }

        });
        return consults;
    }
}