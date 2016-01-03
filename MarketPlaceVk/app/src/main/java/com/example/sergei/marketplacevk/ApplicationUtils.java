package com.example.sergei.marketplacevk;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by sergei on 02.01.2016.
 */
public class ApplicationUtils extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
