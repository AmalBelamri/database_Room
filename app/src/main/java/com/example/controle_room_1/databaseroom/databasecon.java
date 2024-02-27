package com.example.controle_room_1.databaseroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.controle_room_1.Model.Formation;
import com.example.controle_room_1.dao.DoaFormation;

@Database(entities = Formation.class, version = 4, exportSchema = false)
public abstract class databasecon extends RoomDatabase {
    private static databasecon database;
    private static String databaseName = "Crud";
    public synchronized static databasecon getInstance(Context context){
        if(database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                            databasecon.class, databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract DoaFormation mainDAO();
}
