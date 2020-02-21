package com.example.myproject.activities.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.myproject.R;
import com.example.myproject.activities.DashboardActivity;
import com.example.myproject.adapters.CardLayoutAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private LinearLayout dotsLayout;

    private ImageView[] dots;

    private ViewPager viewPager;

    private CardLayoutAdapter cardLayoutAdapter;

    private int[] layouts = {R.layout.activity_slide_row,R.layout.activity_slide_row,R.layout.activity_slide_row};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        dotsLayout = root.findViewById(R.id.dotsLayout);
        viewPager = root.findViewById(R.id.viewpager);
        cardLayoutAdapter = new CardLayoutAdapter(layouts, getActivity());
        viewPager.setAdapter(cardLayoutAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        createDots(0);


        return root;

    }

    private void createDots(int current_position) {

        if (dotsLayout != null)
            dotsLayout.removeAllViews();

        dots = new ImageView[layouts.length];

        for (int i = 0; i < layouts.length; i++) {
            dots[i] = new ImageView(getContext());
            if (i == current_position) {
                Toast.makeText(getContext(),"active "+current_position,Toast.LENGTH_LONG).show();
                dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active));
            } else {
                Toast.makeText(getContext(),"inactive "+current_position,Toast.LENGTH_LONG).show();
                dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.inactive));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(6, 0, 6, 0);

            dotsLayout.addView(dots[i], params);
        }
    }
}