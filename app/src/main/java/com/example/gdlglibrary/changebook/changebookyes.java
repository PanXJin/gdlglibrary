package com.example.gdlglibrary.changebook;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gdlglibrary.R;
import com.example.gdlglibrary.givebackbook.backbookdone;
import com.example.gdlglibrary.givebackbook.selectuse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class changebookyes extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changebookyes);
        button = findViewById(R.id.bt_backdonereturn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(changebookyes.this, gods.class);
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