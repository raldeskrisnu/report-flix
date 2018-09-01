package com.clue.raldeskrisnu.clue.recylerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clue.raldeskrisnu.clue.R;
import com.clue.raldeskrisnu.clue.models.ResultApi;
import com.clue.raldeskrisnu.clue.util.RecylerViewHolder;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class ClueAdapter extends RecyclerView.Adapter<ClueAdapter.RecylerViewHolder>{

    private List<ResultApi> clueList;
    private Context context;

    public ClueAdapter(List<ResultApi> movieList, Context context) {
        this.clueList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_main,parent,false);
        RecylerViewHolder rv = new RecylerViewHolder(v);
        return rv;
    }

    @Override
    public void onBindViewHolder(RecylerViewHolder holder, int position) {

        holder.tvTitle.setText(clueList.get(position).getUsername());
        holder.tvOverview.setText(clueList.get(position).getDescription());
        holder.tvReleaseDate.setText(clueList.get(position).getKelurahan());
        Glide.with(context).load(clueList.get(position).getImageUrl()).into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return clueList.size();
    }

    public class RecylerViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvOverview,tvReleaseDate;
        ImageView ivMovie;

        public RecylerViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvOverview = (TextView) v.findViewById(R.id.tvOverView);
            tvReleaseDate = (TextView) v.findViewById(R.id.tvReleaseDate);
            ivMovie = (ImageView) v.findViewById(R.id.ivMovie);
        }
    }
}
