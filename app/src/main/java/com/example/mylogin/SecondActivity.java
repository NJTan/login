package com.example.mylogin;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       setContentView(R.layout.acitivity_second);
        Intent intent =this.getIntent();
        Bundle bundle=intent.getExtras();
        String phone =bundle.getString("phone");
        String paswd =bundle.getString("paswd");
        String sex=bundle.getString("sex");
        String hobby=bundle.getString("hobby");
        String city=bundle.getString("city");
        TextView show_text=(TextView)findViewById(R.id.show_content);
        show_text.setText("手机号："+phone+"\n"+"密码："+paswd+"\n"+"性别："+sex+"\n"+"爱好："+hobby+"\n"+"城市："+city+"\n");
    }
}
