package lucrare.dizertatie.dizertatiemobile.api.service;

import lucrare.dizertatie.dizertatiemobile.model.request.AuthenticationRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApiService {

    @POST("cont/login")
    @Headers("Content-Type: application/json")
    Call<Object> login(@Body AuthenticationRequest authenticationRequest);

}
