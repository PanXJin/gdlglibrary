package com.example.gdlglibrary.givebackbook;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gdlglibrary.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class backbooks extends AppCompatActivity {
    Button code,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backbooks);
        code = findViewById(R.id.bt_backcode);//扫描二维码，没开始搞

        next = findViewById(R.id.bt_backtonext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//需要判断是不是空
                Intent intent = new Intent(backbooks.this, backbookyes.class);
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