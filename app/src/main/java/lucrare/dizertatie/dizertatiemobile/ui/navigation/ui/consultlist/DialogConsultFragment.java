package lucrare.dizertatie.dizertatiemobile.ui.navigation.ui.consultlist;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import lucrare.dizertatie.dizertatiemobile.R;
import lucrare.dizertatie.dizertatiemobile.databinding.FragmentDialogConsultBinding;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Consult;
import lucrare.dizertatie.dizertatiemobile.model.doctormodel.Doctor;
import lucrare.dizertatie.dizertatiemobile.model.enums.Status;
import lucrare.dizertatie.dizertatiemobile.util.Utils;

public class DialogConsultFragment extends Fragment {

    private FragmentDialogConsultBinding binding;

    @BindView(R.id.tv_fisa_nr)
    TextView fisaNr;
    @BindView(R.id.tv_data_start)
    TextView dataStart;
    @BindView(R.id.tv_nume_doctor)
    TextView numeDoctor;
    @BindView(R.id.tv_motivul_programarii)
    TextView motivulProgramarii;
    @BindView(R.id.et_recomandare)
    EditText recomandare;
    @BindView(R.id.tv_recomandare)
    TextView recomadareText;
    @BindView(R.id.fab_cancel)
    FloatingActionButton cancel;
    @BindView(R.id.fab_ok)
    FloatingActionButton ok;

    DialogConsultViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDialogConsultBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(DialogConsultViewModel.class);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);

        Consult consult = (Consult) getArguments().getSerializable("consult");
        initFields(consult);

        return root;
    }

    private void initFields(Consult consult)
    {
        fisaNr.setText("Fisa Nr. "+consult.getId());
        numeDoctor.setText(Utils.setDoctorTitle(consult.getDoctorSolicitant()));
        dataStart.setText(Utils.convertLongToDate(consult.getOraPrezentarii()));
        motivulProgramarii.setText(consult.getMesajSolicitare());

        if (consult.getStatus().equals(Status.IN_ASTEPTARE.toString())) {
            cancel.setVisibility(View.VISIBLE);
            cancel.setClickable(true);
            recomandare.setVisibility(View.INVISIBLE);
            recomandare.setClickable(false);
            recomadareText.setVisibility(View.INVISIBLE);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    getActivity().getSupportFragmentManager().popBackStack();
                    Navigation.findNavController(v).navigate(R.id.action_dialogConsultFragment_to_nav_consult_list);
                }
            });
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    consult.setStatus(Status.ACCEPTAT.toString());
                    viewModel.saveConsult(consult);
                    Navigation.findNavController(v).navigate(R.id.action_dialogConsultFragment_to_nav_consult_list);
                }
            });
        }
        if (consult.getStatus().equals(Status.ACCEPTAT)) {

            cancel.setVisibility(View.INVISIBLE);
            cancel.setClickable(false);
            recomandare.setVisibility(View.VISIBLE);
            recomandare.setClickable(true);
            recomadareText.setVisibility(View.VISIBLE);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    consult.setRecomandareConsult(recomandare.getText().toString());
                    consult.setOraPrezentarii(Calendar.getInstance().getTimeInMillis());
                    viewModel.saveConsult(consult);
                    Navigation.findNavController(v).navigate(R.id.action_dialogConsultFragment_to_nav_consult_list);

                }
            });

        }
        if (consult.getStatus().equals(Status.ISTORIC)) {
            cancel.setVisibility(View.INVISIBLE);
            cancel.setClickable(false);
            recomandare.setClickable(true);
            recomandare.setVisibility(View.VISIBLE);
            recomadareText.setVisibility(View.VISIBLE);
        }

    }

}