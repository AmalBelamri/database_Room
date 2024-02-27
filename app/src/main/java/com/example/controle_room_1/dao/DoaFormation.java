package com.example.controle_room_1.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controle_room_1.Model.Formation;

import java.util.List;

@Dao
public interface DoaFormation {
    @Insert
    void  insert(Formation formation);
    @Query("UPDATE formation set nomFormation=:name , dureeMois =:prenom where id=:id  ")
    void  Update(int id , String name , String prenom);
    @Delete
    Void delete(Formation formation);
    @Query("SELECT * FROM formation ORDER BY id DESC")
    List<Formation> getAll();
}
