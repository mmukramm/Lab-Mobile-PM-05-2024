package com.example.praktikum2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText et3;
    private EditText et4;
    private Button btn1;

    private String textFromEt3;
    private String textFromEt4;
    public static final String EXTRA_NAMA = "textFromEt1";
    public static final String EXTRA_USER = "textFromEt2";
    public static final String EXTRA_IMG = "imageUri";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(view -> {
            textFromEt3 = et3.getText().toString().trim();
            textFromEt4 = et4.getText().toString().trim();

            if (textFromEt3.isEmpty() || textFromEt4.isEmpty()) {
                Toast.makeText(this, "Isi semua field terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, MainActivity3.class);
                // Meneruskan data ke MainActivity3
                intent.putExtra(EXTRA_NAMA, getIntent().getStringExtra(EXTRA_NAMA));
                intent.putExtra(EXTRA_USER, getIntent().getStringExtra(EXTRA_USER));
                intent.putExtra(MainActivity3.EXTRA_TITLE, textFromEt3);
                intent.putExtra(MainActivity3.EXTRA_CONTENT, textFromEt4);
                // Meneruskan data gambar dari MainActivity
                intent.putExtra(EXTRA_IMG, getIntent().getStringExtra(EXTRA_IMG));
                startActivity(intent);
            }
        });
    }

    public String getTextFromEt3() {
        return textFromEt3;
    }

    public String getTextFromEt4() {
        return textFromEt4;
    }
}