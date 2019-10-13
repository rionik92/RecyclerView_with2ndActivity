package com.example.lesson_recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> implements onViewHolderListener {

    ArrayList<String> data = new ArrayList<>();
    MainActivity activity;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(view);
        viewHolder.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addString(String s) {
        s = s + " : " + data.size();
        data.add(s);
        notifyDataSetChanged();

    }

    @Override
    public void onClick(int position) {
        String s = data.get(position);
        Intent intent = new Intent(activity, Main2Activity.class);
        intent.putExtra("key", s);
        activity.startActivity(intent);
    }
}
