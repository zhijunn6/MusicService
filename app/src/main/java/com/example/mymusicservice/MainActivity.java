package com.example.mymusicservice;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = "MusicService_Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "MainActivity thread id: " + Thread.currentThread().getId());

        Button buttonStart = findViewById(R.id.buttonStart);
        Button buttonStop = findViewById(R.id.buttonStop);
        Button buttonNext = findViewById(R.id.buttonNext);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonStart:

                startService(new Intent(this, MusicService.class));
                break;

            case R.id.buttonStop:

                stopService(new Intent(this, MusicService.class));
                break;

            case R.id.buttonNext:

                Intent intent = new Intent(this, NextActivity.class);
                startActivity(intent);
                break;
        }
    }
}
