package com.saida.roomexample.abstrakt_class;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.saida.roomexample.interfaces.PersonDao;
import com.saida.roomexample.model.User;

@Database(entities = User.class, exportSchema = false, version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    private static final String DB_NAME = "person_db";
    private  static PersonDatabase personDatabase;


   public static synchronized PersonDatabase getInstance(Context context) {
        if (personDatabase == null) {
            personDatabase = Room.databaseBuilder(context, PersonDatabase.class,
                    DB_NAME)
                   // .allowMainThreadQueries()
                   //.fallbackToDestructiveMigration()
                    .build();

        }
        return personDatabase;
    }

    public abstract PersonDao personDao();

}
