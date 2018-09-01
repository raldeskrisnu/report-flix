package com.clue.raldeskrisnu.clue.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.clue.raldeskrisnu.clue.MainActivity;
import com.clue.raldeskrisnu.clue.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding2.view.RxView;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.btnMasuk)
    public Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splasy_screen);
        ButterKnife.bind(this);

        RxView.clicks(btnMasuk).subscribe(o -> startActivity(new Intent(SplashScreen.this, MainActivity.class)));
    }

}
