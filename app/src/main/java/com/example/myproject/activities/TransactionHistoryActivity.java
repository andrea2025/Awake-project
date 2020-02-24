package com.example.myproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.adapters.CardLayoutAdapter;
import com.example.myproject.adapters.HistoryAdapter;
import com.example.myproject.adapters.HistoryList;

import java.util.ArrayList;
import java.util.HashMap;

public class TransactionHistoryActivity extends AppCompatActivity {


    CardLayoutAdapter cardLayoutAdapter;
    private ImageView historyArrow;
    private LinearLayout dotsLayout;
    private ImageView[] dots;
    private ViewPager viewPager;
    private ListView listView;
    private TextView textView;
    private String[] listItem;
    private HistoryAdapter historyAdapter;
    private int[] layouts = {R.layout.activity_slide_row,R.layout.debit_card,R.layout.debit_card_green};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);


        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);
        ArrayList<HistoryList> historyList = new ArrayList<>();
        historyList.add(new HistoryList(R.drawable.ic_bills,"MTN - N850 - 08034604893","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_phone,"GLO - 10MB @ N850 - 08034604893","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_data,"DSTV Premuim - N8900 - 1month","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_bills,"MTN - N850 - 08034604893","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_phone,"GLO - 10MB @ N850 - 08034604893","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_data,"DSTV Premuim - N8900 - 1month","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_bills,"MTN - N850 - 08034604893","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_phone,"GLO - 10MB @ N850 - 08034604893","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_data,"DSTV Premuim - N8900 - 1month","12/10/2019"));
        historyAdapter = new HistoryAdapter(this,historyList);
        listView.setAdapter(historyAdapter);


        historyArrow = findViewById(R.id.historyBar);
        historyArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });


        dotsLayout = findViewById(R.id.dotsLayoutHistory);
        viewPager = findViewById(R.id.viewpagerhistory);
        cardLayoutAdapter = new CardLayoutAdapter(layouts, TransactionHistoryActivity.this);
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
