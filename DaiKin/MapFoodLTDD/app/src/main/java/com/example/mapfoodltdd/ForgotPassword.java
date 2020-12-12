package com.example.mapfoodltdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    EditText username_reset106;
    Button btnreset106;
    DBHelper DB106;
    ImageView backfg16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        username_reset106=(EditText) findViewById(R.id.username_reset);
        btnreset106=(Button) findViewById(R.id.btnreset);
        DB106=new DBHelper(this);

        backfg16 = (ImageView) findViewById(R.id.backfg);
        backfg16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        btnreset106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username_reset106.getText().toString();
                Boolean checkuser=DB106.checkusername(user);
                if(checkuser==true){
                    Intent intent=new Intent(getApplicationContext(),ResetPassword.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }else{
                    Toast.makeText(ForgotPassword.this, "Username không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}