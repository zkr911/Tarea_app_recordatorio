package com.nilson.apptres;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nilson.apptres.entidades.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText txtemail,txtpass;
    Button btningresar,btnregistrar;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    ArrayList<Usuario> arrayListUsuario;
    Usuario usuario;

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






                //conectarFirebase();
                //verificar();





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






    public void conectarFirebase(){

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        if(reference != null){
            Toast.makeText(this,"conectado a firebase",Toast.LENGTH_SHORT).show();

        }

    }







    public void verificar(){
        reference.child("Usuario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            //consultar a la base de datos si el string txtcorreo aparece en la base de datos





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}