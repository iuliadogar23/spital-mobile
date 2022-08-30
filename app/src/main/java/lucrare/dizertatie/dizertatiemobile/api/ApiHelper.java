package lucrare.dizertatie.dizertatiemobile.api;

import android.content.Context;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.api.service.FisaMedicalaApiService;
import lucrare.dizertatie.dizertatiemobile.api.service.NotificareApiService;
import lucrare.dizertatie.dizertatiemobile.api.service.ResurseApiService;
import lucrare.dizertatie.dizertatiemobile.api.service.SpitalApiService;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.notificare.Notificare;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.Pat;
import lucrare.dizertatie.dizertatiemobile.model.resourcesmodel.SalaOperatie;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {

    private SpitalApiService spitalApiService;

    private FisaMedicalaApiService fisaMedicalaApiService;

    private NotificareApiService notificareApiService;

    private ResurseApiService resurseApiService;

    public ApiHelper(Context context) {

        Cache cache = new Cache(context.getApplicationContext().getCacheDir(), 1024*10*10);

        String token = SharedPreferencesUtil.getInstance(context).getToken();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {

                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Authorization", token)
                            .build();

                    return chain.proceed(newRequest);
                })
                .cache(cache)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        spitalApiService = retrofit.create(SpitalApiService.class);
        fisaMedicalaApiService = retrofit.create(FisaMedicalaApiService.class);
        notificareApiService = retrofit.create(NotificareApiService.class);
        resurseApiService = retrofit.create(ResurseApiService.class);
    }

    public Call<List<Object>> findConsultsBy(Integer doctorId) {
        return spitalApiService.getConsultsBy(doctorId);
    }

    public Call<Object> saveConsult(Consult consult) {
        return spitalApiService.saveConsult(consult);
    }

    public Call<List<Object>> getAllFisaMedicala() {
        return fisaMedicalaApiService.getAllFisaMedicala();
    }

    public Call<List<Object>> getAllDoctors() {
        return spitalApiService.getAllDoctors();
    }

    public Call<Object> saveNotificare(Notificare notificare) {
        return notificareApiService.saveNotificare(notificare);
    }

    public Call<Object> findDoctorByUsername(String doctor)
    {
        return spitalApiService.findDoctorByUsername(doctor);
    }

    public Call<List<Object>> getAllNotificare() {
        return notificareApiService.getAllNotificare();
    }

    public Call<Object> savePat(Pat pat)
    {
        return resurseApiService.savePat(pat);
    }

    public Call<Object> saveSalaOperatie(SalaOperatie salaOperatie)
    {
        return resurseApiService.saveSalaOperatie(salaOperatie);
    }

    public Call<Object> saveFisaMedicala(FisaMedicala fisaMedicala)
    {
        return fisaMedicalaApiService.saveFisaMedicala(fisaMedicala);
    }

    public Call<Object> findFisaMedicalaById(Integer id)
    {
        return fisaMedicalaApiService.getFisaMedicalaById(id);
    }

    public Call<List<Object>> getFisaMedicalaActive()
    {
        return fisaMedicalaApiService.getAllFisaMedicalaActive();
    }

}
