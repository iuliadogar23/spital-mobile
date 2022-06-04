package lucrare.dizertatie.dizertatiemobile.model.response;

import java.util.List;

import lucrare.dizertatie.dizertatiemobile.model.pacientmodel.FisaMedicala;

public class FisaMedicalaResponse {

    private List<FisaMedicala> fisaMedicalaList;

    public List<FisaMedicala> getFisaMedicalaList() {
        return fisaMedicalaList;
    }

    public void setFisaMedicalaList(List<FisaMedicala> fisaMedicalaList) {
        this.fisaMedicalaList = fisaMedicalaList;
    }
}
