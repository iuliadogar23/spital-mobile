package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Mesaj;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;
import lucrare.dizertatie.dizertatiemobile.model.response.DoctorResponse;
import lucrare.dizertatie.dizertatiemobile.model.response.MesajResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationHelper {

    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;
    private MutableLiveData<Notificare> notificare;
    private MutableLiveData<MesajResponse> mesaje;
    private Context context;

    public NotificationHelper(Context context) {
        this.context = context;
        apiHelper = new ApiHelper(context);
        errorCode = new MutableLiveData<>();
        gson = new Gson();
        notificare = new MutableLiveData<>();
        mesaje = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public void saveNotificare(Notificare notificare)
    {
        apiHelper.saveNotificare(notificare).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);
                response.body();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }

    public void saveMesaj(Mesaj mesaj)
    {
        apiHelper.saveMesaj(mesaj).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                errorCode.postValue(null);
                response.body();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<MesajResponse> getMesajeByReceiver(String receiver)
    {
        apiHelper.getMesajeByReceiver(receiver).enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
                MesajResponse mesajResponse = new MesajResponse();
                errorCode.postValue(null);

                mesajResponse.setMesaje(gson.fromJson(gson.toJson(response.body()), TypeToken.getParameterized(ArrayList.class, Mesaj.class).getType()));
                mesaje.postValue(mesajResponse);
            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t) {

            }
        });
        return mesaje;
    }

    public MutableLiveData<MesajResponse> getMesajeByUid(String uid)
    {
        apiHelper.getMesajeByUid(uid).enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
                MesajResponse mesajResponse = new MesajResponse();
                errorCode.postValue(null);

                mesajResponse.setMesaje(gson.fromJson(gson.toJson(response.body()), TypeToken.getParameterized(ArrayList.class, Mesaj.class).getType()));
                mesaje.postValue(mesajResponse);
            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t) {

            }
        });
        return mesaje;
    }

}
