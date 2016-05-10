package com.nurolopher.wordgame.complexity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nurolopher.wordgame.R;

import io.realm.RealmResults;

public class ComplexityAdapter extends RecyclerView.Adapter<ComplexityViewHolder> {

    private final RealmResults<Complexity> comlexities;

    public ComplexityAdapter(RealmResults<Complexity> complexities) {
        this.comlexities = complexities;
    }

    @Override
    public ComplexityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.complexity_row, parent, false);
        return new ComplexityViewHolder(view,parent.getContext());
    }

    @Override
    public void onBindViewHolder(ComplexityViewHolder holder, int position) {
        holder.bindComplexity(comlexities.get(position));
    }

    @Override
    public int getItemCount() {
        return comlexities.size();
    }
}
