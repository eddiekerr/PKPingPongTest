package com.thecakejuice.pingpong_fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thecakejuice.pingpong_fragments.Fragments.LeaderboardFragment;
import com.thecakejuice.pingpong_fragments.Fragments.SettingsFragment;
import com.thecakejuice.pingpong_fragments.Fragments.StatsFragment;

/**
 * Created by eddiekerr on 27/12/17.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public static final int STATS_FRAGMENT_INDEX = 0;
    public static final int LEADERBOARD_FRAGMENT_INDEX = 1;
    public static final int SETTINGS_FRAGMENT_INDEX = 2;

    private StatsFragment mStatsFragment;
    private LeaderboardFragment mLeaderboardFragment;
    private SettingsFragment mSettingsFragment;
    private Context mContext;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        switch (position) {
            case STATS_FRAGMENT_INDEX:
                mStatsFragment = (StatsFragment) super.instantiateItem(view, position);
                return mStatsFragment;
            case LEADERBOARD_FRAGMENT_INDEX:
                mLeaderboardFragment = (LeaderboardFragment) super.instantiateItem(view, position);
                return mLeaderboardFragment;
            case SETTINGS_FRAGMENT_INDEX:
                mSettingsFragment = (SettingsFragment) super.instantiateItem(view, position);
                return mSettingsFragment;

            default:
                mStatsFragment = (StatsFragment) super.instantiateItem(view, position);
                return mStatsFragment;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case STATS_FRAGMENT_INDEX:
                if (mStatsFragment == null) {
                    mStatsFragment = StatsFragment.newInstance();
                }
                return mStatsFragment;

            case LEADERBOARD_FRAGMENT_INDEX:
                if (mLeaderboardFragment == null) {
                    mLeaderboardFragment = LeaderboardFragment.newInstance();
                }
                return mLeaderboardFragment;

            case SETTINGS_FRAGMENT_INDEX:
                if (mSettingsFragment == null) {
                    mSettingsFragment = SettingsFragment.newInstance();
                }
                return mSettingsFragment;

            default:
                return StatsFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

