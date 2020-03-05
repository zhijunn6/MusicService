package com.example.mymusicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {

    public static final String TAG = "MusicService";
    MediaPlayer myMusicPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //called when the service is created
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service created!", Toast.LENGTH_SHORT).show();

        myMusicPlayer = MediaPlayer.create(this, R.raw.valkryie);
        myMusicPlayer.setLooping(false);
    }

    //called when the service commences
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started", Toast.LENGTH_LONG).show();
        Log.i(TAG, "In onStartCommand, thread id: " + Thread.currentThread().getId());
        myMusicPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    //called when the service is stopped
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service stopped!", Toast.LENGTH_LONG).show();
        myMusicPlayer.stop();
    }
}
