package com.example.tgsprak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText edtNote1 = findViewById(R.id.note1);
        EditText edtNote2 = findViewById(R.id.note2);
        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note1 = edtNote1.getText().toString();
                String note2 = edtNote2.getText().toString();

                String nama = getIntent().getStringExtra("nama");
                String username = getIntent().getStringExtra("username");
                String image = getIntent().getStringExtra("image");
                
                if (!note1.isEmpty() && !note2.isEmpty()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("image", image);
                    intent.putExtra("nama", nama);
                    intent.putExtra("username", username);
                    intent.putExtra("note1", note1);
                    intent.putExtra("note2", note2);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Harap lengkapi", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}