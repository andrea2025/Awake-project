package com.example.myproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myproject.R;
import com.example.myproject.adapters.CardLayoutAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class SettingActivity extends AppCompatActivity {
Button BtnSettings;
Button BtnHome;

ImageView SettingArrow;
    NestedScrollView bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;

    LinearLayout dotsLayout;
    ImageView[] dots;
    CardLayoutAdapter cardLayoutAdapter;
    ViewPager viewPager;
    private int[] layouts = {R.layout.activity_slide_row,R.layout.debit_card,R.layout.debit_card_green};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        BtnHome = findViewById(R.id.BtnSettingHome);
        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });
        SettingArrow = findViewById(R.id.SettingArrow);
        SettingArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });

        BtnSettings = (Button) findViewById(R.id.BtnSetting);
        bottomSheet = (NestedScrollView) findViewById(R.id.bottom_sheet_settings);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        BtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }

            }
        });
        bottomSheetBehavior.setPeekHeight(0);

        dotsLayout = findViewById(R.id.dotsLayoutSetting);
        viewPager = findViewById(R.id.viewpagerSetting);
        cardLayoutAdapter = new CardLayoutAdapter(layouts, SettingActivity.this);
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
        if (dotsLayout != null)
            dotsLayout.removeAllViews();

        dots = new ImageView[layouts.length];

        for (int i = 0; i < layouts.length; i++) {
            dots[i] = new ImageView(this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active));
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(6, 0, 6, 0);

            dotsLayout.addView(dots[i], params);
        }
    }

    }

