package lucrare.dizertatie.dizertatiemobile.api;

import android.content.Context;

import lucrare.dizertatie.dizertatiemobile.api.service.LoginApiService;
import lucrare.dizertatie.dizertatiemobile.model.request.AuthenticationRequest;
import lucrare.dizertatie.dizertatiemobile.util.Constants;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginHelper {

    private LoginApiService loginApiService;

    public LoginHelper(Context context) {
        Cache cache = new Cache(context.getApplicationContext().getCacheDir(), 1024*10*10);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginApiService = retrofit.create(LoginApiService.class);
    }

    public Call<Object> login(AuthenticationRequest authenticationRequest) {
        return loginApiService.login(authenticationRequest);
    }

}
