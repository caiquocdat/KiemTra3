package com.example.mapfoodltdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapfoodltdd.home.HomeFragment;

public class Login  extends AppCompatActivity {

    TextView signup, forgot1;
    CheckBox showpass;
    EditText username1, password1;
    Button sign;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //1
        signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
        //2
        username1 = (EditText) findViewById(R.id.username1);
        password1 = (EditText) findViewById(R.id.password1);
        sign = (Button) findViewById(R.id.sign);
        DB = new DBHelper(this);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(Login.this, "Vui lòng nhập tất cả giá trị", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(getApplicationContext(), HomeFragment.class);
//                        startActivity(intent);
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        showpass = (CheckBox) findViewById(R.id.showpass);
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    password1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    password1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        //3
        forgot1 = (TextView) findViewById(R.id.forgot1);
        forgot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPassword();
            }
        });


    }

    public void openSignUp() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
        finish();
    }

    //    //2. Kích nhảy trang Forgot Password
    public void openForgotPassword() {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
        finish();
    }

//    public void openFooter() {
//        Intent intent = new Intent(Login.this,MainActivity.class);
//        startActivity(intent);
//        finish();
//    }
}