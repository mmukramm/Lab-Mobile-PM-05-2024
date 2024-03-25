package com.example.praktikum2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private ImageView image;
    private Button btn;

    private String textFromEt1;
    private String textFromEt2;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        image = findViewById(R.id.img);
        btn = findViewById(R.id.btn);

        image.setOnClickListener(view -> {
            Intent open = new Intent(Intent.ACTION_PICK);
            open.setType("image/*");
            launcherIntentGallery.launch(open);
        });

        btn.setOnClickListener(view -> {
            textFromEt1 = et1.getText().toString().trim();
            textFromEt2 = et2.getText().toString().trim();

            if (textFromEt1.isEmpty()) {
                et1.setError("isi ki");
                Toast.makeText(this, "Isi semua field terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else if (textFromEt2.isEmpty()) {
                et2.setError("isi ki");
                Toast.makeText(this, "Isi semua field terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else if (imageUri == null) {
                Toast.makeText(this, "Pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
            }  else {
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra(MainActivity2.EXTRA_NAMA, textFromEt1);
                intent.putExtra(MainActivity2.EXTRA_USER, textFromEt2);
                intent.putExtra(MainActivity2.EXTRA_IMG, imageUri.toString());
                startActivity(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        imageUri = data.getData();
                        image.setImageURI(imageUri);
                    }
                }
            });

    public String getTextFromEt1() {
        return textFromEt1;
    }

    public String getTextFromEt2() {
        return textFromEt2;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}
