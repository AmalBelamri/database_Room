package com.example.controle_room_1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.controle_room_1.Model.Formation;
import com.example.controle_room_1.dao.DoaFormation;
import com.example.controle_room_1.databaseroom.databasecon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     EditText editTextnam, editTextprenom,editText_id;
     Spinner spinner ;
     ListView listView ;
    databasecon databasecon1;
    String[] stringArray = {"item1", "item2"};
    public ArrayList<String> formation_= new ArrayList<>();
     public List<Formation> formationArrayList;
     Button btn_add, btn_affiche,btn_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextnam = findViewById(R.id.textView);
        editTextprenom = findViewById(R.id.textView2);
        editText_id = findViewById(R.id.editTextText);
        spinner = findViewById(R.id.spinner1);
        btn_add = findViewById(R.id.button);
        btn_affiche= findViewById(R.id.button4);
        btn_update = findViewById(R.id.button5);
        listView = findViewById(R.id.list_item11);
        databasecon1 = databasecon.getInstance(this);
        formationArrayList = databasecon1.mainDAO().getAll();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,stringArray);
         spinner.setAdapter(adapter);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);


    btn_add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(editTextnam.length()==0 || editTextprenom.length()==0){
                Toast.makeText(MainActivity.this, "entre name amd prenom", Toast.LENGTH_SHORT).show();
            }else {
                Formation formation = new Formation();
                formation.setNomFormation(editTextnam.getText().toString());
                formation.setDureeMois(editTextprenom.getText().toString());
//                formation.setSpinnre(spinner.toString() );
                Toast.makeText(MainActivity.this, spinner.toString(), Toast.LENGTH_SHORT).show();
                 editTextprenom.setText("");
                 editTextnam.setText("");
                  databasecon1.mainDAO().insert(formation);
                Toast.makeText(MainActivity.this, "add en formation ", Toast.LENGTH_SHORT).show();
                listUpdate();
            }
        }
    });
        btn_affiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    for(Formation formation:formationArrayList){
                        formation_.add(formation.dureeMois +"\t"+formation.nomFormation );
                    }
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,formation_);
                listView.setAdapter(adapter);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextnam.length()==0 || editTextprenom.length()==0){
                    Toast.makeText(MainActivity.this, "enter nom and prenom !!", Toast.LENGTH_SHORT).show();
                }else {
                     int id = Integer.parseInt(editText_id.getText().toString());
                    for (Formation formation:formationArrayList){
                        if (formation.getId() == id){
                            String nom = editTextnam.getText().toString();
                            String prenom = editTextprenom.getText().toString();
                            databasecon1.mainDAO().Update(id,nom,prenom);
                }
                        listUpdate();

                   }
                }
            }
        });
    }
    private void listUpdate(){
        formationArrayList.clear();
        formationArrayList.addAll(databasecon1.mainDAO().getAll());
    }
}