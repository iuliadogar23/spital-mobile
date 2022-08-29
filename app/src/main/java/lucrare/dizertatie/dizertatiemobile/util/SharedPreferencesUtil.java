package lucrare.dizertatie.dizertatiemobile.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;

public class SharedPreferencesUtil {

    private static final String APP_PREFS = "AppPrefs";
    private static final String TOKEN_USER = "token";
    private static final String LOGGED_DOCTOR = "doctor";
    private static final String NEW_FISA="fisa";

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

    public void setDoctor(Doctor doctor) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(LOGGED_DOCTOR, gson.toJson(doctor));
        editor.apply();
        editor.commit();
    }

    public Doctor getDoctor()
    {
        return gson.fromJson(sharedPrefs.getString(LOGGED_DOCTOR, null), Doctor.class);
    }

    public void setNewFisa(FisaMedicala fisaMedicala) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(NEW_FISA, gson.toJson(fisaMedicala));
        editor.apply();
        editor.commit();
    }

    public FisaMedicala getNewFisa()
    {
        return gson.fromJson(sharedPrefs.getString(NEW_FISA, null), FisaMedicala.class);
    }
}
