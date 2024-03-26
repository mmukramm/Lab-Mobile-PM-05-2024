package com.example.tugas2labpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText etJudul;
    private EditText etIsi;
    private Button btnSave;
    private String textJudul;
    private String textIsi;
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_IMAGE = "extra_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etJudul = findViewById(R.id.etJudul);
        etIsi = findViewById(R.id.etIsi);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textJudul = etJudul.getText().toString().trim();
                textIsi = etIsi.getText().toString().trim();

                if (textIsi.isEmpty()) {
                    etIsi.setError("Field ini tidak boleh kosong");
                } else if (textJudul.isEmpty()) {
                    etJudul.setError("Field ini tidak boleh kosong");
                } else {
                    Intent intent = getIntent();
                    Intent save = new Intent(MainActivity2.this, MainActivity3.class);
                    String nama = intent.getStringExtra(EXTRA_NAMA);
                    String username = intent.getStringExtra(EXTRA_USERNAME);
                    Uri imageUriString = intent.getParcelableExtra(EXTRA_IMAGE);

                    save.putExtra(EXTRA_NAMA, nama);
                    save.putExtra(EXTRA_USERNAME, username);
                    save.putExtra(EXTRA_IMAGE, imageUriString);
                    save.putExtra(MainActivity3.EXTRA_JUDUL, textJudul);
                    save.putExtra(MainActivity3.EXTRA_ISI, textIsi);
                    startActivity(save);
                }
            }
        });
    }
}