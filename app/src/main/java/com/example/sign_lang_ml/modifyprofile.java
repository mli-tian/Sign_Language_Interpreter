package com.example.sign_lang_ml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class modifyprofile extends AppCompatActivity {
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
    private int flag=0;
    private int choice=0;

    private TextView tv_birth;
    private ImageView btn_birth;
    private DatePickerDialog dlg_birth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Listener listener=new Listener();
        btn_user.setOnClickListener(listener);
        btn_phone.setOnClickListener(listener);
        btn_per.setOnClickListener(listener);
        btn_sex.setOnClickListener(listener);
        btn_birth.setOnClickListener(listener);
    }
    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_user:
                    View dlgview = LayoutInflater.from(modifyprofile.this).inflate(R.layout.dialog,null);
                    EditText etname=dlgview.findViewById(R.id.etname);
                    Button btnok=dlgview.findViewById(R.id.btnok);
                    btnok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_user.setText(etname.getText().toString());
                            dlg.dismiss();
                        }
                    });
                    dlg= new AlertDialog.Builder(modifyprofile.this)
                            .setView(dlgview)
                            .create();
                    dlg.show();
                    break;
                case R.id.btn_phone:
                    View dlgview_phone = LayoutInflater.from(modifyprofile.this).inflate(R.layout.dialog,null);
                    EditText etname_phone=dlgview_phone.findViewById(R.id.etname);
                    Button btnok_phone=dlgview_phone.findViewById(R.id.btnok);
                    btnok_phone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_phone.setText(etname_phone.getText().toString());
                            dlg_phone.dismiss();
                        }
                    });
                    dlg_phone= new AlertDialog.Builder(modifyprofile.this)
                            .setView(dlgview_phone)
                            .create();
                    dlg_phone.show();
                    break;
                case R.id.btn_per:
                    View dlgview_per = LayoutInflater.from(modifyprofile.this).inflate(R.layout.dialog,null);
                    EditText etname_per=dlgview_per.findViewById(R.id.etname);
                    Button btnok_per=dlgview_per.findViewById(R.id.btnok);
                    btnok_per.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_per.setText(etname_per.getText().toString());
                            dlg_per.dismiss();
                        }
                    });
                    dlg_per= new AlertDialog.Builder(modifyprofile.this)
                            .setView(dlgview_per)
                            .create();
                    dlg_per.show();
                    break;

                case R.id.btn_sex:
                    String sex[]={"女","男"};
                    //flag=0;
                    choice=0;
                    dlg_sex=new AlertDialog.Builder(modifyprofile.this)
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
                    dlg_birth=new DatePickerDialog(modifyprofile.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            tv_birth.setText(i+"-"+(i1+1)+"-"+i2);
                        }
                    },year,month,day);
                    dlg_birth.show();
                    break;
            }

        }
    }
}
