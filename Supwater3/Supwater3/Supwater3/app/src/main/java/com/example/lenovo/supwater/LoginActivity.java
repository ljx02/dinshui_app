package com.example.lenovo.supwater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private EditText mZhanghao,mMima;
    private EditText mShuipiao;
    private EditText mXuehao,mSushe,mDianhua;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "50764f96d5bc2a147039f61ef5ae1271");
        mZhanghao=(EditText)findViewById(R.id.zhanghao);
        mMima=(EditText)findViewById(R.id.mima);
        mXuehao=(EditText)findViewById(R.id.xuehao);
        mSushe=(EditText)findViewById(R.id.sushe);
        mDianhua=(EditText)findViewById(R.id.dianhua);
        mShuipiao=(EditText)findViewById(R.id.shuipiao);

    }
    public void submit (View view){
        String username=mZhanghao.getText().toString();
        String password=mMima.getText().toString();
        String xuehao=mXuehao.getText().toString();
        String sushe=mSushe.getText().toString();
        Integer dianhua=Integer.parseInt(mDianhua.getText().toString());
        Integer shuipiao=Integer.parseInt(mShuipiao.getText().toString());
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_LONG ).show();
            return;
        }
        Myuser myUser=new Myuser();
        myUser.setUsername(username);
        myUser.setPassword(password);
        myUser.setShuipiao(shuipiao);
        myUser.setXuehao(xuehao);
        myUser.setSushe(sushe);
        myUser.setDianhua(dianhua);
        myUser.setGoushui(false);

        myUser.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {

                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this, TestActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(LoginActivity.this, "注册失败", Toast.LENGTH_LONG).show();
            }
        });
    }


}
