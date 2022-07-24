package lucrare.dizertatie.dizertatiemobile.api.service;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificareApiService {

    @POST("notificare/save")
    @Headers("Content-Type: application/json")
    Call<Object> saveNotificare(@Body Notificare notificare);

    @GET("notificare/get")
    @Headers("Content-Type: application/json")
    Call<List<Object>> getAllNotificare();

}
