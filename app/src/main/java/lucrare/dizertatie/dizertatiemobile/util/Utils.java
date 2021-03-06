package lucrare.dizertatie.dizertatiemobile.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;

public class Utils {

    public static  String setDoctorTitle(Doctor doctor)
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(doctor.getTitlu())
                .append(" ")
                .append(doctor.getNume())
                .append(" ")
                .append(doctor.getPrenume());

        return stringBuilder.toString();
    }

    public static String convertLongToDate(Long dateL) {
        Date date = new Date(dateL);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return df.format(date);
    }

}
