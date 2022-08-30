package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.model.response.ConsultResponse;
import lucrare.dizertatie.dizertatiemobile.model.response.FisaMedicalaResponse;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends AndroidViewModel {

    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;
    private MutableLiveData<FisaMedicalaResponse> fisaMedicalaList;

    public HomeViewModel(@NonNull Application application) {
            super(application);
            apiHelper = new ApiHelper(application.getApplicationContext());
            errorCode = new MutableLiveData<>();
            gson = new Gson();
            fisaMedicalaList = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public MutableLiveData<FisaMedicalaResponse> getAllFisaMedicala() {
        apiHelper.getAllFisaMedicala().enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
                FisaMedicalaResponse fisaMedicalaResponse = new FisaMedicalaResponse();
                errorCode.postValue(null);

                fisaMedicalaResponse.setFisaMedicalaList(gson.fromJson(gson.toJson(response.body()), TypeToken.getParameterized(ArrayList.class, FisaMedicala.class).getType()));
                fisaMedicalaList.postValue(fisaMedicalaResponse);
            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });

        return fisaMedicalaList;
    }

    public MutableLiveData<FisaMedicalaResponse> getAllActiveFisaMedicala()
    {
        apiHelper.getFisaMedicalaActive().enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
                FisaMedicalaResponse fisaMedicalaResponse = new FisaMedicalaResponse();
                errorCode.postValue(null);

                fisaMedicalaResponse.setFisaMedicalaList(gson.fromJson(gson.toJson(response.body()), TypeToken.getParameterized(ArrayList.class, FisaMedicala.class).getType()));
                fisaMedicalaList.postValue(fisaMedicalaResponse);
            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });

        return fisaMedicalaList;
    }


}