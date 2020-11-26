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
    private Button btnubicacion;

   public static ArrayList<lista> Arraydatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnagregarmedicina = findViewById(R.id.btnagregarmedicina);
        btnverhora = findViewById(R.id.btnverhora);
        btnubicacion = findViewById(R.id.btnubicacion);


        //botton para agregar una medicina
        btnagregarmedicina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent verAgregarMedicina = new Intent(ActivityMenu.this,ActivityNameMedicamento.class);
            startActivity(verAgregarMedicina);

            }
        });


        //boton ver las horas guardadas
        btnverhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            Intent veractivitylista = new Intent(ActivityMenu.this,ActivityLista.class);
            startActivity(veractivitylista);



            }
        });



        //boton para ver ubicaciones seleccionadas
        btnubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             Intent vermapa = new Intent(ActivityMenu.this,MapsActivity.class);
         startActivity(vermapa);



            }
        });




    }
}