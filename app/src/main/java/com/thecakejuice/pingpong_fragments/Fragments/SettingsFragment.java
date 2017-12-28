package com.thecakejuice.pingpong_fragments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.thecakejuice.pingpong_fragments.R;
import com.thecakejuice.pingpong_fragments.SignInActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by eddiekerr on 27/12/17.
 */

public class SettingsFragment extends Fragment implements OnClickListener{

    Button mButton;
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        return root;

    }

    public void onViewCreated(Button button) {

        //onViewCreated(mButton = getView().findViewById(R.id.button2));
        mButton = getView().findViewById(R.id.button2);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "BUTTON HAS BEEN CLICKED FROM 2ND ONCLICK LISTENER");
        switch(view.getId()) {
            case R.id.button2: {
                Intent intent = new Intent(SettingsFragment.this.getActivity(), SignInActivity.class);
                startActivity(intent);
            }
        }
    }
}
