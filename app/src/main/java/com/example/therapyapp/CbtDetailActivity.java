package com.example.therapyapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.List;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, distortions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistortion.setAdapter(adapter);

        Button cancelButton = findViewById(R.id.cancelButton);
        Button saveButton = findViewById(R.id.saveButton);

        inputQ1.setText(cbtEntry.getQ1_situation());
        inputQ2.setText(cbtEntry.getQ2_thoughtConfidence());
        inputQ3.setText(cbtEntry.getQ3_emotions());
        inputQ4.setText(cbtEntry.getQ4_supportingEvidence());
        inputQ5.setText(cbtEntry.getQ5_contradictingEvidence());
        inputQ6.setText(cbtEntry.getQ6_alternativeExplanation());
        inputQ7.setText(cbtEntry.getQ7_worstCase());
        inputQ8.setText(cbtEntry.getQ8_bestCase());
        inputQ9.setText(cbtEntry.getQ9_realisticOutcome());
        inputQ10.setText(cbtEntry.getQ10_consequencesBelief());
        inputQ11.setText(cbtEntry.getQ11_consequencesChange());
        inputQ12.setText(cbtEntry.getQ12_actions());
        inputQ13.setText(cbtEntry.getQ13_friendAdvice());
        String savedDistortion = cbtEntry.getQ14_distortion();
        if (savedDistortion != null && !savedDistortion.isEmpty()) {
            int position = adapter.getPosition(savedDistortion);
            if (position >= 0) {
                spinnerDistortion.setSelection(position);
            }
        }
        inputQ15.setText(cbtEntry.getQ15_nextSteps());

        cancelButton.setOnClickListener(v -> finish());

        saveButton.setOnClickListener(v -> {
            cbtEntry.setQ1_situation(inputQ1.getText().toString());
            cbtEntry.setQ2_thoughtConfidence(inputQ2.getText().toString());
            cbtEntry.setQ3_emotions(inputQ3.getText().toString());
            cbtEntry.setQ4_supportingEvidence(inputQ4.getText().toString());
            cbtEntry.setQ5_contradictingEvidence(inputQ5.getText().toString());
            cbtEntry.setQ6_alternativeExplanation(inputQ6.getText().toString());
            cbtEntry.setQ7_worstCase(inputQ7.getText().toString());
            cbtEntry.setQ8_bestCase(inputQ8.getText().toString());
            cbtEntry.setQ9_realisticOutcome(inputQ9.getText().toString());
            cbtEntry.setQ10_consequencesBelief(inputQ10.getText().toString());
            cbtEntry.setQ11_consequencesChange(inputQ11.getText().toString());
            cbtEntry.setQ12_actions(inputQ12.getText().toString());
            cbtEntry.setQ13_friendAdvice(inputQ13.getText().toString());
            cbtEntry.setQ14_distortion(spinnerDistortion.getSelectedItem().toString());
            cbtEntry.setQ15_nextSteps(inputQ15.getText().toString());

            saveEntryToFile(cbtEntry);

            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void saveEntryToFile(CbtEntry entry) {
        List<CbtEntry> entries = FileUtils.loadEntries(this);

        // If entry with same title exists, replace it
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getTitle().equals(entry.getTitle())) {
                entries.set(i, entry);
                FileUtils.saveEntries(this, entries);
                return;
            }
        }

        // If not found, add new
        entries.add(entry);
        FileUtils.saveEntries(this, entries);
    }
}