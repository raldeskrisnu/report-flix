package com.clue.raldeskrisnu.clue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clue.raldeskrisnu.clue.models.ResultApi;
import com.clue.raldeskrisnu.clue.recylerViewAdapter.ClueAdapter;
import com.clue.raldeskrisnu.clue.presenter.MainPresenter;
import com.clue.raldeskrisnu.clue.presenter.MainViewInterface;
import com.jakewharton.rxbinding2.view.RxView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.recyleview)
    RecyclerView recyleview;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private String TAG = "MainActivity";

    private ClueAdapter adapter;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mvpInit();
        setupViews();
        getMovieList();
    }

    private void mvpInit() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
        recyleview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getMovieList() {
        mainPresenter.getData();
    }

    @Override
    public void showToast(String str){
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayData(List<ResultApi> responseApi){
        if(responseApi!=null) {
            Log.d(TAG,responseApi.get(1).getDescription());
            adapter = new ClueAdapter(responseApi, MainActivity.this){};
            recyleview.setAdapter(adapter);
            RxView.clicks(recyleview).subscribe(o ->
                    Toast.makeText(MainActivity.this,o.toString(),Toast.LENGTH_LONG).show()
            );
        }else{
            Log.d(TAG,"Movies response null");
        }
    }

    @Override
    public void displayError(String str){
        Log.d(TAG,str);
    }

    @Override
    public void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}
