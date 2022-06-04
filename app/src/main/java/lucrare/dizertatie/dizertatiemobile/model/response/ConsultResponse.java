package lucrare.dizertatie.dizertatiemobile.model.response;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;

public class ConsultResponse {

    private List<Consult> consults;

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }
}
