package com.saida.roomexample.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saida.roomexample.R;
import com.saida.roomexample.model.User;

public class RVViewHolder extends RecyclerView.ViewHolder {

    TextView textViewId,textViewName,textViewCity;
    public RVViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewId=itemView.findViewById(R.id.id_user);
        textViewName=itemView.findViewById(R.id.name);
        textViewCity=itemView.findViewById(R.id.city);

    }

    public void bind(User user){
        textViewId.setText(String.valueOf(user.getId()));
        textViewName.setText(user.getName());
        textViewCity.setText(user.getCity());

    }
}
