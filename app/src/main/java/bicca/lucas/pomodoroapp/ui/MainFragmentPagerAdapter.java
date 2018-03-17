package bicca.lucas.pomodoroapp.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bicca.lucas.pomodoroapp.R;
import bicca.lucas.pomodoroapp.ui.historypomodoro.view.HistoryPomodoroFragment;
import bicca.lucas.pomodoroapp.ui.newpomodoro.view.NewPomodoroFragment;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final int TOTAL_PAGES = 2;
    private Context context;

    public MainFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new HistoryPomodoroFragment();
        } else {
            return new NewPomodoroFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 1) {
            return context.getString(R.string.tab_layout_history);
        } else {
            return context.getString(R.string.tab_layout_new);
        }
    }

    @Override
    public int getCount() {
        return TOTAL_PAGES;
    }
}
