package com.example.myproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
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
import com.example.myproject.adapters.AddFundCardLayoutAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class UtilityBillsPin2Activity extends AppCompatActivity {
    Button button;
    Button BtnReceipt;
    NestedScrollView bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    ImageView UtilityArrow3;
    LinearLayout dotLayouts;
    ImageView[] dots;
    AddFundCardLayoutAdapter cardLayoutAdapter;
    ViewPager viewPager;
    private int[] layouts = {R.layout.dstv, R.layout.gotv, R.layout.jumia};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility_bills_pin2);

        final RadioButton cardButton = (RadioButton) findViewById(R.id.BtnBill);
        final RadioButton cashButton = (RadioButton) findViewById(R.id.BtnBill2);
        final LinearLayout showContent = (LinearLayout) findViewById(R.id.BillContent);

        cardButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cardButton.isChecked()) {
                    showContent.setVisibility(View.VISIBLE);

                } else if (cashButton.isChecked()){
                    showContent.setVisibility(View.GONE);
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.SpinnerBouquet);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_name2,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        UtilityArrow3 = findViewById(R.id.BackArrowData3);
        UtilityArrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });


        button  = (Button) findViewById(R.id.BtnUtilityPin2);

        final View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(UtilityBillsPin2Activity.this);
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
                Intent intent = new Intent(getApplicationContext(),UtilityBillReceiptActivity.class);
                startActivity(intent);
                dialog.hide();

            }
        });

        dotLayouts = findViewById(R.id.dotsLayoutBillPin2);
        viewPager = findViewById(R.id.viewpagerBillPin2);
        cardLayoutAdapter = new AddFundCardLayoutAdapter(layouts, UtilityBillsPin2Activity.this);
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
