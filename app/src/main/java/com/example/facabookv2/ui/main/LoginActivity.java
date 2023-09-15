package com.example.facabookv2.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facabookv2.R;

public class LoginActivity extends AppCompatActivity {
 EditText edusername;
 EditText edpassword;
 Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       edusername=findViewById(R.id.UserName);
        edpassword=findViewById(R.id.Password);
       loginButton=findViewById(R.id.LoginButton);


       loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String userName =edusername.getText().toString();
               String password = edpassword.getText().toString();

              if(userName.length()==0 || password.length()==0)
                  Toast.makeText(getApplicationContext(),"Please fill All details",Toast.LENGTH_SHORT).show();
                  else{
               Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
           startActivity(new Intent(LoginActivity.this,MainActivity.class));

                  }
           }
       });








    }
}