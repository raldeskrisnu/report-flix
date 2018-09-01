package com.clue.raldeskrisnu.clue.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clue.raldeskrisnu.clue.R;

public class RecylerViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle,tvOverview,tvReleaseDate;
    public ImageView ivMovie;

    public RecylerViewHolder(View v) {
        super(v);
        tvTitle = (TextView) v.findViewById(R.id.tvTitle);
        tvOverview = (TextView) v.findViewById(R.id.tvOverView);
        tvReleaseDate = (TextView) v.findViewById(R.id.tvReleaseDate);
        ivMovie = (ImageView) v.findViewById(R.id.ivMovie);

    }
}
