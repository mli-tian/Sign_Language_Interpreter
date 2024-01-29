package com.example.sign_lang_ml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user, pwo, rpw;
    Button register_btn;
    CheckBox checkBox3;
    EditText identity;
    private Spinner SpinnerIdentity;
    private DBOpenHelper DBOpenHelper;
    //控制注册按钮点击完后不给点击了
    boolean flag = false;
    private SharedPreferences spf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DBOpenHelper = new DBOpenHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        spf=getSharedPreferences("users", Context.MODE_PRIVATE);
        //初始化获取的布局元素
        find();
    }
    //点击返回跳转登录界面
    public void goback(View view) {
        Intent gl = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(gl);
    }

    public void find() {
        register_btn = findViewById(R.id.buttonR);
        pwo = findViewById(R.id.pwo);//输入密码
        rpw = findViewById(R.id.rpw);//确认密码
        user = findViewById(R.id.user);
        checkBox3 = findViewById(R.id.remember);
        register_btn.setOnClickListener(this);
    }
    public void register(View view) {
        String ruser = user.getText().toString();
        String rpwo = pwo.getText().toString();
        String rrpw = rpw.getText().toString();
        User user_all = new User(ruser, rpwo);
        String res = "欢迎你，你的注册信息如下：\n" + "用户名：" + ruser.trim() + "\n密码：" + rpwo.trim();
        if (checkBox3.isChecked()) {
            if (rrpw.trim().equals("") || rpwo.trim().equals("") || ruser.trim().equals("")) {
                Toast.makeText(RegisterActivity.this, "请填写所有内容", Toast.LENGTH_LONG).show();
                return;
            }
            if (!rrpw.trim().equals(rpwo.trim())) {
                Toast.makeText(RegisterActivity.this, "两次密码输入不一致，请重新输入", Toast.LENGTH_LONG).show();
                return;
            }
            long r1 = DBOpenHelper.register(user_all);
            register_btn.setEnabled(false);
            register_btn.setTextColor(0xFFD0EFC6);
            if (r1 != -1) {
                SharedPreferences.Editor editor=spf.edit();
                editor.putString("username",ruser);//账号名
                editor.apply();//提交数据
                Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
                Intent re = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(re);
            } else {
                Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(RegisterActivity.this, "请阅读会员协议并勾选", Toast.LENGTH_LONG).show();
        }
    }

    //监听按钮点击事件
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonR) {
            register(view);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
