package com.example.myproject.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myproject.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<HistoryList> {

    private Context mContext;
    private List<HistoryList> historyList;

    public HistoryAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<HistoryList> list) {
        super(context, 0 , list);
        mContext = context;
        historyList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.history_layout,parent,false);

        HistoryList history = historyList.get(position);

        ImageView image = listItem.findViewById(R.id.networkImage);
        image.setImageResource(history.getNetworkImage());

        TextView networkName = listItem.findViewById(R.id.networkPlan);
        networkName.setText(history.getNetworkName());

        TextView date = listItem.findViewById(R.id.dated);
        date.setText(history.getDate());

        return listItem;
    }
}