package com.example.demo_loginandbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainAppActivity extends AppCompatActivity {
    TextView tv_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        tv_welcome = (TextView)findViewById(R.id.tvwelcome);
        SharedPreferences pref = getApplication().getSharedPreferences("myfile", 0);
        String name = pref.getString("name", "Guest");

        tv_welcome.setText("Welcome, " + name + "!");
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mn_input) {
            Intent intent = new Intent(MainAppActivity.this, InputActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.mn_view) {
            Intent intent = new Intent(MainAppActivity.this, ViewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.mn_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}