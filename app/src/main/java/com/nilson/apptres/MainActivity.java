package com.nilson.apptres;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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



public class MainActivity extends AppCompatActivity {

    //variable a utilizar
    EditText txtemail,txtpass;
    Button btningresar,btnregistrar;

    //conectado a firebase
    private FirebaseDatabase database;
    private DatabaseReference reference;

      static   Usuario usuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpassuno);

        btningresar = findViewById(R.id.btningresar);
        btnregistrar = findViewById(R.id.btnregistrar);
        //Se conecta a la base de datos
        conectarFirebase();






        //Boton para ingresar a la app que valida el email y password
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            reference.child("Usuario").addValueEventListener(new ValueEventListener() {

                boolean usuariocreado = false;

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapdato : dataSnapshot.getChildren()){
                        usuario = snapdato.getValue(Usuario.class);
                        if(usuario.getCorreo().equals(txtemail.getText().toString())){
                            usuariocreado=true;

                            if(usuario.getPassword().equals(txtpass.getText().toString())){

                                Alert("Bienvenido");
                                Intent enviaralregistro = new Intent(MainActivity.this,ActivityMenu.class);

                                startActivity(enviaralregistro);

                                return;
                            }else{
                                Alert("Login Incorrecto");
                            }

                        }if(usuariocreado == false){
                            Alert("Error correo ya existe.");
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            }
        });












        //boton para registrarse en la app que envia al formulario.
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent enviarAformilario = new Intent(MainActivity.this,ActivityFormulario.class);
                startActivity(enviarAformilario);

            }
        });


    }//fin






    //Metodo conectar a la base de datos de firebase
    public void conectarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        if(reference != null){
            Toast.makeText(this,"conectado a firebase",Toast.LENGTH_SHORT).show();
        }
    }



    //Metodo para colocar mensajes
    public void Alert(String mensaje){
        Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
    }





}