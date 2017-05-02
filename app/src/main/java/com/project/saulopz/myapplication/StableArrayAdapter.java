package com.project.saulopz.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

class StableArrayAdapter extends ArrayAdapter<Contact> {
    private ArrayList<Contact> list;

    StableArrayAdapter(Context context, int textViewResourceId,
                       ArrayList<Contact> objects) {
        super(context, textViewResourceId, objects);
        list = objects;
    }

    @Override
    public long getItemId(int position) {
        int item = getItem(position).getId();
        return list.get(position).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}