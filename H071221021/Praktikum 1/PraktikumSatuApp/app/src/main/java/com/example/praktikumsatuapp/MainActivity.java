package com.example.praktikumsatuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText in;
    private Button eb;
    private TextView to;
    private EditText ip;
    private Button btn;
    private ListView re;

    public ArrayList<String> dataList;
    public ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in = findViewById(R.id.inputnama);
        eb = findViewById(R.id.editbtn);
        to = findViewById(R.id.textold);
        ip = findViewById(R.id.input);
        btn = findViewById(R.id.editbtn2);
        re = findViewById(R.id.hasil);

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.listitem, dataList);
        re.setAdapter(adapter);


        eb.setOnClickListener(view -> {
            to.setText(in.getText());
            in.setText("");
        });

        btn.setOnClickListener(v -> {
            String newText = ip.getText().toString().trim();
            if (!newText.isEmpty()) {
                dataList.add(newText);
                adapter.notifyDataSetChanged();
                ip.getText().clear();
            }
        });
    }
}