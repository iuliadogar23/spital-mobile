package lucrare.dizertatie.dizertatiemobile.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPreferencesUtil {

    private static final String APP_PREFS = "AppPrefs";
    private static final String TOKEN_USER = "token";
    private static final String LOGGED_DOCTOR = "doctor";

    private SharedPreferences sharedPrefs;
    private static SharedPreferencesUtil instance;
    private static Gson gson = new Gson();

    private SharedPreferencesUtil(Context context) {
        sharedPrefs =
                context.getApplicationContext().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }


    public static synchronized SharedPreferencesUtil getInstance(Context context){
        if(instance == null)
            instance = new SharedPreferencesUtil(context);

        return instance;
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(TOKEN_USER, "Bearer "+token);
        editor.apply();
        editor.commit();
    }

    public String getToken() {
        return sharedPrefs.getString(TOKEN_USER, null);
    }

    public void setDoctor(Long doctor) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(LOGGED_DOCTOR, Math.toIntExact(doctor));
        editor.apply();
        editor.commit();
    }

    public Integer getDoctor()
    {
        return sharedPrefs.getInt(LOGGED_DOCTOR, 0);
    }

}
