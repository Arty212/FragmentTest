package com.example.arturbaboskin.fragmenttest;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements OneFragment.OneFragmentCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onOneFragmentCallback() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, TwoActivity.class);
            startActivity(intent);
        }else {
            TwoFragment fragmentTwo = new TwoFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, fragmentTwo)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
