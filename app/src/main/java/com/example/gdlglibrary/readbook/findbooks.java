package com.example.gdlglibrary.readbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gdlglibrary.R;
import com.example.gdlglibrary.connections.cha;
import com.example.qrcode.CaptureActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 需要扫描二维码输入
 */
public class findbooks extends AppCompatActivity {
Button code,next;
EditText editText;
String returnbookname,returnbookNo,returnbackDate;
int returnid,returnwhere,returninit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findbooks);


        //扫描二维码
        code = findViewById(R.id.bt_findcode);
        editText = findViewById(R.id.editTextTextPersonName);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findbooks.this, CaptureActivity.class);//跳转到aar包
                startActivityForResult(intent,1);//给一个requestcode
            }
        });

        //下一个页面
        next = findViewById(R.id.bt_findtonext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//需要判断是不是空
                if (editText.getText().toString()!=null) {
                returnid = Integer.parseInt(editText.getText().toString());
                Toast.makeText(findbooks.this,"你要搜索的是："+returnid,Toast.LENGTH_SHORT).show();
                cha ca = new cha();
                ca.setCode(returnid);
                ca.cha(returnid);
                returnid = ca.getCode();

                returnbookname = ca.getBookname();
                returnwhere = ca.getWhere();
                returnbookNo = ca.getBookNo();
                returninit = ca.getInit();
                returnbackDate = ca.getDate();

                Intent intent = new Intent(findbooks.this, showbooks.class);
                intent.putExtra("id",returnid);
                intent.putExtra("bookname",returnbookname);
                intent.putExtra("where",returnwhere);
                intent.putExtra("bookNo",returnbookNo);
                intent.putExtra("init",returninit);
                intent.putExtra("backDate",returnbackDate);
                startActivity(intent);
                }else {
                    Toast.makeText(findbooks.this,"编码不能为空",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){//判断返回的requestcode是不是我们需要的
            String code = data.getStringExtra("result");//获得扫描结果
            //设置结果显示框的显示数值
            editText.setText(code);//设置扫描结果
        }else
//            if(requestCode==2){
//            returnid = data.getStringExtra("id");
//            returnbookname = data.getStringExtra("bookname");
//            returnwhere = data.getStringExtra("where");
//            returnbookNo = data.getStringExtra("bookNo");
//            returninit = data.getStringExtra("init");
//            returnbackDate = data.getStringExtra("newDate");
//        }else
        {
            Toast.makeText(this,"没有返回信息！", Toast.LENGTH_LONG).show();//扫描了个寂寞
        }
    }
}