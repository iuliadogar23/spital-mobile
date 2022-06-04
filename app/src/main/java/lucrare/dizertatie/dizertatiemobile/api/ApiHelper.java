package lucrare.dizertatie.dizertatiemobile.api;

import android.content.Context;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.api.service.FisaMedicalaApiService;
import lucrare.dizertatie.dizertatiemobile.api.service.SpitalApiService;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
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

}
