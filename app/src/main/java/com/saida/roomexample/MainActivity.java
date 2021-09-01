package com.saida.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.saida.roomexample.abstrakt_class.PersonDatabase;
import com.saida.roomexample.classes.Utility;
import com.saida.roomexample.fragments.DeleteFragment;
import com.saida.roomexample.fragments.InsertFragment;
import com.saida.roomexample.fragments.ShowFragment;
import com.saida.roomexample.fragments.UpdateFragment;
import com.saida.roomexample.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PersonDatabase personDatabase;
    Button btnInsert,btnUpdate,btnDelete,btnShow;
    FrameLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personDatabase=PersonDatabase.getInstance(this);
        layout=findViewById(R.id.container);
        btnInsert=findViewById(R.id.insert);
        btnDelete=findViewById(R.id.delete);
        btnUpdate=findViewById(R.id.update);
        btnShow=findViewById(R.id.show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.setFragment(new ShowFragment(),getSupportFragmentManager());
                layout.setVisibility(View.VISIBLE);



            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.setFragment(new DeleteFragment(),getSupportFragmentManager());
                layout.setVisibility(View.VISIBLE);
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.setFragment(new InsertFragment(),getSupportFragmentManager());
                layout.setVisibility(View.VISIBLE);

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.setFragment(new UpdateFragment(),getSupportFragmentManager());
                layout.setVisibility(View.VISIBLE);

            }
        });

       personDatabase=PersonDatabase.getInstance(this);


    }
    @Override
    public void onBackPressed() {
        // do something on back.
        layout.setVisibility(View.GONE);
        return;
    }

}