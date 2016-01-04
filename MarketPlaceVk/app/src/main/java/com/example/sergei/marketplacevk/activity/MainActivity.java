package com.example.sergei.marketplacevk.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;

import com.example.sergei.marketplacevk.R;
import com.example.sergei.marketplacevk.fragment.MainFragment;
import com.vk.sdk.VKSdk;

/**
 * Created by sergei on 02.01.2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        initialize();
    }

    public void initialize() {
        Fragment fragment;
        FragmentManager manager = getFragmentManager();
        fragment = manager.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
