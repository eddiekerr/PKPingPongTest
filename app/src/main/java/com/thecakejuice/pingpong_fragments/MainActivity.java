package com.thecakejuice.pingpong_fragments;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private BottomNavigationView mBottomNavView;
    public static DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mBottomNavView = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mPagerAdapter = new FragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public MenuItem prevMenuItem;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {  }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    mBottomNavView.getMenu().getItem(0).setChecked(false);
                }

                mBottomNavView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mBottomNavView.getMenu().getItem(position);
            }

        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    public static void writeNewUser(String userId, String name, String email) {
        mDatabase.child("users").child(userId).child("Name").setValue(name);
        mDatabase.child("users").child(userId).child("Email").setValue(email);

    }
}
