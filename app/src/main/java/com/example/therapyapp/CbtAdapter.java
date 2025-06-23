package com.example.therapyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CbtAdapter extends RecyclerView.Adapter<CbtAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(CbtEntry cbtEntry);
    }

    private List<CbtEntry> cbtEntries;
    private OnItemClickListener listener;

    public CbtAdapter(List<CbtEntry> cbtEntries, OnItemClickListener listener) {
        this.cbtEntries = cbtEntries;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cbtTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cbtTitle = itemView.findViewById(android.R.id.text1);
        }
        public void bind(final CbtEntry cbtEntry, final OnItemClickListener listener) {
            cbtTitle.setText(cbtEntry.getTitle());
            itemView.setOnClickListener(v -> listener.onItemClick(cbtEntry));
        }
    }

    @NonNull
    @Override
    public CbtAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CbtAdapter.ViewHolder holder, int position) {
        holder.bind(cbtEntries.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return cbtEntries.size();
    }
}
