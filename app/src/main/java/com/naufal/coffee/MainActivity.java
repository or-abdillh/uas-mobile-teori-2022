package com.naufal.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer Timerku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //menghilangkan status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //ganti splash screen otomatis ke login
        Timerku = new Timer();
        Timerku.schedule(new TimerTask() {
            @Override
            public void run() {
                //pindah dari splash screen ke login
                Intent pindah = new Intent(MainActivity.this, Login.class);
                startActivity(pindah);
                finish();

            }
        },3000 );//waktu delay tampil splash screaan dalam milisecond
    }
}