package bicca.lucas.pomodoroapp.ui.historypomodoro.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.R;
import bicca.lucas.pomodoroapp.databinding.FragmentHistoryPomodoroBinding;
import bicca.lucas.pomodoroapp.ui.MainApplication;
import bicca.lucas.pomodoroapp.ui.historypomodoro.interaction.HistoryPomodoroInteraction;
import bicca.lucas.pomodoroapp.ui.historypomodoro.viewmodel.HistoryPomodoroViewModel;
import bicca.lucas.pomodoroapp.ui.model.HistoryPomodoro;

public class HistoryPomodoroFragment extends Fragment implements HistoryPomodoroInteraction {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentHistoryPomodoroBinding binding;
    @Inject
    public HistoryPomodoroViewModel viewModel;

    public HistoryPomodoroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryPomodoroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryPomodoroFragment newInstance(String param1, String param2) {
        HistoryPomodoroFragment fragment = new HistoryPomodoroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history_pomodoro, container, false);
        injectDependecies();
        viewModel.setInteraction(this);
        viewModel.loadHistory();
        binding.setHistoryPomodoroViewModel(viewModel);
        return binding.getRoot();
    }

    private void injectDependecies() {
        ((MainApplication) getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showHistory(ArrayList<HistoryPomodoro> historyPomodoros) {
        binding.fragmentHistoryPomodoroRecycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.fragmentHistoryPomodoroRecycler.setLayoutManager(linearLayoutManager);
        ItemHistoryPomodoroAdapter adapter = new ItemHistoryPomodoroAdapter(historyPomodoros, getContext());
        binding.fragmentHistoryPomodoroRecycler.setAdapter(adapter);
    }

    @Override
    public Context getContext() {
        return getActivity().getBaseContext();
    }
}
