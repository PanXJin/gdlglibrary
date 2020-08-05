package com.example.gdlglibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.gdlglibrary.changebook.gods;
import com.example.gdlglibrary.givebackbook.selectuse;
import com.example.gdlglibrary.readbook.findbooks;

public class MainActivity extends AppCompatActivity {
Button showbt,changebt,givebt,userbt,mainbt;
String[] mTitles = new String[]{"首页","我的"};
BottomNavigationBar bottomNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.main_Bar);
        initview();
mainbt = findViewById(R.id.mainbutton);
mainbt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,test.class);
        startActivity(intent);
    }
});
        userbt = findViewById(R.id.userbutton);
        userbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        showbt = findViewById(R.id.bt_showbook);
        showbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, findbooks.class);
                startActivity(intent);
            }
        });

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
        }

        /**
         * 需要判断是不是管理员，但是管理员还没写，默认是管理员先
         */
        changebt = findViewById(R.id.bt_changebook);
        changebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, gods.class);
                startActivity(intent);
            }
        });
        givebt = findViewById(R.id.bt_givebook);
        givebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, selectuse.class);
                startActivity(intent);
            }
        });
    }
    //判断是否以获取权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(MainActivity.this, "必须授权才能进行", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
    private void initview(){
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor(R.color.orange)
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_home_pressed,mTitles[0])
                        .setInactiveIcon(ContextCompat.getDrawable(this,R.mipmap.ic_tabbar_home_normal))
                )
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_my_pressed,mTitles[1])
                        .setInactiveIcon(ContextCompat.getDrawable(this,R.mipmap.ic_tabbar_my_normal))
                )
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 0:
                          Toast.makeText(MainActivity.this,"已经在此页面！",Toast.LENGTH_SHORT).show();
//                        System.out.println("0!");
//                        Intent intent = new Intent(test.this,MainActivity.class);
//                        startActivity(intent);
                        break;
                    case 1:
//                                                        Toast.makeText(test.this,"真的有这种操作！",Toast.LENGTH_SHORT).show();
                        System.out.println("1!");
                        Intent intent1 = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}