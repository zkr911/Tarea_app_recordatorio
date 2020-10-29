package com.nilson.apptres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText txtemail,txtpass;
    Button btningresar,btnregistrar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpassuno);

        btningresar = findViewById(R.id.btningresar);
        btnregistrar = findViewById(R.id.btnregistrar);


        //boton para ingresar a la app
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent enviaralregistro = new Intent(MainActivity.this,ActivityMenu.class);
            startActivity(enviaralregistro);


            }
        });



        //boton para registrarse en la app
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent enviarAformilario = new Intent(MainActivity.this,ActivityFormulario.class);
                startActivity(enviarAformilario);

            }
        });








    }
}