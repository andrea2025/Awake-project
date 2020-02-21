package com.example.myproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myproject.R;

public class CardActivity extends AppCompatActivity {
LinearLayout AddCard;

    ImageView CardArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        AddCard = findViewById(R.id.BtnAddCard);
        AddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CardPinActivity.class);
                startActivity(intent);
            }
        });
        CardArrow = findViewById(R.id.cardArrow);
        CardArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);

            }
        });


    }
}
