package com.example.myproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.myproject.R;
import com.example.myproject.activities.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        } else {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
}
