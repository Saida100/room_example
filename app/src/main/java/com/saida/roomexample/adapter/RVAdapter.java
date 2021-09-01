package com.saida.roomexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saida.roomexample.R;
import com.saida.roomexample.model.User;
import com.saida.roomexample.viewholder.RVViewHolder;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVViewHolder> {
    List<User> userList;
    Context context;

    public RVAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }


    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_layout, parent, false);
        return new RVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }
}
