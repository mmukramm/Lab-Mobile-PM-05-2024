package com.example.praktikum2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private ImageView image;
    public static final String EXTRA_TITLE = "textFromEt3";
    public static final String EXTRA_CONTENT = "textFromEt4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        textView1 = findViewById(R.id.text);
        textView2 = findViewById(R.id.text1);
        textView3 = findViewById(R.id.text2);
        textView4 = findViewById(R.id.text3);
        image = findViewById(R.id.image);

        String text1 = getIntent().getStringExtra(MainActivity2.EXTRA_NAMA);
        String text2 = getIntent().getStringExtra(MainActivity2.EXTRA_USER);
        String text3 = getIntent().getStringExtra(EXTRA_TITLE);
        String text4 = getIntent().getStringExtra(EXTRA_CONTENT);
        String imageUriString = getIntent().getStringExtra(MainActivity2.EXTRA_IMG);

        textView1.setText(text1);
        textView2.setText(text2);
        textView3.setText(text3);
        textView4.setText(text4);
        Uri imageUri = Uri.parse(imageUriString);
        image.setImageURI(imageUri);
    }
}