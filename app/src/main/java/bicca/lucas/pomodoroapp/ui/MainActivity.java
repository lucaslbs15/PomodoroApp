package bicca.lucas.pomodoroapp.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import bicca.lucas.pomodoroapp.R;
import bicca.lucas.pomodoroapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initMainFragmentPagerAdapter();
    }

    private void initMainFragmentPagerAdapter() {
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(this, getSupportFragmentManager());
        binding.activityMainViewpager.setAdapter(adapter);
        binding.activityMainTablayout.setupWithViewPager(binding.activityMainViewpager);
    }
}
