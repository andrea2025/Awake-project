package com.example.myproject.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.activities.DashboardActivity;
import com.example.myproject.activities.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    private Button lgnBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lgnBtn = findViewById(R.id.btnLoginClick);
        lgnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
               startActivity(intent);
            }
        });

        textView = findViewById(R.id.SignUpText);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}
