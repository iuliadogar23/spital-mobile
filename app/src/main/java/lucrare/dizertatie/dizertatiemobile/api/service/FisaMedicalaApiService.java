package lucrare.dizertatie.dizertatiemobile.api.service;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.SalaOperatie;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FisaMedicalaApiService {

    @GET("fisa-medicala/all")
    @Headers("Content-Type: application/json")
    Call<List<Object>> getAllFisaMedicala();

    @GET("fisa-medicala/id")
    @Headers("Content-Type: application/json")
    Call<Object> getFisaMedicalaById(@Query("id") Integer id);

    @POST("fisa-medicala/save")
    @Headers("Content-Type: application/json")
    Call<Object> saveFisaMedicala(@Body FisaMedicala fisaMedicala);

}
