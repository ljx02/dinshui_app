package com.example.lenovo.supwater;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends Activity  {

public int sp;
    private TextView zshuipiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Bmob.initialize(this, "50764f96d5bc2a147039f61ef5ae1271");
        zshuipiao=(TextView)findViewById(R.id.shuipiao);
        final Myuser myUser=BmobUser.getCurrentUser(MainActivity.this,Myuser.class);
        zshuipiao.setText(myUser.getShuipiao().toString());
        Integer shuipiao=Integer.parseInt(myUser.getShuipiao().toString());
        sp=shuipiao;
        if (sp==0)
        {
            Toast.makeText(MainActivity.this,"您水票没有了，赶快去购买吧！",Toast.LENGTH_LONG).show();
        }
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer shuipiao = Integer.parseInt(zshuipiao.getText().toString());
                myUser.setShuipiao(shuipiao);
                myUser.setGoushui(true);
                myUser.update(MainActivity.this, new UpdateListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "订水成功", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, SuccessActivity.class));
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(MainActivity.this, "订水失败", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        Button button3=(Button)findViewById(R.id.button10);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zshuipiao.setText(Integer.valueOf(zshuipiao.getText().toString()) - 1 + "");
                Integer shuipiao=Integer.parseInt(zshuipiao.getText().toString());
                myUser.setShuipiao(shuipiao);
                myUser.setGoushui(false);
                myUser.update(MainActivity.this, new UpdateListener() {
                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(MainActivity.this,ShoushuiActivity.class));
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                        Toast.makeText(MainActivity.this, "收水成功", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(MainActivity.this, "收水失败", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BuyActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PersonActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
    }
}
