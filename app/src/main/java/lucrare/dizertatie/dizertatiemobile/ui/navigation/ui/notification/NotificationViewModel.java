package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;
import lucrare.dizertatie.dizertatiemobile.model.response.NotificareResponse;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationViewModel extends AndroidViewModel {
    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;
    private MutableLiveData<NotificareResponse> notificare;

    public NotificationViewModel(@NonNull Application application) {
        super(application);
        apiHelper = new ApiHelper(application.getApplicationContext());
        errorCode = new MutableLiveData<>();
        gson = new Gson();
        notificare = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorCode() {
        return errorCode;
    }

    public MutableLiveData<NotificareResponse> getAllNotificare() {
        apiHelper.getAllNotificare().enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
                NotificareResponse notificareResponse = new NotificareResponse();
                errorCode.postValue(null);

                notificareResponse.setNotificareList(gson.fromJson(gson.toJson(response.body()), TypeToken.getParameterized(ArrayList.class, Notificare.class).getType()));
                notificare.setValue(notificareResponse);
            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t) {
                errorCode.postValue(Constants.NETWORK_ERROR);
            }
        });

        return notificare;
    }
}