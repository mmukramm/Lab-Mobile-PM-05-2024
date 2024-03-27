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
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private AppCompatButton button;
    private EditText namaField;
    private EditText usernameField;
    private Uri imgUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        img = findViewById(R.id.img);
        namaField = findViewById(R.id.namaField);
        usernameField = findViewById(R.id.usernameField);

        Intent secondActivity = new Intent(this, Activity2.class);

        img.setOnClickListener(v -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        button.setOnClickListener(v -> {

            try {
                String imgUriValue = imgUri.toString();
                if (!namaField.getText().toString().trim().isEmpty()) {
                    if (!usernameField.getText().toString().trim().isEmpty()) {
                        String namaFieldValue = namaField.getText().toString();
                        String usernameFieldValue = usernameField.getText().toString();
                        secondActivity.putExtra("nama", namaFieldValue);
                        secondActivity.putExtra("username", usernameFieldValue);
                        secondActivity.putExtra("imgUri", imgUriValue);
                        startActivity(secondActivity);
                    } else {
                        usernameField.setError("Wajib diisi");
                    }
                } else {
                    namaField.setError("Wajib diisi");
                }
            } catch (NullPointerException e) {
                CharSequence text = "Please select an image!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
                toast.show();

            }
        });


    }

    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    Uri image = data.getData();
                    img.setImageURI(image);
                    imgUri = image;
                }
            }
    );
}