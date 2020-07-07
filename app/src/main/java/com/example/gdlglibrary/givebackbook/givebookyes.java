package com.example.gdlglibrary.givebackbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gdlglibrary.R;

public class givebookyes extends AppCompatActivity {
    Button btnext,btreturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givebookyes);
        btnext = findViewById(R.id.bt_giveyesnext);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(givebookyes.this, givebookdone.class);
                startActivity(intent);
            }
        });
        btreturn = findViewById(R.id.bt_giveyesreturn);
        btreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(givebookyes.this, givebooks.class);
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