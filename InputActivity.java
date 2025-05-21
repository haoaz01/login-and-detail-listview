package com.example.demo_loginandbook;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText et_title = (EditText) findViewById(R.id.inputtitle);
        EditText et_author = (EditText) findViewById(R.id.inputauthor);
        EditText et_content = (EditText) findViewById(R.id.inputcontent);
        Button bt_close = (Button) findViewById(R.id.close);
        Button bt_save = (Button) findViewById(R.id.save);


        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = et_title.getText().toString();
                String data = "Author: " + et_author.getText().toString();
                data += "\nContent: " + et_content.getText().toString();
                try{
                    FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(InputActivity.this , "Save Successfully!",Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(InputActivity.this ,ex.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}