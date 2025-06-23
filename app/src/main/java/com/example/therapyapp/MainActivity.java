package com.example.therapyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
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

        cbtEntries = FileUtils.loadEntries(this);
        adapter = new CbtAdapter(cbtEntries, cbtEntry -> {
            Intent intent = new Intent(MainActivity.this, CbtDetailActivity.class);
            intent.putExtra("cbtEntry", cbtEntry);
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v -> showAddEntryDialog());
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }

    private void refreshData() {
        cbtEntries.clear();
        cbtEntries.addAll(FileUtils.loadEntries(this));
        adapter.notifyDataSetChanged();
    }

    private void showAddEntryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Новая мысль");

        final EditText input = new EditText(this);
        input.setHint("Введите название");
        builder.setView(input);

        builder.setPositiveButton("Добавить", (dialog, which) -> {
            String title = input.getText().toString().trim();

            if (title.isEmpty()) {
                Toast.makeText(this, "Название не может быть пустым", Toast.LENGTH_SHORT).show();
                return;
            }

            for (CbtEntry e : cbtEntries) {
                if (e.getTitle().equals(title)) {
                    Toast.makeText(this, "Такая мысль уже существует", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            CbtEntry newEntry = new CbtEntry(title);
            cbtEntries.add(newEntry);
            adapter.notifyItemInserted(cbtEntries.size() - 1);

            // Start detail activity directly
            Intent intent = new Intent(MainActivity.this, CbtDetailActivity.class);
            intent.putExtra("cbtEntry", newEntry);
            startActivity(intent);
        });

        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}