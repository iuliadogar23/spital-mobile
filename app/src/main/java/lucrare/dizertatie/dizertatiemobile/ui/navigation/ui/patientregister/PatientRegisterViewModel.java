package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.patientregister;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PatientRegisterViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PatientRegisterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}