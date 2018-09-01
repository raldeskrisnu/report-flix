package com.clue.raldeskrisnu.clue.recylerViewAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.clue.raldeskrisnu.clue.MainActivity;
import com.clue.raldeskrisnu.clue.R;
import com.clue.raldeskrisnu.clue.models.ResultApi;
import com.clue.raldeskrisnu.clue.util.RecylerViewHolder;
import com.clue.raldeskrisnu.clue.views.Maps;
import com.clue.raldeskrisnu.clue.views.SplashScreen;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.List;
import java.util.Map;

import io.reactivex.annotations.NonNull;

import static android.support.v4.content.ContextCompat.startActivity;

public class ClueAdapter extends RecyclerView.Adapter<RecylerViewHolder>{

    private List<ResultApi> clueList;
    private Context context;
    private Intent intents;

    public ClueAdapter(List<ResultApi> movieList, Context context) {
        this.clueList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_main,parent,false);
        RecylerViewHolder rv = new RecylerViewHolder(v);

        RxView.clicks(v).subscribe(o -> {
            intents = new Intent(context, Maps.class);
            intents.putExtra("ExtraUsername",clueList.get(rv.getAdapterPosition()).getUsername());
            intents.putExtra("ExtraKelurahan",clueList.get(rv.getAdapterPosition()).getKelurahan());
            intents.putExtra("ExtraLat",clueList.get(rv.getAdapterPosition()).getLat());
            intents.putExtra("ExtraLng",clueList.get(rv.getAdapterPosition()).getLng());
            context.startActivity(intents);
        });
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
}
