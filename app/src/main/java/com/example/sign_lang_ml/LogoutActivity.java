package com.example.sign_lang_ml;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class LogoutActivity extends AppCompatActivity {
    private EditText et_uname,et_upwd;//获取用户名，密码
    private CheckBox isRemember;
    private Button login_btn,register_btn;
    private String username,password,sp_name,sp_pwd;
    private Context mContext;
    private DBOpenHelper dbOpenHelper;
    TextView tvC,sp_k;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        dbOpenHelper = new DBOpenHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tvC = findViewById(R.id.tvRC);
        sp_k = findViewById(R.id.space_kong);
        init();//获取界面控件

        //tvC.setText("用户名(data):" + sp_name + "密码(data):" + sp_pwd);
    }
    //点击返回跳转登录界面
    public void goback(View view) {
        Intent gl = new Intent(LogoutActivity.this, LoginActivity.class);
        startActivity(gl);
    }
    //@Override
    //public void onClick(View view){
    //是否记住密码的标志
    //Boolean sp_isRemember = sp.getBoolean("isRemember", false);
    //如果有账号，直接显示
    //Log.d("TAG",sp_name);
    //et_uname.setText(sp_name);
    //如果上次登录记住了密码，本次登录直接设置上
    //if(sp_isRemember.equals(true)){
    //    et_upwd.setText(sp_pwd);
    //    isRemember.setChecked(true);
    //}

    //获取界面控件
    private void init(){
        et_uname=findViewById(R.id.user);
        et_upwd=findViewById(R.id.pwo);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

