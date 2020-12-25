package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView addCityIv,moreIv;
    private SharedPreferences pref;
    private int bgNum;
    private ScrollView outLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather",null) != null){
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //        换壁纸的函数
    private void exchangeBg() {
        pref = getSharedPreferences("bg_pref", MODE_PRIVATE);
        bgNum = pref.getInt("bg", 2);
        switch (bgNum) {
            case 0:
                outLayout.setBackgroundResource(R.drawable.bg);
                break;
            case 1:
                outLayout.setBackgroundResource(R.drawable.bg2);
                break;
            case 2:
                outLayout.setBackgroundResource(R.drawable.bg3);
                break;
        }

    }


    @Override
    public void onClick(View v) {

    }
}
