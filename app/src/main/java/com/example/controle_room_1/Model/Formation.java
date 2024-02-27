package com.example.controle_room_1.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Formation {
    @PrimaryKey(autoGenerate = true)
    public  int id;
    public  String nomFormation ;
    public  String dureeMois;
    public  String spinnre;

    public String getSpinnre() {
        return spinnre;
    }

    public void setSpinnre(String spinnre) {
        this.spinnre = spinnre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public String getDureeMois() {
        return dureeMois;
    }

    public void setDureeMois(String dureeMois) {
        this.dureeMois = dureeMois;
    }
}
