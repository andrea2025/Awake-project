package com.example.myproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myproject.R;
import com.example.myproject.activities.AddFundActivity;

public class CardLayoutAdapter extends PagerAdapter implements View.OnClickListener{

    private int[] layouts;
    private Context context;
    private LayoutInflater layoutInflater;
    private AlertDialog alertDialog = null;

    public CardLayoutAdapter(int[] layouts, Context context){
        this.layouts = layouts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = layoutInflater.inflate(layouts[position],container,false);

        switch (position){
            case 0:
                LinearLayout addFund = view.findViewById(R.id.addFunds);
                addFund.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, AddFundActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case 1:

                break;
            case 2:
                break;

        }


        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }

    }
}