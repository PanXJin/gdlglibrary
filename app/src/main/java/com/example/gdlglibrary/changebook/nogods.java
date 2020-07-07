package com.example.gdlglibrary.changebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gdlglibrary.R;

public class nogods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nogods);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}