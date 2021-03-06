package com.mahovd.bignerdranch.nerdlauncher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by mahovd on 08/11/15.
 * Controller-class
 */
public abstract class SingleFragmentActivity extends AppCompatActivity{

    protected abstract Fragment createFragment();

    //The enter-point
    // The whole magic is starting here.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment==null){
            //Translates the process to NerdLauncherActivity
            fragment = createFragment();
            fm.beginTransaction().
                    add(R.id.fragment_container,fragment).
                    commit();
        }

    }

}
