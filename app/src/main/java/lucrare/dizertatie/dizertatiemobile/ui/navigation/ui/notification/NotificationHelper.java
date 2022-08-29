package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.notification;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import lucrare.dizertatie.dizertatiemobile.api.ApiHelper;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationHelper {

    private ApiHelper apiHelper;
    private MutableLiveData<Integer> errorCode;
    private Gson gson;
    private MutableLiveData<Notificare> notificare;
    private Context context;

    public NotificationHelper(Context context) {
        this.context = context;
        apiHelper = new ApiHelper(context);
        errorCode = new MutableLiveData<>();
        gson = new Gson();
        notificare = new MutableLiveData<>();
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

}
