package com.example.tugas2labpm;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView upGambar;
    private Button btnSubmit;
    private EditText etNama;
    private EditText etUsername;
    private String textNama;
    private String textUsername;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.etNama);
        etUsername = findViewById(R.id.etUsername);
        upGambar = findViewById(R.id.imageView);
        btnSubmit = findViewById(R.id.btnsubmit);

        upGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buka = new Intent(Intent.ACTION_PICK);
                buka.setType("image/*");
                openGallery.launch(buka);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textNama = etNama.getText().toString().trim();
                textUsername = etUsername.getText().toString().trim();

                if (imageUri == null) {
                    Toast.makeText(MainActivity.this, "Please pick a profile image first!", Toast.LENGTH_SHORT).show();
                } else if (textNama.isEmpty() || textUsername.isEmpty()) {
                    if (textNama.isEmpty()) {
                        etNama.setError("Field ini tidak boleh kosong");
                    } else if (textUsername.isEmpty()) {
                        etUsername.setError("Field ini tidak boleh kosong");
                    }
                } else {
                    Intent submit = new Intent(MainActivity.this, MainActivity2.class);
                    submit.putExtra(MainActivity2.EXTRA_NAMA, textNama);
                    submit.putExtra(MainActivity2.EXTRA_USERNAME, textUsername);
                    submit.putExtra(MainActivity2.EXTRA_IMAGE, imageUri);
                    startActivity(submit);
                }
            }
        });
    }

    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        imageUri = result.getData().getData();
                        upGambar.setImageURI(imageUri);
                    }
                }
            }
    );
}