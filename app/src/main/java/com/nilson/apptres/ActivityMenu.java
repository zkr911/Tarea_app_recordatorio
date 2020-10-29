package com.nilson.apptres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ActivityMenu extends AppCompatActivity {

    private Button btnagregarmedicina;
    private  Button btnverhora;

   public static ArrayList<lista> Arraydatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnagregarmedicina = findViewById(R.id.btnagregarmedicina);
        btnverhora = findViewById(R.id.btnverhora);


        btnagregarmedicina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

Intent verAgregarMedicina = new Intent(ActivityMenu.this,ActivityNameMedicamento.class);
startActivity(verAgregarMedicina);

            }
        });


        btnverhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            Intent veractivitylista = new Intent(ActivityMenu.this,ActivityLista.class);
            startActivity(veractivitylista);



            }
        });



    }
}