package com.example.myproject.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.myproject.R;
import com.example.myproject.adapters.CardLayoutAdapter;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    LinearLayout dotsLayout;

    ImageView[] dots;

    private AppBarConfiguration mAppBarConfiguration;

    CardLayoutAdapter cardLayoutAdapter;

    ViewPager viewPager;


    private int[] layouts = {R.layout.activity_slide_row, R.layout.debit_card, R.layout.debit_card_green};

    private boolean doubleBackToExitPressedOnce = false;

    ImageView imageView;

    DrawerLayout drawer;

    LinearLayout buyCredit;
    LinearLayout BuyData;
    LinearLayout PayBills;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageView = findViewById(R.id.navigationDrawerIcon);
        imageView.setOnClickListener(this);

        buyCredit = findViewById(R.id.buyCreditCard);
        buyCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyCreditPinActivity.class);
                startActivity(intent);
            }
        });

        BuyData = findViewById(R.id.BuyData);
        BuyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataPlanPinActivity.class);
                startActivity(intent);
            }
        });

        PayBills = findViewById(R.id.PayBills);
        PayBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UtilityBillsPin2Activity.class);
                startActivity(intent);
            }
        });


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        ImageView cancel = headerView.findViewById(R.id.closeNav);
        cancel.setOnClickListener(this);

        dotsLayout = findViewById(R.id.dotsLayout);
        viewPager = findViewById(R.id.viewpager);
        cardLayoutAdapter = new CardLayoutAdapter(layouts, DashboardActivity.this);
        viewPager.setAdapter(cardLayoutAdapter);
        createDots(0);
        onBackPressed();

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_card) {
            Intent intent = new Intent(getApplicationContext(), CardActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_transaction) {
            Intent intent = new Intent(getApplicationContext(), TransactionHistoryActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {

                new AlertDialog.Builder(this,R.style.AlertDialogCustom)
                        .setTitle("Logout")
                        .setCancelable(false)
                        .setMessage("Would you like to logout?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                finishAffinity();
            }

            this.doubleBackToExitPressedOnce = true;

//            Toast.makeText(getApplicationContext(), "Click back again to exit app", Toast.LENGTH_LONG).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce = false;
//                }
//            }, 2000);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.navigationDrawerIcon:
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.closeNav:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                break;
        }
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
