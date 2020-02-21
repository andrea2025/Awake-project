package com.example.myproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.example.myproject.R;
import com.example.myproject.adapters.CardLayoutAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class DataPlanPin2Activity extends AppCompatActivity {
    Button button;
    Button btnFail;
    NestedScrollView bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    ImageView arrowBar3;

    LinearLayout dotsLayout;

    ImageView[] dots;

    CardLayoutAdapter cardLayoutAdapter;

    ViewPager viewPager;
    private int[] layouts = {R.layout.activity_slide_row,R.layout.debit_card,R.layout.debit_card_green};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_plan_pin2);


       final ToggleButton toggle = (ToggleButton) findViewById(R.id.BtnData);
        final LinearLayout showContent = (LinearLayout) findViewById(R.id.DataContent);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showContent.setVisibility(View.VISIBLE);
                } else {
                    showContent.setVisibility(View.GONE);
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.SpinnerPay);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        arrowBar3 = findViewById(R.id.BackArrowData3);
        arrowBar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });




        button  = (Button) findViewById(R.id.BtnDataPin2);
        btnFail= findViewById(R.id.BtnFail);
        bottomSheet = (NestedScrollView) findViewById(R.id.bottom_sheet_data);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        btnFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });


        bottomSheetBehavior.setPeekHeight(0);

        dotsLayout = findViewById(R.id.dotsLayoutDataPin2);
        viewPager = findViewById(R.id.viewpagerDataPin2);
        cardLayoutAdapter = new CardLayoutAdapter(layouts, DataPlanPin2Activity.this);
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
