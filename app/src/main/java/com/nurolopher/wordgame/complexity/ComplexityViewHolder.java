package com.nurolopher.wordgame.complexity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nurolopher.wordgame.PlayActivity;
import com.nurolopher.wordgame.R;


public class ComplexityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    private TextView size;
    private Context context;
    private Complexity complexity;

    public ComplexityViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        title = (TextView) itemView.findViewById(R.id.title);
        size = (TextView) itemView.findViewById(R.id.size);
        itemView.setOnClickListener(this);
    }

    public void bindComplexity(final Complexity complexity) {
        title.setText(complexity.getTitle());
        size.setText(getCustomizedSize(complexity));
        this.complexity = complexity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, PlayActivity.class);
        intent.putExtra(Complexity.ITEM_ID, complexity.getId());
        this.context.startActivity(intent);
    }

    public String getCustomizedSize(Complexity complexity) {
        return "Size: " + complexity.getSize() + "x" + complexity.getSize();
    }
}
