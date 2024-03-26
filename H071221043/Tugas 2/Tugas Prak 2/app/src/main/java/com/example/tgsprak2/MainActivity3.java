package com.example.tgsprak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tName = findViewById(R.id.textname);
        TextView tUname = findViewById(R.id.textuname);
        TextView tNote1 = findViewById(R.id.textnote1);
        TextView tNote2 = findViewById(R.id.textnote2);
        ImageView image = findViewById(R.id.img);

        Intent intent =getIntent();
        String nama = intent.getStringExtra("nama");
        String username = intent.getStringExtra("username");
        String note1 = intent.getStringExtra("note1");
        String note2 = intent.getStringExtra("note2");
        String img = intent.getStringExtra("image");

        Uri imageUri = Uri.parse(img);
        image.setImageURI(imageUri);

        tName.setText(nama);
        tUname.setText(username);
        tNote1.setText(note1);
        tNote2.setText(note2);
    }
}