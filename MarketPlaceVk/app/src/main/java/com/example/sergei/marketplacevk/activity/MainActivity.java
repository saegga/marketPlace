package com.example.sergei.marketplacevk.activity;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;


import com.example.sergei.marketplacevk.R;
import com.example.sergei.marketplacevk.fragment.MainFragment;
import com.vk.sdk.VKSdk;


/**
 * Created by sergei on 02.01.2016.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation_list);
        navigationView.setNavigationItemSelectedListener(new NavigationListener());
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.openDrawer(GravityCompat.START);
                    return true;
                }else{
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    private class NavigationListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
           switch (item.getItemId()){
               case R.id.stores :
                   drawerLayout.closeDrawer(GravityCompat.START);
                   break;
           }
            return true;
        }
    } 
/*todo посмотреть можно ли загружать категории из магазина вкл его 
  todo в прил-е если да то реализовать иначе обчным списком*/
    //todo также начать реализовывать мои сообщения и моя страница
}
