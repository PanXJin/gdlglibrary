package com.example.gdlglibrary.readbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gdlglibrary.R;

public class nullbook extends AppCompatActivity {
    /**
     * 写一个延迟3秒自动返回的东西
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nullbook);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}