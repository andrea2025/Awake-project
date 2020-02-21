package com.example.myproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myproject.R;
import com.example.myproject.adapters.AddFundCardLayoutAdapter;

public class CardPinActivity extends AppCompatActivity {
    ImageView CardArrow;
    LinearLayout dotLayouts;
    ImageView[] dots;
    AddFundCardLayoutAdapter cardLayoutAdapter;
    ViewPager viewPager;
    private int[] layouts = {R.layout.debit_card, R.layout.debit_card, R.layout.debit_card};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_pin);

        CardArrow = findViewById(R.id.cardArrowPin);
        CardArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CardActivity.class);
                startActivity(intent);

            }
        });
        dotLayouts = findViewById(R.id.dotsLayoutCard);
        viewPager = findViewById(R.id.viewpagerCard);
        cardLayoutAdapter = new AddFundCardLayoutAdapter(layouts, CardPinActivity.this);
        viewPager.setAdapter(cardLayoutAdapter);
        createDots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void createDots(int current_position) {
        if (dotLayouts != null)
            dotLayouts.removeAllViews();
        dots = new ImageView[layouts.length];
        for (int i = 0; i < layouts.length; i++) {

            dots[i] = new ImageView(this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active));

            }else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(6,0,6,0);

            dotLayouts.addView(dots[i],params);
        }

    }
}
