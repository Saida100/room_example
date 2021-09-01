package com.saida.roomexample.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.saida.roomexample.R;
import com.saida.roomexample.abstrakt_class.PersonDatabase;
import com.saida.roomexample.model.User;


public class DeleteFragment extends Fragment {

    PersonDatabase personDatabase;
    EditText editTextId, editTextName, editTextCity;
    Button buttonDelete;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextId = view.findViewById(R.id.id_user);
        editTextName = view.findViewById(R.id.name);
        editTextCity = view.findViewById(R.id.city);
        buttonDelete = view.findViewById(R.id.save);
        personDatabase = PersonDatabase.getInstance(getContext());
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteTask deleteTask=new DeleteTask();
                deleteTask.execute();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    class DeleteTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            //adding to database
            personDatabase.personDao().deletePerson(new User(Integer.valueOf(editTextId.getText().toString()), editTextName.getText().toString(),
                    editTextCity.getText().toString()));
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            if (aVoid)
                Toast.makeText(getContext(), "user " + editTextName.getText().toString() + " deleted", Toast.LENGTH_SHORT).show();
        }
    }
}