package com.example.sergei.marketplacevk.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergei.marketplacevk.R;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

/**
 * Created by sergei on 03.01.2016.
 */
public class MainFragment extends Fragment {
    public static final String[] SCOPE = new String[]{
            VKScope.GROUPS, VKScope.FRIENDS, VKScope.MESSAGES, VKScope.WALL, "market",
            VKScope.PHOTOS, VKScope.NOTIFY, VKScope.AUDIO, VKScope.VIDEO
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VKSdk.login(this, SCOPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // успешная авторизация
                Log.d("Main Fragment", res.toString());
            }

            @Override
            public void onError(VKError error) {
                //ошибка авторизации
            }
        })) {

            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    //todo сделать тулбар добавть туда кнопки
}
