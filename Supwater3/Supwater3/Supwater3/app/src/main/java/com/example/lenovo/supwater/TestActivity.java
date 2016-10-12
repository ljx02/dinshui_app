package com.example.lenovo.supwater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class TestActivity extends AppCompatActivity {
    private EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "50764f96d5bc2a147039f61ef5ae1271");
        setContentView(R.layout.activity_test);
        etUsername=(EditText)findViewById(R.id.query_et);
        etPassword=(EditText)findViewById(R.id.editText);
        ImageButton button4=(ImageButton)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,LoginActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }
    public void login(View view) {
        String username1 = etUsername.getText().toString();
        String password1 = etPassword.getText().toString();
        if (TextUtils.isEmpty(username1) || TextUtils.isEmpty(password1)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        BmobUser user = new BmobUser();
        user.setUsername(username1);
        user.setPassword(password1);
        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(TestActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                Myuser user1 = BmobUser.getCurrentUser(TestActivity.this, Myuser.class);
                startActivity(new Intent(TestActivity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(TestActivity.this, "登录失败", Toast.LENGTH_LONG).show();
            }
        });

    }}
