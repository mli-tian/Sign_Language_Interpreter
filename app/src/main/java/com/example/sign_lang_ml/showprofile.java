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

public class showprofile extends AppCompatActivity {

    TextView username;
    TextView identity;
    TextView signature;
    private AlertDialog dlg;
    private TextView tv_user;
    private ImageView btn_user;

    private AlertDialog dlg_phone;
    private TextView tv_phone;
    private ImageView btn_phone;

    private AlertDialog dlg_per;
    private TextView tv_per;
    private ImageView btn_per;

    private AlertDialog dlg_sex;
    private TextView tv_sex;
    private ImageView btn_sex;
    private Button btn_exit;
    private int flag=0;
    private int choice=0;

    private TextView tv_birth;
    private ImageView btn_birth;
    private DatePickerDialog dlg_birth;
    private DBOpenHelper dbopenHelper;

    private SharedPreferences spf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_profile);
        spf=getSharedPreferences("users", Context.MODE_PRIVATE);
        String fetch_username=spf.getString("username","");
        dbopenHelper = new DBOpenHelper(this);
        User select_user = dbopenHelper.select(fetch_username);
        username = findViewById(R.id.tv_user);
        identity = findViewById(R.id.tv_sex);
        signature = findViewById(R.id.tv_per);
        username.setText(select_user.getUsername());
        identity.setText(select_user.getIdentity());
        signature.setText(select_user.getSignature());


        //startActivity(new Intent(this,modifyprofile.class));
        tv_user=findViewById(R.id.tv_user);
        btn_user=findViewById(R.id.btn_user);
        tv_phone=findViewById(R.id.tv_phone);
        btn_phone=findViewById(R.id.btn_phone);
        tv_per=findViewById(R.id.tv_per);
        btn_per=findViewById(R.id.btn_per);
        tv_sex=findViewById(R.id.tv_sex);
        btn_sex=findViewById(R.id.btn_sex);
        tv_birth=findViewById(R.id.tv_birth);
        btn_birth=findViewById(R.id.btn_birth);
        btn_exit=findViewById(R.id.btn_exit);
        Listener listener=new Listener();
        btn_user.setOnClickListener(listener);
        btn_phone.setOnClickListener(listener);
        btn_per.setOnClickListener(listener);
        btn_sex.setOnClickListener(listener);
        btn_birth.setOnClickListener(listener);
        btn_exit.setOnClickListener(listener);

    }

    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_user:
                    View dlgview = LayoutInflater.from(showprofile.this).inflate(R.layout.dialog,null);
                    EditText etname=dlgview.findViewById(R.id.etname);
                    Button btnok=dlgview.findViewById(R.id.btnok);
                    btnok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_user.setText(etname.getText().toString());
                            dlg.dismiss();
                            String fetch_username=spf.getString("username","");
                            dbopenHelper.modifyusername(etname.getText().toString(),fetch_username);
                            SharedPreferences.Editor editor=spf.edit();
                            editor.putString("username",etname.getText().toString());//账号名
                            editor.apply();//提交数据
                        }
                    });
                    dlg= new AlertDialog.Builder(showprofile.this)
                            .setView(dlgview)
                            .create();
                    dlg.show();


                    break;
                case R.id.btn_phone:
                    View dlgview_phone = LayoutInflater.from(showprofile.this).inflate(R.layout.dialog,null);
                    EditText etname_phone=dlgview_phone.findViewById(R.id.etname);
                    Button btnok_phone=dlgview_phone.findViewById(R.id.btnok);
                    btnok_phone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_phone.setText(etname_phone.getText().toString());
                            dlg_phone.dismiss();
                        }
                    });
                    dlg_phone= new AlertDialog.Builder(showprofile.this)
                            .setView(dlgview_phone)
                            .create();
                    dlg_phone.show();
                    break;
                case R.id.btn_per:
                    View dlgview_per = LayoutInflater.from(showprofile.this).inflate(R.layout.dialog,null);
                    EditText etname_per=dlgview_per.findViewById(R.id.etname);
                    Button btnok_per=dlgview_per.findViewById(R.id.btnok);
                    btnok_per.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_per.setText(etname_per.getText().toString());
                            dlg_per.dismiss();

                            String fetch_username=spf.getString("username","");
                            dbopenHelper.modifysignature(etname_per.getText().toString(),fetch_username);
                        }
                    });
                    dlg_per= new AlertDialog.Builder(showprofile.this)
                            .setView(dlgview_per)
                            .create();
                    dlg_per.show();
                    break;

                case R.id.btn_sex:
                    String sex[]={"女","男"};
                    //flag=0;
                    choice=0;
                    dlg_sex=new AlertDialog.Builder(showprofile.this)
                            .setTitle("请选择性别")
//                        .setMessage("this is a dialog")
                            //数组选项0：默认项的数组下标
                            .setSingleChoiceItems(sex, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Log.i("test",i+"");
                                    flag=1;
                                    choice=i;
                                }
                            })
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if(flag==0){
                                        tv_sex.setText(sex[0]);
                                    }else{
                                        tv_sex.setText(sex[choice]);
                                    }

                                    String fetch_username=spf.getString("username","");
                                    dbopenHelper.modifyidentity(tv_sex.getText().toString(),fetch_username);

                                }
                            })
                            .create();
                    dlg_sex.show();
                    break;

                case R.id.btn_birth:
                    Calendar cal=Calendar.getInstance();
                    int year=cal.get(Calendar.YEAR);
                    int month=cal.get(Calendar.MONTH);
                    int day=cal.get(Calendar.DAY_OF_MONTH);
                    dlg_birth=new DatePickerDialog(showprofile.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            tv_birth.setText(i+"-"+(i1+1)+"-"+i2);
                        }
                    },year,month,day);
                    dlg_birth.show();
                    break;

                case R.id.btn_exit:
                    Intent intent =new Intent(showprofile.this,LoginActivity.class);
                    startActivity(intent);
                    break;


            }

        }
    }

}
