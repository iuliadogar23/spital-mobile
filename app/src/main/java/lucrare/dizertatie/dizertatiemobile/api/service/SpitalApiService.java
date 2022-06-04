package lucrare.dizertatie.dizertatiemobile.api.service;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SpitalApiService {

    @GET("consult/find-consults")
    @Headers("Content-Type: application/json")
    Call<List<Object>> getConsultsBy(@Query("doctorId") Integer doctorId);

    @POST("consult/save")
    @Headers("Content-Type: application/json")
    Call<Object> saveConsult(@Body Consult consult);

    @GET("doctor/all")
    @Headers("Content-Type: application/json")
    Call<List<Object>> getAllDoctors();

}
