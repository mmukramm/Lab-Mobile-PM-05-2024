package com.example.tgsprak2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Uri image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnsubmit = findViewById(R.id.submit);
        EditText edtNama =  findViewById(R.id.nama);
        EditText edtUname =  findViewById(R.id.uname);
        ImageView gallery = findViewById(R.id.gallery);

        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        image = data.getData();
                        gallery.setImageURI(image);
                    }
                }
        );

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGallery = new Intent(Intent.ACTION_PICK);
                openGallery.setType("image/*");
                launcherIntentGallery.launch(openGallery);
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = edtNama.getText().toString();
                String uname = edtUname.getText().toString();


                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                if (image != null){
                    intent.putExtra("image", image.toString());
                }else {
                    Toast.makeText(MainActivity.this, "Harap mengisi foto", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!nama.isEmpty()){
                    intent.putExtra("nama", nama);
                } else {
                    edtNama.setError( "First name is required!" );
                    return;
                }

                if (!uname.isEmpty()){
                    intent.putExtra("username", uname);
                }else {
                    edtUname.setError( "First name is required!" );
                    return;
                }
                User user = new User(nama, uname, "", "");

                startActivity(intent);
            }
        });
    }
}