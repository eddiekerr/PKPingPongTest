package com.thecakejuice.pingpong_fragments.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.thecakejuice.pingpong_fragments.FirebaseUserInfo;
import com.thecakejuice.pingpong_fragments.MainActivity;
import com.thecakejuice.pingpong_fragments.R;
import com.thecakejuice.pingpong_fragments.SignInActivity;

/**
 * Created by eddiekerr on 27/12/17.
 */
public class StatsFragment extends Fragment implements View.OnClickListener{

    TextView mTextView;
    Button button;
    public static StatsFragment newInstance() {
        return new StatsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stats, container, false);

        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        button = getView().findViewById(R.id.btn_write_user);
        button.setOnClickListener(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        for (UserInfo profile : user.getProviderData()) {

            // Id of the provider (ex: google.com)
            String providerId = profile.getProviderId();

            // UID specific to the provider
            String uid = profile.getUid();

            if(providerId.equals("firebase")) {

                // Name, email address, and profile photo Url
                String name = profile.getDisplayName();
                String email = profile.getEmail();
                Uri photoUrl = profile.getPhotoUrl();

                FirebaseUserInfo firebaseUserInfo = new FirebaseUserInfo(name, email, uid);
            }
        }
        mTextView = getView().findViewById(R.id.tv_user_info);
        mTextView.setText(FirebaseUserInfo.name);

        mTextView = getView().findViewById(R.id.tv_user_email);
        mTextView.setText(FirebaseUserInfo.emailAddress);

        mTextView = getView().findViewById(R.id.tv_uid);
        mTextView.setText(FirebaseUserInfo.uId);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_write_user: {
                MainActivity.writeNewUser(FirebaseUserInfo.uId, FirebaseUserInfo.name, FirebaseUserInfo.emailAddress);
                break;
            }
        }
    }
}
