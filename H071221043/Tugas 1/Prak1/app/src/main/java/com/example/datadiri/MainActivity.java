package com.example.datadiri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        ListView list = findViewById(R.id.list);
        EditText edit = findViewById(R.id.edit);

        data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listviewitem, data);
        list.setAdapter(adapter);

        button.setOnClickListener(v -> {
            String listview = String.valueOf(edit.getText());
            data.add(listview);

            adapter.notifyDataSetChanged();
        });
    }






}