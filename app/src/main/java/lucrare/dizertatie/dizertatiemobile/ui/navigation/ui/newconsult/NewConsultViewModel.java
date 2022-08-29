package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.newconsult;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewConsultViewModel extends AndroidViewModel {

    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;
    private MutableLiveData<FisaMedicala> fisaMedicalaMutableLiveData;

    public NewConsultViewModel(@NonNull Application application) {
        super(application);
        apiHelper = new ApiHelper(application.getApplicationContext());
        errorCode = new MutableLiveData<>();
        gson = new Gson();
        fisaMedicalaMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public MutableLiveData<FisaMedicala> getFisaMedicalaMutableLiveData(Integer id) {
        apiHelper.findFisaMedicalaById(id).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);

                fisaMedicalaMutableLiveData.setValue(gson.fromJson(response.body().toString(), FisaMedicala.class));
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });
        return fisaMedicalaMutableLiveData;
    }

    public void saveConsult(Consult consult) {
        apiHelper.saveConsult(consult).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);

            }
            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }

        });
    }
}