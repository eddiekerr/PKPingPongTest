package com.thecakejuice.pingpong_fragments.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thecakejuice.pingpong_fragments.R;
import com.thecakejuice.pingpong_fragments.SignInActivity;

/**
 * Created by eddiekerr on 27/12/17.
 */

public class StatsFragment extends Fragment {

    public static StatsFragment newInstance() {
        return new StatsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stats, container, false);

        return root;
    }
}
