package com.example.praktikum2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    private String username, nama, imgUri;
    EditText judul, konten;
    private AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        username = getIntent().getStringExtra("username");
        nama = getIntent().getStringExtra("nama");
        imgUri = getIntent().getStringExtra("imgUri");

        judul = findViewById(R.id.titleField);
        konten = findViewById(R.id.contentField);

        button = findViewById(R.id.button);

        Intent thirdActivity = new Intent(this, Activity3.class);

        button.setOnClickListener(v -> {

            String judulValue = judul.getText().toString();
            String kontenValue = konten.getText().toString();
            if (!judulValue.isEmpty()) {
                if (!kontenValue.isEmpty()) {
                    thirdActivity.putExtra("username", username);
                    thirdActivity.putExtra("nama", nama);
                    thirdActivity.putExtra("judul", judulValue);
                    thirdActivity.putExtra("konten", kontenValue);
                    thirdActivity.putExtra("imgUri", imgUri);
                    startActivity(thirdActivity);
                } else {
                    konten.setError("Wajib diisi");
                }
            } else {
                judul.setError("Wajib diisi");
            }
        });
    }
}