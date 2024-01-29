package com.example.sign_lang_ml;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Objects;
public class ModifypwdActivity extends AppCompatActivity {

    TextView password_1;
    TextView password_2;
    TextView password_3;
    private Button modifypwd_btn;
    private Button modifygb_btn;

    private DBOpenHelper dbopenHelper;
    private SharedPreferences spf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_pwd);


    }

    public void modifypwd(View view){
        spf = getSharedPreferences("users", Context.MODE_PRIVATE);
        String fetch_username = spf.getString("username", "");
        dbopenHelper = new DBOpenHelper(this);
        User select_user = dbopenHelper.select(fetch_username);

        modifypwd_btn = findViewById(R.id.buttonpwd);

        password_1 = findViewById(R.id.password_1);
        password_2 = findViewById(R.id.password_2);
        password_3 = findViewById(R.id.password_3);
        String password1=password_1.getText().toString();
        String password2=password_2.getText().toString();
        String password3=password_3.getText().toString();

        if (password1.trim().equals("") || password2.trim().equals("") || password3.trim().equals("")) {
            Toast.makeText(ModifypwdActivity.this, "请填写所有内容", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password2.trim().equals(password3.trim())) {
            Toast.makeText(ModifypwdActivity.this, "两次密码输入不一致，请重新输入", Toast.LENGTH_LONG).show();
            return;
        }
        if (!select_user.getPassword().equals(password1.trim())) {
            Toast.makeText(ModifypwdActivity.this, "原密码输入错误", Toast.LENGTH_LONG).show();
            return;
        }
        int r1=dbopenHelper.modifypwd(password3.trim(),select_user.getUsername());
        modifypwd_btn.setEnabled(false);
        modifypwd_btn.setTextColor(0xFFD0EFC6);

        if (r1 != -1) {
            Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();
            Intent re = new Intent(ModifypwdActivity.this, LoginActivity.class);
            startActivity(re);
        } else {
            Toast.makeText(this, "修改失败！", Toast.LENGTH_SHORT).show();
            Intent re = new Intent(ModifypwdActivity.this, ModifypwdActivity.class);
            startActivity(re);
        }

    }

    //点击返回跳转登录界面
    public void goback(View view) {
        Intent gl = new Intent(ModifypwdActivity.this, LoginActivity.class);
        startActivity(gl);
    }

    //监听按钮点击事件
    public void onClick(View view) {
        if (view.getId() == R.id.buttonpwd) {
            modifypwd(view);
        }
        if (view.getId() == R.id.buttongoback) {
            goback(view);
        }

    }
}
