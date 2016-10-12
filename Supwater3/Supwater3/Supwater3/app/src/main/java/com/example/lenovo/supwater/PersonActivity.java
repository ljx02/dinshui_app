package com.example.lenovo.supwater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class PersonActivity extends AppCompatActivity {
    private TextView xuehao,sushe,dianhua,zhanghao,shuipiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        Bmob.initialize(this, "50764f96d5bc2a147039f61ef5ae1271");
        xuehao= (TextView) findViewById(R.id.xuehao);
        sushe=(TextView) findViewById(R.id.sushe);
        dianhua=(TextView) findViewById(R.id.dianhua);
        zhanghao=(TextView)findViewById(R.id.zhanghao);
        shuipiao=(TextView)findViewById(R.id.shuipiao);
        Myuser myUser= BmobUser.getCurrentUser(PersonActivity.this, Myuser.class);
        if(null==myUser){
            Toast.makeText(PersonActivity.this, "重新注册", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(PersonActivity.this,"已经登录",Toast.LENGTH_LONG).show();
            xuehao.setText(myUser.getXuehao().toString());
            sushe.setText(myUser.getSushe().toString());
            dianhua.setText(myUser.getDianhua().toString());
            zhanghao.setText(myUser.getUsername().toString());
            shuipiao.setText(myUser.getShuipiao().toString());
        }


    }
}
