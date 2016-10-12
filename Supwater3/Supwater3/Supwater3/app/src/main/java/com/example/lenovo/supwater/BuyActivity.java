package com.example.lenovo.supwater;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.listener.UpdateListener;

public class BuyActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        Bmob.initialize(this, "50764f96d5bc2a147039f61ef5ae1271");
        final Myuser myUser= BmobUser.getCurrentUser(BuyActivity.this, Myuser.class);
        myUser.getShuipiao().toString();
        Button button7=(Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.textView14);
                TextView textView = (TextView) findViewById(R.id.textView15);
                textView.setText(Integer.valueOf(editText.getText().toString()) * 8 + "");
            }
        });
        Button button1=(Button)findViewById(R.id.button8);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuyActivity.this,"购买成功",Toast.LENGTH_LONG).show();
                EditText editText1=(EditText)findViewById(R.id.textView14);
                myUser.setShuipiao(Integer.valueOf(editText1.getText().toString()) + Integer.valueOf(myUser.getShuipiao().toString()));
                myUser.update(BuyActivity.this, new UpdateListener() {
                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(BuyActivity.this, MainActivity.class));
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    }

                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
            }
        });
        Button buttonqu=(Button)findViewById(R.id.button9);
        buttonqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        startActivity(new Intent(BuyActivity.this, MainActivity.class));
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }
}
