package com.example.tugas2labpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    ImageView ivTampil;
    TextView tvNama;
    TextView tvUsername;
    TextView tvJudul;
    TextView tvIsi;
    public static final String EXTRA_JUDUL = "extra_judul";
    public static final String EXTRA_ISI = "extra_isi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ivTampil = findViewById(R.id.ivTampil);
        tvNama = findViewById(R.id.tvnama);
        tvUsername = findViewById(R.id.tvusername);
        tvJudul = findViewById(R.id.tvjudul);
        tvIsi = findViewById(R.id.tvisi);

        Intent intent = getIntent();
        if (intent != null) {
            String nama = intent.getStringExtra(MainActivity2.EXTRA_NAMA);
            String username = intent.getStringExtra(MainActivity2.EXTRA_USERNAME);
            Uri imageUriString = intent.getParcelableExtra(MainActivity2.EXTRA_IMAGE);
            String judul = intent.getStringExtra(EXTRA_JUDUL);
            String isi = intent.getStringExtra(EXTRA_ISI);

            tvNama.setText(nama);
            tvUsername.setText(username);
            tvJudul.setText(judul);
            tvIsi.setText(isi);

            if (imageUriString != null) {
                ivTampil.setImageURI(imageUriString);
            }
        }
    }
}