package com.example.demo_loginandbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        EditText et_newusername = (EditText) findViewById(R.id.inputNewName);
        EditText et_newpassword = (EditText) findViewById(R.id.inputNewPassword);
        Button bt_close = (Button) findViewById(R.id.close);
        Button bt_createnew = (Button) findViewById(R.id.create);

        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_createnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("myfile", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name", et_newusername.getText().toString());
                editor.putString("pass", et_newpassword.getText().toString());
                editor.commit();
                Intent intent = new Intent(CreateAccountActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });


    }
}