package com.example.demo_loginandbook;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ViewActivity extends AppCompatActivity {
    private int selectedPosition = -1;
    private String[] titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ListView listView = findViewById(R.id.listtitle);
        Button btClose = findViewById(R.id.close);
        Button btView = findViewById(R.id.viewcontent);
        TextView tvContent = findViewById(R.id.resultcontent);

        // Lấy danh sách file và hiển thị lên ListView
        titleList = fileList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, titleList);
        listView.setAdapter(adapter);

        // Xử lý khi chọn một item trong danh sách
        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;
            Toast.makeText(ViewActivity.this,
                    "Choosing: " + titleList[position], Toast.LENGTH_SHORT).show();
        });

        // Xử lý khi nhấn nút xem nội dung
        btView.setOnClickListener(v -> {
            if (selectedPosition == -1) {
                Toast.makeText(ViewActivity.this,
                        "Choose title pls !", Toast.LENGTH_SHORT).show();
                return;
            }

            String filename = titleList[selectedPosition];
            try (FileInputStream fin = openFileInput(filename)) {
                byte[] buffer = new byte[fin.available()];
                fin.read(buffer);
                String content = new String(buffer, StandardCharsets.UTF_8);
                tvContent.setText(content);
            } catch (IOException e) {
                Toast.makeText(ViewActivity.this,
                        "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                tvContent.setText("");
            }
        });

        // Xử lý khi nhấn nút đóng
        btClose.setOnClickListener(v -> finish());
    }
}