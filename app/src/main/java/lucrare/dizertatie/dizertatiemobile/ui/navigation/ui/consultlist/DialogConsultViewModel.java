package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.consultlist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogConsultViewModel extends AndroidViewModel {

    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;

    public DialogConsultViewModel(@NonNull Application application) {
        super(application);
        apiHelper = new ApiHelper(application.getApplicationContext());
        errorCode = new MutableLiveData<>();
        gson = new Gson();
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
