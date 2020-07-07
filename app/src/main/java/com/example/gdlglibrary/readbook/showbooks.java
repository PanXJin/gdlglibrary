package com.example.gdlglibrary.readbook;
/**
 * 需要连接数据库查看信息
 */

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gdlglibrary.MainActivity;
import com.example.gdlglibrary.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class showbooks extends Activity {
Button button;
TextView id,bookname,where,bookNo,init;
    String returnbookname,returnbookNo,returnbackDate;
    int returnid,returnwhere,returninit;
    private static final String TAG = showbooks.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbooks);
        button = findViewById(R.id.bt_returnfind);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(showbooks.this, MainActivity.class);
                startActivity(intent);
            }
        });
        id = findViewById(R.id.textView_id);
        bookname = findViewById(R.id.textView_name);
        where = findViewById(R.id.textView_where);
        bookNo = findViewById(R.id.textView_num);
        init = findViewById(R.id.textView_init);
        Intent intent = getIntent();

        returnid=intent.getIntExtra("id",0);
        Log.d(TAG, "return the id"+returnid);
        id.setVisibility(View.VISIBLE);
        id.setText(String.valueOf(returnid));

        returnbookname=intent.getStringExtra("bookname");
        bookname.setText(returnbookname);

        returnwhere=intent.getIntExtra("where",0);
        where.setText(String.valueOf(returnwhere));

        returnbookNo=intent.getStringExtra("bookNo");
        bookNo.setText(returnbookNo);

        returninit=intent.getIntExtra("init",0);
        if (returninit==0){
                init.setText("在馆");
            }else if (returninit==1){
                init.setText("已被接走");
            }

        intent.getStringExtra("backDate");
    }
//    String returnbookname,returnbookNo,returnbackDate,returnid,returnwhere,returninit;
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==2){
//            //设置信息
//            returnid = data.getStringExtra("id");
//            id.setText(returnid);
//
//            returnbookname = data.getStringExtra("bookname");
//            bookname.setText(returnbookname);
//
//            returnwhere = data.getStringExtra("where");
//            where.setText(returnwhere);
//
//            returnbookNo = data.getStringExtra("bookNo");
//            bookNo.setText(returnbookNo);
//
//            returninit = data.getStringExtra("init");
//            if (returninit.equals(0)){
//                init.setText("在馆");
//            }else if (returninit.equals(1)){
//                init.setText("已被接走");
//            }
//
//            returnbackDate = data.getStringExtra("newDate");
//        }else{
//            Toast.makeText(this,"没有返回信息！", Toast.LENGTH_LONG).show();//扫描了个寂寞
//        }
//    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}