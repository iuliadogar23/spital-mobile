package lucrare.dizertatie.dizertatiemobile.api.service;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.notificare.Mesaj;
import lucrare.dizertatie.dizertatiemobile.model.request.AuthenticationRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MesajApiService {

    @POST("mesaj/save")
    @Headers("Content-Type: application/json")
    Call<Object> save(@Body Mesaj mesaj);

    @GET("mesaj/uid")
    @Headers("Content-Type: application/json")
    Call<List<Object>> getAllByUid(@Query("uid") String uid);

    @GET("mesaj/receiver")
    @Headers("Content-Type: application/json")
    Call<List<Object>> getAllByReceiver(@Query("receiver") String receiver);

}
