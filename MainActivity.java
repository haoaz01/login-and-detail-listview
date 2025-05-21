package com.example.demo_loginandbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.ComponentActivity;

import androidx.activity.EdgeToEdge;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_username = (EditText) findViewById(R.id.inputName);
        EditText et_password = (EditText) findViewById(R.id.inputPassword);
        Button bt_login = (Button) findViewById(R.id.login);
        Button bt_creataccount = (Button) findViewById((R.id.creat_account));
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplication().getSharedPreferences("myfile", 0);
                String name = pref.getString("name", null);
                String pass = pref.getString("pass", null);
                if(name.equals(et_username.getText().toString()) && pass.equals(et_password.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this, MainAppActivity.class);
                    startActivity(intent);
                }

            }
        });
        bt_creataccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , CreateAccountActivity.class);
                startActivity(intent);
            }
        });


    }
}