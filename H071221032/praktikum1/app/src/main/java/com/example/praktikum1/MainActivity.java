package com.example.praktikum1;

import android.os.Bundle;
import android.text.Editable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private ListView others;
    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submitText);
        others = findViewById(R.id.otherList);
        inputField = findViewById(R.id.otherInput);

        List<Editable> dataList = new ArrayList<>();
        ArrayAdapter<Editable> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        others.setAdapter(adapter);

        submit.setOnClickListener(v -> {
            Editable inputText = inputField.getText();
            if (inputText != null && !inputText.toString().isEmpty()) {
                dataList.add(inputText);
                adapter.notifyDataSetChanged();
                inputField.setText("");
            }
        });
    }
}