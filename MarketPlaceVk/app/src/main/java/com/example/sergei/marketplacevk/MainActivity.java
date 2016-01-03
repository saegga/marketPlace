package com.example.sergei.marketplacevk;

import android.app.Activity;
import android.os.Bundle;

import com.vk.sdk.VKSdk;

/**
 * Created by sergei on 02.01.2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        VKSdk.login(this,"friends");
        //todo сделать фрагмент перенести туда реализацию логина добавить права String[]{VkScope.,""}
    }
}
