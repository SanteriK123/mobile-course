package com.example.mobiledevexercise3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {


    LayoutInflater mInflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d) {
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView textViewName = v.findViewById(R.id.textViewName);
        TextView textViewPrice = v.findViewById(R.id.textViewPrice);
        TextView textViewDescription = v.findViewById(R.id.textViewDescription);
        String name = items[i];
        String price = prices[i];
        String description = descriptions[i];
        textViewName.setText(name);
        textViewPrice.setText(price);
        textViewDescription.setText(description);

        return v;
    }
}
