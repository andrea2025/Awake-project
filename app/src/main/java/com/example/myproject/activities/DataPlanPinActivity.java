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

import com.example.myproject.R;
import com.example.myproject.adapters.CardLayoutAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DataPlanPinActivity extends AppCompatActivity {
    Button button;
    Button btnFail;
    NestedScrollView bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    ImageView arrowBar3;

    LinearLayout dotsLayout;

    ImageView[] dots;

    CardLayoutAdapter cardLayoutAdapter;

    ViewPager viewPager;
    private int[] layouts = {R.layout.activity_slide_row, R.layout.debit_card, R.layout.debit_card_green};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_plan_pin2);


        final RadioButton cardButton = findViewById(R.id.BtnData);
        final RadioButton cashButton = findViewById(R.id.BtnData1);
        final LinearLayout showContent = findViewById(R.id.DataContent);

        cardButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cardButton.isChecked()) {
                    showContent.setVisibility(View.VISIBLE);

                } else if (cashButton.isChecked()) {
                    showContent.setVisibility(View.GONE);
                }
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.SpinnerPay);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        arrowBar3 = findViewById(R.id.BackArrowData3);
        arrowBar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });


        button = (Button) findViewById(R.id.BtnDataPin2);
        btnFail = (Button) findViewById(R.id.BtnFail);

        final View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(DataPlanPinActivity.this);
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


        dotsLayout = findViewById(R.id.dotsLayoutDataPin2);
        viewPager = findViewById(R.id.viewpagerDataPin2);
        cardLayoutAdapter = new CardLayoutAdapter(layouts, DataPlanPinActivity.this);
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
