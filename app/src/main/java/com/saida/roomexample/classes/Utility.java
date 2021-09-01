package com.saida.roomexample.classes;


import android.text.Layout;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.saida.roomexample.R;

public class Utility {

    public static void setFragment(Fragment fragment, FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}
