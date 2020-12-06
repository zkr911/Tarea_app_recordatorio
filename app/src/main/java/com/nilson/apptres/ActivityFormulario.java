package com.nilson.apptres;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nilson.apptres.entidades.Usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityFormulario extends AppCompatActivity {


    EditText txtnombre,txtapellido,txtemail,txttelefono,txtpassuno,txtpassdos;
    RadioButton rbmasculino,rbfemenino;
    Button btnenviar;
    RadioGroup rggeneros;


    private FirebaseDatabase database;
    private DatabaseReference reference;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtnombre = findViewById(R.id.txtnombre);
        txtapellido = findViewById(R.id.txtapellido);
        rggeneros = findViewById(R.id.rggeneros);
        rbfemenino = findViewById(R.id.rbfemenino);
        rbmasculino = findViewById(R.id.rbmasculino);
        txttelefono = findViewById(R.id.txttelefono);
        txtemail = findViewById(R.id.txtemail);
        txtpassdos = findViewById(R.id.txtpassdos);
        txtpassuno = findViewById(R.id.txtpassuno);
        btnenviar = findViewById(R.id.btnenviar);

        txtapellido.setEnabled(false);
        rbmasculino.setEnabled(false);
        rbfemenino.setEnabled(false);
        txttelefono.setEnabled(false);
        txtemail.setEnabled(false);
        txtpassuno.setEnabled(false);
        txtpassdos.setEnabled(false);
        btnenviar.setEnabled(false);

        txtnombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String nombre = txtnombre.getText().toString();

                if(nombre.trim().length()==0) {
                    Alert("NO ingreso nombre");
                    txtapellido.setEnabled(false);
                    return;
                }else if( nombre.trim().length() < 2){
                    Alert("Nombre es muy corto");
                    txtnombre.setError("Invalido");
                    return;
                }else if(nombre.trim().length() > 15){
                    Alert("Nombre es muy largo");
                    txtnombre.setError("Invalido");
                    return;
                }else{
                    Alert("Nombre valido");
                    txtapellido.setEnabled(true);
                    return;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });





        txtapellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                txtnombre.setText(txtnombre.getText().toString().replace(" ","").trim());

                if(charSequence.length() == 0){
                    Alert("No ingreso Apellido");
                    rbmasculino.setEnabled(false);
                    rbfemenino.setEnabled(false);

                }else if(charSequence.length() < 3){
                    Alert("Apellido es muy corto");
                    rbmasculino.setEnabled(false);
                    rbfemenino.setEnabled(false);
                    txtapellido.setError("Invalido");
                    return;
                }else if(charSequence.length() > 20){
                    Alert("Apellido es muy largo");
                    rbmasculino.setEnabled(false);
                    rbfemenino.setEnabled(false);
                    txtapellido.setError("Invalido");
                    return;
                }else{
                    Alert("Apellido Valido");
                    rbmasculino.setEnabled(true);
                    rbfemenino.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        rggeneros.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                txtapellido.setText(txtapellido.getText().toString().trim());
                if(i == R.id.rbmasculino){
                    Alert("Selecciono Masculino");
                    txtemail.setEnabled(true);
                }else{
                    Alert("Selecciono Femenino");
                    txtemail.setEnabled(true);
                }
            }
        });




        txtemail.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           String email = txtemail.getText().toString().trim();
            if(email.isEmpty()){
                txtemail.setError("Invalido");
                Alert("Complete el Email");
                txttelefono.setEnabled(false);
                return;
            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                txtemail.setError("Invalido");
                Alert("Complete el email");
                txttelefono.setEnabled(false);
                return;
            }else{
                txtemail.setError(null);
                txttelefono.setEnabled(true);
                Alert("Email valido");
            }
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
        });




        txttelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                txtemail.setText(txtemail.getText().toString().trim());
                if(charSequence.length() == 0){
                    Alert("NO ingreso telefono");
                    txtpassuno.setEnabled(false);
                    return;
                }
                else if(charSequence.length() < 7){
                    Alert("Telefono no valido");
                    txttelefono.setError("Invalido");
                    txtpassuno.setEnabled(false);
                    return;
                }else if(charSequence.length() > 10){
                    Alert("Telefono no valido");
                    txttelefono.setError("Invalido");
                    txtpassuno.setEnabled(false);
                    return;
                }else{
                    Alert("Telefono Valido");
                    txtpassuno.setEnabled(true);
                    return;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });




            txtpassuno.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(charSequence.length()==0){
                        Alert("NO ingreso contraseña");
                        return;
                    }else if(charSequence.length() < 5){
                        Alert("Contraseña muy corta");
                        txtpassuno.setError("Invalida");
                        return;
                    }else if(charSequence.length() >10){
                        Alert("Contraseña muy larga");
                        txtpassuno.setError("Invalida");
                        return;
                    }else{
                        Alert("Contraseña valida");
                        txtpassdos.setEnabled(true);
                        return;
                    }
                }
                @Override
                public void afterTextChanged(Editable editable) {
                }
            });



            txtpassdos.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String passworduno=txtpassuno.getText().toString();
                    String passworddos = txtpassdos.getText().toString();
                    if(passworduno.trim().equals(passworddos.trim())){
                        Alert("Contraseña valida");
                        btnenviar.setEnabled(true);
                        return;
                    }else{
                        Alert("Contraseña no es igual");
                        btnenviar.setEnabled(false);
                        txtpassdos.setError("Error");
                        return;
                    }
                }
                @Override
                public void afterTextChanged(Editable editable) {
                }
            });






        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conectar a la base de dato
                //cuando se aprete el boton enviar.
                conectarFirebase();
                String nombre = txtnombre.getText().toString();
                String apellido = txtapellido.getText().toString();
                int gen = rggeneros.getCheckedRadioButtonId();
                String genero = Integer.valueOf(gen).toString();
                String email = txtemail.getText().toString();
                String telefo = txttelefono.getText().toString();
                int telefono = Integer.parseInt(telefo);
                String pass = txtpassdos.getText().toString();
                Usuario persona = new Usuario(nombre,apellido,genero,email,telefono,pass);
                agregarusuario(persona);
                Intent IrMenu = new Intent(ActivityFormulario.this,MainActivity.class);
                startActivity(IrMenu);
            }
        });
    }



    public void conectarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        if(reference != null){
            Alert("Conectado a FireBase");
        }
    }




    public void agregarusuario(Usuario usuario){
       reference.child("Usuario").push().setValue(usuario, new DatabaseReference.CompletionListener() {
           @Override
           public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
            Alert("Usuario Agregado");
           }
       });
    }




    public void Alert(String mensaje){
        Toast.makeText(ActivityFormulario.this,mensaje,Toast.LENGTH_SHORT).show();
    }





}