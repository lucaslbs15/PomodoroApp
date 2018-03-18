package bicca.lucas.pomodoroapp.ui.newpomodoro.view;

import android.app.NotificationManager;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.R;
import bicca.lucas.pomodoroapp.databinding.FragmentNewPomodoroBinding;
import bicca.lucas.pomodoroapp.ui.MainApplication;
import bicca.lucas.pomodoroapp.ui.newpomodoro.interaction.NewPomodoroInteraction;
import bicca.lucas.pomodoroapp.ui.newpomodoro.viewmodel.NewPomodoroViewModel;

public class NewPomodoroFragment extends Fragment implements NewPomodoroInteraction {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentNewPomodoroBinding binding;
    @Inject
    NewPomodoroViewModel viewModel;
    private long currentTime;

    public NewPomodoroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewPomodoroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewPomodoroFragment newInstance(String param1, String param2) {
        NewPomodoroFragment fragment = new NewPomodoroFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_pomodoro, container, false);
        injectDependecies();
        viewModel.setInteraction(this);
        binding.setNewPomodoroViewModel(viewModel);
        initChonometer();
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

    private void initChonometer() {
        binding.fragmentNewPomodoroTimer.setCountDown(true);
        resetCount();
        binding.fragmentNewPomodoroTimer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                currentTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                viewModel.validateFinish();
            }
        });
    }

    @Override
    public void runPomodoro() {
        binding.fragmentNewPomodoroTimer.start();
        resetCount();
        binding.fragmentNewPomodoroFab.setImageResource(R.drawable.ic_stop_white);
    }

    private void resetCount() {
        binding.fragmentNewPomodoroTimer.setBase(SystemClock.elapsedRealtime() + NewPomodoroViewModel.INITIAL_TIME);
    }

    @Override
    public void stopPomodoro() {
        restartChronometer();
    }

    @Override
    public void finishPomodoro() {
        restartChronometer();
    }

    @Override
    public long getCurrentTime() {
        return currentTime;
    }

    @Override
    public void showNotification(String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
        notificationManager.notify(15, builder.build());
    }

    private void restartChronometer() {
        binding.fragmentNewPomodoroTimer.stop();
        resetCount();
        binding.fragmentNewPomodoroFab.setImageResource(R.drawable.ic_play_arrow_white);
    }

    @Override
    public String getStringFromId(int stringId) {
        return getString(stringId);
    }
}
