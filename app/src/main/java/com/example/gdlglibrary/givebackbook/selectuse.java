package com.example.gdlglibrary.givebackbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gdlglibrary.MainActivity;
import com.example.gdlglibrary.R;
import com.example.gdlglibrary.readbook.findbooks;


public class selectuse extends AppCompatActivity {
    Button give,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectuse);
        give = findViewById(R.id.bt_give);
        give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectuse.this, givebooks.class);
                startActivity(intent);
            }
        });
        back = findViewById(R.id.bt_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectuse.this, backbooks.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}