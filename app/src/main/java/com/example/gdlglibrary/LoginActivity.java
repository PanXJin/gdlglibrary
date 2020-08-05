package com.example.gdlglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.gdlglibrary.okhttputilstest.Constans;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class LoginActivity extends AppCompatActivity {
//    @Bind(R.id.username)
    EditText name;
//    @Bind(R.id.password)
    EditText key;
//    @Bind(R.id.login)
    Button login;
    String[] mTitles = new String[]{"首页","我的"};
    BottomNavigationBar bottomNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        key = findViewById(R.id.password);
        name = findViewById(R.id.username);
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.login_buttonBar);
        initview();

//        ButterKnife.bind(this);
        login.setOnClickListener(view->
                new Thread(()->getDataFromNet()).start()
        );
    }
    private void getDataFromNet() {
        String url = Constans.LOGIN_URL;
        OkHttpUtils
                .get()
                .url(url)
                .addParams("name",name.getText().toString())
                .addParams("key",key.getText().toString())
                .build()
                .execute(new StringCallback()
                {
                    /**
                     * 请求失败的时候回调
                     * @param call
                     * @param e
                     * @param id
                    */
                   @Override
                    public void onError(Call call, Exception e, int id) {
                        System.out.println("首页请求失败=="+e.getMessage());
                     }
                    /**
                      * 当请求成功的时候回调
                      * @param response 请求成功数据
                     * @param id
                     */
                    @Override
                    public void onResponse(String response, int id) {
                        System.out.println("首页请求成功=="+response);
                        //解析数据
                        processData(response);
                    }
                });
    }

    private void processData(String json) {
        System.out.println(json);
        if(json.equals("YES")){
            Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else
            Toast.makeText(this,"用户名或者密码错误",Toast.LENGTH_SHORT).show();
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
                .setFirstSelectedPosition(1)
                .initialise();
        bottomNavigationBar
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        switch (position){
                            case 0:
//                              Toast.makeText(MainActivity.this,"已经在此页面！",Toast.LENGTH_SHORT).show();
//                              System.out.println("0!");
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 1:
                                                        Toast.makeText(LoginActivity.this,"已经再次页面！",Toast.LENGTH_SHORT).show();
//                                System.out.println("1!");
//                                Intent intent1 = new Intent(MainActivity.this,LoginActivity.class);
//                                startActivity(intent1);
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