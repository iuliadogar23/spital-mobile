package lucrare.dizertatie.dizertatiemobile.api.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FisaMedicalaApiService {

    @GET("fisa-medicala/all")
    @Headers("Content-Type: application/json")
    Call<List<Object>> getAllFisaMedicala();

}
