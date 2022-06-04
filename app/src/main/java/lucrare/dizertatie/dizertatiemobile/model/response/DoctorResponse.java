package lucrare.dizertatie.dizertatiemobile.model.response;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;

public class DoctorResponse {

    private List<Doctor> doctorList;

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
