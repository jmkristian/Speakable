package com.jkristian.speakable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment main = manager.findFragmentByTag("MainFragment");
        if (main == null) {
            main = new MainFragment();
            manager.beginTransaction().add(R.id.activity_main, main, "MainFragment").commit();
        }
    }
}
