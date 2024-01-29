package com.example.sign_lang_ml;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_uname,et_upwd;//获取用户名，密码
    private CheckBox isRemember;
    private Button login_btn,register_btn;
    private String username,password,sp_name,sp_pwd;
    private Context mContext;
    private DBOpenHelper dbopenHelper;
    TextView tvC,sp_k;
    private SharedPreferences spf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        dbopenHelper = new DBOpenHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tvC = findViewById(R.id.tvRC);
        sp_k = findViewById(R.id.space_kong);
        init();//获取界面控件
        spf=getSharedPreferences("users", Context.MODE_PRIVATE);
        //tvC.setText("用户名(data):" + sp_name + "密码(data):" + sp_pwd);
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
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button5) {

            String n = et_uname.getText().toString();
            String p = et_upwd.getText().toString();
            if (n.equals("")) {
                Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            } else if (p.equals("")) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            } else {
                boolean login = dbopenHelper.login(n, p);
                if (login) {
                    Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
                    User select = dbopenHelper.select(n);
                    Intent home = new Intent(LoginActivity.this, MainActivity.class);
                    Intent profile = new Intent(LoginActivity.this, showprofile.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", select.username);
                    bundle.putString("password", select.password);
                    bundle.putString("identity", select.identity);
                    home.putExtras(bundle);
                    profile.putExtras(bundle);
                    et_uname.setText("");
                    et_upwd.setText("");
                    SharedPreferences.Editor editor=spf.edit();
                    editor.putString("username",n);//账号名
                    editor.apply();//提交数据
                    startActivity(home);

                } else {
                    Toast.makeText(this, "账号或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    et_upwd.setText("");
                }
            }
        }else if (id==R.id.button6) {
            Intent re = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(re);
        }
    }
    //获取界面控件
    private void init(){
        et_uname=findViewById(R.id.user);
        et_upwd=findViewById(R.id.pwo);
        isRemember=findViewById(R.id.remember);
        login_btn=findViewById(R.id.button5);
        register_btn=findViewById(R.id.button6);
        login_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

