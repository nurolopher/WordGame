package com.nurolopher.wordgame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private Grid grid;

    public GridAdapter(Context context, Grid grid) {
        super();
        this.context = context;
        this.grid = grid;
    }

    @Override
    public int getCount() {
        return grid.size();
    }

    @Override
    public Cell getItem(int position) {
        return grid.getAtPosition(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button = new Button(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setText(getItem(position).getLetter().toString());
        button.setLayoutParams(layoutParams);
        return button;
    }
}
