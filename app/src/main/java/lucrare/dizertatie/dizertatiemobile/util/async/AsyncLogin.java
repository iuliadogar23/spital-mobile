package lucrare.dizertatie.dizertatiemobile.util.async;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.ui.mainpage.MainActivity;
import lucrare.dizertatie.dizertatiemobile.util.SharedPreferencesUtil;

public class AsyncLogin  extends AsyncTask<String, String, Doctor> {

    private String resp;
    Activity activity;
    SharedPreferencesUtil sharedPreferencesUtil;
    Doctor doctor;
    String token;

    public AsyncLogin(Activity activity, Doctor authenticationResponse, String token) {
        this.activity = activity;
        this.sharedPreferencesUtil = SharedPreferencesUtil.getInstance(activity);
        this.doctor = authenticationResponse;
        this.token = token;

    }

    @Override
    protected Doctor doInBackground(String... params) {
        try {
                sharedPreferencesUtil.setDoctor(doctor);
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        return doctor;
    }


    @Override
    protected void onPostExecute(Doctor result) {
        // execution of result of Long time consuming operation
//        progressDialog.dismiss();
//        finalResult.setText(result);
    }


    @Override
    protected void onPreExecute() {

    }


    @Override
    protected void onProgressUpdate(String... text) {
//        finalResult.setText(text[0]);

    }
}
