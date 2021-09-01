package com.saida.roomexample.interfaces;

import android.app.Person;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.saida.roomexample.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;


@Dao
public interface PersonDao {

    @Query("Select * from person")
    Flowable<List<User>> getPersonList();
    //List<User> getPersonList();

    @Insert
    void insertPerson(User person);

    @Update
    void updatePerson(User person);

    @Delete
    void deletePerson(User person);



}
