package lucrare.dizertatie.dizertatiemobile.ui.addpatientpage.ui.patientdetails;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.Pat;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.SalaOperatie;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;
import lucrare.dizertatie.dizertatiemobile.util.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateViewModel extends AndroidViewModel {
    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private MutableLiveData<Pat> patMutableLiveData;
    private MutableLiveData<SalaOperatie> salaOperatieMutableLiveData;
    private MutableLiveData<FisaMedicala> fisaMedicalaMutableLiveData;
    private Gson gson;
    private Context context;

    public StateViewModel(@NonNull Application application, Context context) {
        super(application);
        apiHelper = new ApiHelper(application.getApplicationContext());
        errorCode = new MutableLiveData<>();
        patMutableLiveData = new MutableLiveData<>();
        salaOperatieMutableLiveData = new MutableLiveData<>();
        fisaMedicalaMutableLiveData = new MutableLiveData<>();
        gson = new Gson();
        context = context;
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public MutableLiveData<Pat> savePat(Pat pat)
    {
        apiHelper.savePat(pat).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);
                if (response.isSuccessful())
                    patMutableLiveData.postValue(gson.fromJson(response.body().toString(), Pat.class));
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });
        return patMutableLiveData;
    }

    public MutableLiveData<SalaOperatie> saveSalaOperatie(SalaOperatie salaOperatie)
    {
        apiHelper.saveSalaOperatie(salaOperatie).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);
                if (response.isSuccessful())
                    salaOperatieMutableLiveData.postValue(gson.fromJson(response.body().toString(), SalaOperatie.class));
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });
        return salaOperatieMutableLiveData;
    }

    public MutableLiveData<FisaMedicala> saveFisaMedicala(FisaMedicala fisaMedicala)
    {
        Doctor d = SharedPreferencesUtil.getInstance(context).getDoctor();
        fisaMedicala.setDoctorAsignat(d.getId());
        fisaMedicala.setDoctorRecent(Utils.setDoctorTitle(d));

        apiHelper.saveFisaMedicala(fisaMedicala).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);
                if (response.isSuccessful()) {
                    JsonReader reader = new JsonReader(new StringReader(gson.toJson(response.body())));
                    reader.setLenient(true);
                    fisaMedicalaMutableLiveData.postValue(gson.fromJson(reader, FisaMedicala.class));
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });
        return fisaMedicalaMutableLiveData;
    }
}
