package lucrare.dizertatie.dizertatiemobile.api.service;

import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.Pat;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.SalaOperatie;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ResurseApiService {

    @POST("pat/update")
    @Headers("Content-Type: application/json")
    Call<Object> savePat(@Body Pat consult);

    @POST("sala-operatie/update")
    @Headers("Content-Type: application/json")
    Call<Object> saveSalaOperatie(@Body SalaOperatie consult);

}
