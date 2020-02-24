package com.example.myproject.activities;

import com.example.myproject.adapters.CardLayoutAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.example.myproject.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class BuyCreditPinActivity extends AppCompatActivity {
    Button button;
    NestedScrollView bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    ImageView imageView;
    private int[] layouts = {R.layout.activity_slide_row, R.layout.debit_card, R.layout.debit_card_green};
    ViewPager viewPager;
    LinearLayout dotsLayouts;
    ImageView[] dots;
    CardLayoutAdapter cardLayoutAdapter;
    Button btnRateApp;
    LinearLayout showContent;
    RadioButton radioButton;
    private Object ToggleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_credit_pin);

        final RadioButton cardButton= findViewById(R.id.radioLink);
        final RadioButton cashButton = findViewById(R.id.radioLink1);
        showContent = findViewById(R.id.ShowContent);

        cardButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cardButton.isChecked()) {
                    showContent.setVisibility(View.VISIBLE);
                } else if (cashButton.isChecked()){
                    showContent.setVisibility(View.GONE);
                }
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.SpinnerCredit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        imageView = findViewById(R.id.arrowBar1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);

            }
        });

        button = (Button) findViewById(R.id.BtnCreditPin);
        btnRateApp =(Button) findViewById(R.id.BtnRateApp);
        bottomSheet = (NestedScrollView) findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        final View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(BuyCreditPinActivity.this);
        Button rate = dialogView.findViewById(R.id.BtnRateApp);
        dialog.setContentView(dialogView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((View) dialogView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
                dialog.show();
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });


        bottomSheetBehavior.setPeekHeight(0);

        dotsLayouts = findViewById(R.id.dotsLayoutCreditPin);
        viewPager = findViewById(R.id.viewpagerCreditPin);
        cardLayoutAdapter = new CardLayoutAdapter(layouts, BuyCreditPinActivity.this);
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
        if (dotsLayouts != null) ;
        dotsLayouts.removeAllViews();
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
            dotsLayouts.addView(dots[i], params);
        }

    }

}


