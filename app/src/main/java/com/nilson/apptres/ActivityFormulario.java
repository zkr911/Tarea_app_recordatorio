package com.nilson.apptres;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityFormulario extends AppCompatActivity {


    EditText txtnombre,txtapellido,txtemail,txttelefono,txtpassuno,txtpassdos;
    RadioButton rbmasculino,rbfemenino;
    Button btnenviar;
    RadioGroup rggeneros;




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
                    Toast.makeText(ActivityFormulario.this, "No ingreso nombre", Toast.LENGTH_LONG).show();
                    txtapellido.setEnabled(false);
                    return;
                }else if( nombre.trim().length() < 2){
                    Toast.makeText(ActivityFormulario.this,"El nombre es muy corto",Toast.LENGTH_LONG).show();
                    txtnombre.setError("Invalido");
                    return;
                }else if(nombre.trim().length() > 15){
                    Toast.makeText(ActivityFormulario.this,"El nombre es muy largo",Toast.LENGTH_LONG).show();
                    txtnombre.setError("Invalido");
                    return;
                }else{
                    Toast.makeText(ActivityFormulario.this,"Nombre Valido",Toast.LENGTH_LONG).show();
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
                    Toast.makeText(ActivityFormulario.this,"No ingreso Apellido",Toast.LENGTH_LONG).show();
                    rbmasculino.setEnabled(false);
                    rbfemenino.setEnabled(false);

                }else if(charSequence.length() < 3){
                    Toast.makeText(ActivityFormulario.this,"El Apellido es muy corto",Toast.LENGTH_LONG).show();
                    rbmasculino.setEnabled(false);
                    rbfemenino.setEnabled(false);
                    txtapellido.setError("Invalido");
                    return;
                }else if(charSequence.length() > 20){
                    Toast.makeText(ActivityFormulario.this,"El Apellido es muy largo",Toast.LENGTH_LONG).show();
                    rbmasculino.setEnabled(false);
                    rbfemenino.setEnabled(false);
                    txtapellido.setError("Invalido");
                    return;
                }else{
                    Toast.makeText(ActivityFormulario.this,"Apellido Valido",Toast.LENGTH_LONG).show();
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
                    Toast.makeText(ActivityFormulario.this,"Selecciono Masculino",Toast.LENGTH_LONG).show();
                    txtemail.setEnabled(true);
                }else{
                    Toast.makeText(ActivityFormulario.this,"Selecciono Femenino",Toast.LENGTH_LONG).show();
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
                Toast.makeText(ActivityFormulario.this,"Complete el email",Toast.LENGTH_LONG).show();
                txttelefono.setEnabled(false);
                return;
            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                txtemail.setError("Invalido");
                Toast.makeText(ActivityFormulario.this,"Complete el email",Toast.LENGTH_LONG).show();
                txttelefono.setEnabled(false);
                return;
            }else{
                txtemail.setError(null);
                txttelefono.setEnabled(true);
                Toast.makeText(ActivityFormulario.this,"Email valido",Toast.LENGTH_LONG).show();
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
                    Toast.makeText(ActivityFormulario.this,"No ingreso telefono",Toast.LENGTH_LONG).show();

                    txtpassuno.setEnabled(false);
                    return;

                }

                else if(charSequence.length() < 7){
                    Toast.makeText(ActivityFormulario.this,"Telefono no valido",Toast.LENGTH_LONG).show();
                    txttelefono.setError("Invalido");
                    txtpassuno.setEnabled(false);
                    return;

                }else if(charSequence.length() > 10){
                    Toast.makeText(ActivityFormulario.this,"Telefono no valido",Toast.LENGTH_LONG).show();
                    txttelefono.setError("Invalido");
                    txtpassuno.setEnabled(false);
                    return;
                }else{

                    Toast.makeText(ActivityFormulario.this,"Telefono valido",Toast.LENGTH_LONG).show();
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
                        Toast.makeText(ActivityFormulario.this,"no ingreso contraseña",Toast.LENGTH_LONG).show();
                        return;

                    }else if(charSequence.length() < 5){
                        Toast.makeText(ActivityFormulario.this,"Contraseña muy corta",Toast.LENGTH_LONG).show();
                        txtpassuno.setError("Invalida");
                        return;

                    }else if(charSequence.length() >10){
                        Toast.makeText(ActivityFormulario.this,"Contraseña muy larga",Toast.LENGTH_LONG).show();
                        txtpassuno.setError("Invalida");
                        return;
                    }else{
                        Toast.makeText(ActivityFormulario.this,"Contraseña valida",Toast.LENGTH_LONG).show();
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
                        Toast.makeText(ActivityFormulario.this,"Contraseña valida",Toast.LENGTH_LONG).show();
                        btnenviar.setEnabled(true);
                        return;
                    }else{
                        Toast.makeText(ActivityFormulario.this,"Contraseña no es igual",Toast.LENGTH_LONG).show();
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

                Intent IrMenu = new Intent(ActivityFormulario.this,MainActivity.class);
                startActivity(IrMenu);







            }
        });



    }




}