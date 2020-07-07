package com.example.gdlglibrary.changebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gdlglibrary.R;
import com.example.qrcode.*;


public class gods extends AppCompatActivity {
    EditText editText;
    Button code,next;
    String codenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gods);

        next = findViewById(R.id.bt_godtonext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//需要判断是不是空
                if (editText.getText()!=null) {
                    Intent intent = new Intent(gods.this, changebooks.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(gods.this,"编码不能为空",Toast.LENGTH_LONG).show();
                }
            }
        });

        code = findViewById(R.id.bt_godcode);//扫描二维码
        editText = findViewById(R.id.gods_edit);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gods.this,CaptureActivity.class);//跳转到aar包
                startActivityForResult(intent,1);//给一个requestcode
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){//判断返回的requestcode是不是我们需要的
            codenum = data.getStringExtra("result");//获得扫描结果
            //设置结果显示框的显示数值
            editText.setText(codenum);//设置扫描结果
        }else{
            Toast.makeText(this,"没有返回信息！",Toast.LENGTH_LONG).show();//扫描了个寂寞
        }
    }
}