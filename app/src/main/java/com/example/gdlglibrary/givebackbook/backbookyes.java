package com.example.gdlglibrary.givebackbook;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gdlglibrary.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class backbookyes extends AppCompatActivity {
    /**
     * 需要写textview来显示书籍名字
     * @param savedInstanceState
     */
    Button btnext,btreturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backbookyes);
        btnext = findViewById(R.id.bt_backyestonext);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(backbookyes.this, backbookdone.class);
                startActivity(intent);
            }
        });
        btreturn = findViewById(R.id.bt_backyestoreturn);
        btreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//需要判断是不是空
                Intent intent = new Intent(backbookyes.this, backbooks.class);
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