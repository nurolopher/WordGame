package com.nurolopher.wordgame.complexity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nurolopher.wordgame.R;


public class ComplexityViewHolder extends RecyclerView.ViewHolder {

    private TextView title;

    public ComplexityViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
    }

    public void bindComplexity(final Complexity complexity) {
        title.setText(complexity.getTitle());
    }
}
