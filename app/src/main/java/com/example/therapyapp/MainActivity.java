package com.example.therapyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CbtEntry> cbtEntries = new ArrayList<>();
    private CbtAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.thoughtsRecyclerView);
        FloatingActionButton fab = findViewById(R.id.addEntryButton);

        adapter = new CbtAdapter(cbtEntries, cbtEntry -> {
            Intent intent = new Intent(MainActivity.this, CbtDetailActivity.class);
            intent.putExtra("cbtEntry", cbtEntry);
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v -> showAddEntryDialog());
    }

    private void showAddEntryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New Entry");

        final EditText input = new EditText(this);
        input.setHint("Enter thought title");
        builder.setView(input);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String cbtTitle = input.getText().toString().trim();
            if (!cbtTitle.isEmpty()) {
                cbtEntries.add(new CbtEntry(cbtTitle));
                adapter.notifyItemInserted(cbtEntries.size() - 1);
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}