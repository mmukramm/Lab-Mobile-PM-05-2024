package com.example.praktikum2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity3 extends AppCompatActivity {
    private ImageView img;
    private TextView nama, username, title, konten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_3);

        img = findViewById(R.id.img);
        nama = findViewById(R.id.nama);
        username = findViewById(R.id.username);
        title = findViewById(R.id.titleField);
        konten = findViewById(R.id.contentField);

        Uri imgUri = Uri.parse(getIntent().getStringExtra("imgUri"));

        img.setImageURI(imgUri);

        nama.setText(getIntent().getStringExtra("nama"));
        username.setText(getIntent().getStringExtra("username"));

        title.setText(getIntent().getStringExtra("judul"));
        konten.setText(getIntent().getStringExtra("konten"));
    }
}