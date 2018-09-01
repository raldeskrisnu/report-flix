package com.clue.raldeskrisnu.clue.presenter;

import android.util.Log;

import com.clue.raldeskrisnu.clue.models.ResultApi;
import com.clue.raldeskrisnu.clue.network.NetworkClue;
import com.clue.raldeskrisnu.clue.network.NetworkInterface;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {

    private MainViewInterface mvi;
    private String TAG = "MainPresenter";
    private NetworkInterface api;

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getData() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<List<ResultApi>> getObservable(){

        api = NetworkClue.getRetrofit().create(NetworkInterface.class);

        return api.getAllData().subscribeOn(Schedulers.io())       //setting up worker thread
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<List<ResultApi>> getObserver(){
        return new DisposableObserver<List<ResultApi>>() {
            @Override
            public void onNext(List<ResultApi> resultApis) {
                mvi.displayData(resultApis);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                mvi.hideProgressBar();
            }
        };

    }

}
