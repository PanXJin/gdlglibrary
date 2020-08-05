package com.example.gdlglibrary;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class test extends AppCompatActivity {
    //add
    String[] mTitles = new String[]{"首页", "我的"};
    BottomNavigationBar mBottomNavigationBar;
    //end
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mBottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bar_botton);
        intview();

    }
    private void intview() {
        //底层导航栏
        mBottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor(R.color.colorPrimary)//选中颜色 图标和文字
                .setInActiveColor("#8e8e8e");//默认未选择颜色
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_home_pressed, mTitles[0])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.ic_tabbar_home_normal))
//                        .setActiveColor(R.color.white)
//                        .setInActiveColor(R.color.black)
                )
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_my_pressed, mTitles[1])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.ic_tabbar_my_normal))
//                        .setActiveColor(R.color.white)
//                        .setInActiveColor(R.color.black)
                )
                .setFirstSelectedPosition(2)
                .initialise();//所有的设置需在调用该方法前完成```
        mBottomNavigationBar //设置lab点击事件
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                                            @Override
                                            public void onTabSelected(int position) {
                                                switch (position){
                                                    case 0:
//                                                        Toast.makeText(test.this,"竟让有这种操作！",Toast.LENGTH_SHORT).show();
                                                        System.out.println("0!");
                                                        Intent intent = new Intent(test.this,MainActivity.class);
                                                        startActivity(intent);

                                                        break;
                                                    case 1:
//                                                        Toast.makeText(test.this,"真的有这种操作！",Toast.LENGTH_SHORT).show();
                                                        System.out.println("1!");
                                                        Intent intent1 = new Intent(test.this,LoginActivity.class);
                                                        startActivity(intent1);
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
        //end
    }
}