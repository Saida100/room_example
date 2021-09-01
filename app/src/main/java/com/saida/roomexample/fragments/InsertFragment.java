package com.saida.roomexample.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.saida.roomexample.R;
import com.saida.roomexample.abstrakt_class.PersonDatabase;
import com.saida.roomexample.model.User;

public class InsertFragment extends Fragment {
    PersonDatabase personDatabase;
    EditText editTextName,editTextCity;
    Button buttonSave;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextName=view.findViewById(R.id.name);
        editTextCity=view.findViewById(R.id.city);
        buttonSave=view.findViewById(R.id.save);
        personDatabase=PersonDatabase.getInstance(getContext());

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertTask insertTask=new InsertTask();
                insertTask.execute();
            }
        });


    }


    @Override
    public void onAttach(@NonNull Context context){

        super.onAttach(context);
    }

    class InsertTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            //adding to database
            personDatabase.personDao().insertPerson(new User(editTextName.getText().toString(),
                    editTextCity.getText().toString()));
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            if(aVoid)
            Toast.makeText(getContext(),"new user "+editTextName.getText().toString()+" inserted", Toast.LENGTH_SHORT).show();
        }
    }
}