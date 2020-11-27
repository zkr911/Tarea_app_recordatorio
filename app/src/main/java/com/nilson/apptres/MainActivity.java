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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.nilson.apptres.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //variable a utilizar
    EditText txtemail,txtpass;
    Button btningresar,btnregistrar;

    //conectado a firebase
    private FirebaseDatabase database;
    private DatabaseReference reference;

      static   Usuario usuario;


    String correo;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpassuno);

        btningresar = findViewById(R.id.btningresar);
        btnregistrar = findViewById(R.id.btnregistrar);
        conectarFirebase();






        //boton para ingresar a la app
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            reference.child("Usuario").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapdato : dataSnapshot.getChildren()){
                        usuario = snapdato.getValue(Usuario.class);
                        if(usuario.getCorreo().equals(txtemail.getText().toString())){

                            if(usuario.getPassword().equals(txtpass.getText().toString())){
                                Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                                Intent enviaralregistro = new Intent(MainActivity.this,ActivityMenu.class);
                                startActivity(enviaralregistro);
                            }else{
                                Toast.makeText(MainActivity.this, "Login incorrecto", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(MainActivity.this, "Error correo no existe", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });







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










    public void verificarusuario(){

          //usercorreo = txtemail.getText().toString().trim();
         // userpass = txtpass.getText().toString().trim();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //String user = dataSnapshot.child("correo").getValue().toString();
                //String pass = dataSnapshot.child("password").getValue().toString();


               // if(usercorreo.equals(usuario.getCorreo()) & userpass.equals(usuario.getPassword())){

                    Intent enviaralregistro = new Intent(MainActivity.this,ActivityMenu.class);
                    startActivity(enviaralregistro);

              //  }else{


                    Toast.makeText(MainActivity.this, "Login incorrecto", Toast.LENGTH_SHORT).show();

               // }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }









    public void verificar(){
        reference.child("Usuario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //arrayListUsuario.clear();

                for(DataSnapshot dato : dataSnapshot.getChildren()){

                   // usuario = dataSnapshot.getValue(Usuario.class);

                   // String correobd = dato.child("correo").getValue(String.class);
                    //String correobd =   usuario.getCorreo();
                // String pass = usuario.getPassword();
                    //cosa.add(correobd);

                    String correomenu = txtemail.getText().toString();

                   // Query useremail = reference.orderByChild(usuario.getCorreo()).equalTo(correomenu).limitToFirst(1);




                   // Toast.makeText(MainActivity.this,"Correos : "+useremail,Toast.LENGTH_SHORT).show();


                }






            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

              //  Toast.makeText(MainActivity.this,"Correos : ERROR "+usuario,Toast.LENGTH_SHORT).show();

            }
        });


    }


}