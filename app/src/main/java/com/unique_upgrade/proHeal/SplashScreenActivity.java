package com.unique_upgrade.proHeal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

Handler handler;
Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //Thread
        runnable=new Runnable() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void run() {

        ////login session//////
                CheckuserLogin();
            }
        };

        handler=new Handler();
        handler.postDelayed(runnable,2000);
    }

    private void CheckuserLogin() {
        try{
            String str= getSharedPreferences("ProHeal",MODE_PRIVATE).getString("key","");
            assert str != null;
            if(str.equals("login")){
                Intent i=new Intent(SplashScreenActivity.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
            else {
                Intent i=new Intent(SplashScreenActivity.this,LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }

        }catch (Exception e){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(handler != null && runnable !=null){
            handler.removeCallbacks(runnable);
        }
    }
}