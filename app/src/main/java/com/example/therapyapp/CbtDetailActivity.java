package com.example.therapyapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class CbtDetailActivity extends AppCompatActivity {

    private CbtEntry cbtEntry;
    private EditText inputQ1, inputQ2, inputQ3, inputQ4, inputQ5, inputQ6, inputQ7,
            inputQ8, inputQ9, inputQ10, inputQ11, inputQ12, inputQ13, inputQ15;
    private Spinner spinnerDistortion;
    private static final String[] distortions = {
            "Синдром маленького цыпленка",
            "Чтение мыслей",
            "Склонность относить все на свой счет",
            "Доверие своему пресс-секретарю",
            "Доверие критикам",
            "Максимализм",
            "Болезненное сравнение",
            "А что, если...",
            "Ты должен!",
            "Да, но..."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbt_detail);

        cbtEntry = (CbtEntry) getIntent().getSerializableExtra("cbtEntry");
        setTitle(cbtEntry.getTitle());

        inputQ1 = findViewById(R.id.inputQ1);
        inputQ2 = findViewById(R.id.inputQ2);
        inputQ3 = findViewById(R.id.inputQ3);
        inputQ4 = findViewById(R.id.inputQ4);
        inputQ5 = findViewById(R.id.inputQ5);
        inputQ6 = findViewById(R.id.inputQ6);
        inputQ7 = findViewById(R.id.inputQ7);
        inputQ8 = findViewById(R.id.inputQ8);
        inputQ9 = findViewById(R.id.inputQ9);
        inputQ10 = findViewById(R.id.inputQ10);
        inputQ11 = findViewById(R.id.inputQ11);
        inputQ12 = findViewById(R.id.inputQ12);
        inputQ13 = findViewById(R.id.inputQ13);
        spinnerDistortion = findViewById(R.id.spinnerDistortion);
        inputQ15 = findViewById(R.id.inputQ15);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, distortions);
        spinnerDistortion.setAdapter(adapter);
    }
}