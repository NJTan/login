package com.example.mylogin;



import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.IconCompat;

import java.lang.Boolean;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,

   RadioGroup.OnCheckedChangeListener {
       private String phone_str="";
       private String passwd_str="";
       private String sex_str="男性";
       private String hobby_str="1";
       private String city_str="";
        EditText phone_edit,passwd_edit;
        RadioGroup sex_group;
        RadioButton nan_but,nv_but;
        CheckBox play,read,music;
        Button register;
        Spinner spinner;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone_edit=(EditText)findViewById(R.id.phone);
        passwd_edit=(EditText) findViewById(R.id.paswd);
        sex_group=(RadioGroup)findViewById(R.id.sex) ;
        nan_but=(RadioButton) findViewById(R.id.nan);
        read=(CheckBox)findViewById(R.id.read_book);
        play=(CheckBox)findViewById(R.id.play_ball);
        music=(CheckBox)findViewById(R.id.music);
        register=(Button)findViewById(R.id.register);


        register.setOnClickListener(this);
        spinner=(Spinner)findViewById(R.id.spinner);
        final String[] city=new String[]{"北京","上海","武汉","南京","南昌","信阳"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,city);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city_str=city[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.register:

                phone_str = phone_edit.getText().toString();
                passwd_str = passwd_edit.getText().toString();
                hobby_str = "";
                if (read.isChecked()) {
                    hobby_str += read.getText().toString();
                }
                if (play.isChecked()) {
                    hobby_str += play.getText().toString();
                }
                if (music.isChecked()) {
                    hobby_str += music.getText().toString();
                }

                Intent intent = new Intent(this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("phone", phone_str);
                bundle.putString("paswd", passwd_str);
                bundle.putString("hobby", hobby_str);
                bundle.putString("city", city_str);
                bundle.putString("sex", sex_str);
                intent.putExtras(bundle);
                Log.i("activitit","phone"+phone_str+"\n"+"passwd"+passwd_str+"\n    ");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        boolean gender;
        if (i==0){
           gender=true;
        }else{
            gender=false;
        }
        sex_str =gender ? "男" : "女";
    }
}

