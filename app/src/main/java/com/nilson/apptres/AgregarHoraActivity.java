package com.nilson.apptres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class AgregarHoraActivity extends AppCompatActivity {



    private TextView fechainicio,fechatermino;
    private DatePickerDialog.OnDateSetListener fechaescuchadorinicio,fechaescuchadortermino;
    private TextView eHora;

    private int hora,minutos;
    private int anio, mes, dia;

    Calendar actual = Calendar.getInstance();

    Calendar calendar = Calendar.getInstance();


    Calendar calendarioinicial = Calendar.getInstance();
    Calendar calendariofinal = Calendar.getInstance();


    private Button btnguardar;

    private String nombreMesValido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_hora);

        fechainicio = (TextView) findViewById(R.id.tvfechainicio);
        fechatermino = (TextView) findViewById(R.id.tvfechatermino);
        eHora = (TextView) findViewById(R.id.eHora);
        btnguardar = findViewById(R.id.btnguardar);




        eHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar calendar = Calendar.getInstance();
                hora=calendar.get(Calendar.HOUR_OF_DAY);
                minutos = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(AgregarHoraActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int horadeldia, int min) {
                        eHora.setText("    "+horadeldia + ":" + min+" hrs");
                        //seagrego esto
                        calendar.set(Calendar.HOUR_OF_DAY,horadeldia);
                        calendar.set(Calendar.MINUTE,min);
                    }
                },hora,minutos,false);
                timePickerDialog.show();
            }
        });


        fechainicio.setText(null);
        final Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        final String DateTime = simpleDateFormat.format(cal.getTime());
        fechainicio.setText("   "+DateTime);



        fechainicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Calendar calendarioinicial = Calendar.getInstance();
                int dia = calendarioinicial.get(Calendar.DAY_OF_MONTH);
                int mes = calendarioinicial.get(Calendar.MONTH);
                int agno = calendarioinicial.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(AgregarHoraActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,fechaescuchadorinicio,agno,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        fechaescuchadorinicio = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int agno, int mes, int dia) {
                mes = mes+1;

                String nombreMes = Integer.toString(mes);
                ConvertirNombreMes(nombreMes);


                if(agno < cal.get(Calendar.YEAR)){

                    Toast.makeText(AgregarHoraActivity.this,"Error en el año no puede ser menor : "+agno,Toast.LENGTH_LONG).show();
                    return;
                }else if(mes < cal.get(Calendar.MONTH)+1 ){

                    Toast.makeText(AgregarHoraActivity.this,"Error en el mes no puede ser  : "+nombreMesValido,Toast.LENGTH_LONG).show();
                    return;
                }else if(dia < cal.get(Calendar.DAY_OF_MONTH) ){

                    Toast.makeText(AgregarHoraActivity.this,"Error en el dia no puede ser menor : "+dia,Toast.LENGTH_LONG).show();
                    return;
                }

                String datei = dia+" / "+mes+" / "+agno;
                fechainicio.setText("   "+datei);
                //Toast.makeText(AgregarHoraActivity.this,"Fecha inicio"+datei,Toast.LENGTH_LONG).show();
                calendar.set(Calendar.DAY_OF_MONTH,dia);
                calendar.set(Calendar.MONTH,mes);
                calendar.set(Calendar.YEAR,agno);

                Toast.makeText(AgregarHoraActivity.this,"Fecha Inicio : "+dia+" / "+nombreMesValido+" / "+agno,Toast.LENGTH_LONG).show();


            }
        };


        //escuchador de fecha final
        fechatermino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Calendar calendariofinal = Calendar.getInstance();
                int dia = calendariofinal.get(Calendar.DAY_OF_MONTH);
                int mes = calendariofinal.get(Calendar.MONTH);
                int agno = calendariofinal.get(Calendar.YEAR);
                DatePickerDialog dialog = new DatePickerDialog(AgregarHoraActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,fechaescuchadortermino,agno,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        fechaescuchadortermino = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int agno, int mes, int dia) {
                 mes = mes+1;
                String nombreMes = Integer.toString(mes);
                ConvertirNombreMes(nombreMes);

                String datef = dia+" / "+mes+" / "+agno;

                String fechafinal = dia+" / "+nombreMesValido+" / "+agno;
                String dias = String.valueOf(dia);
               String meses = String.valueOf(mes);
                String agnos = String.valueOf(agno);



                if(agno < cal.get(Calendar.YEAR)){
                    Toast.makeText(AgregarHoraActivity.this,"Error en el año no puede ser  : "+agno,Toast.LENGTH_LONG).show();
                    return;
                }else if(mes < cal.get(Calendar.MONTH)+1){
                    Toast.makeText(AgregarHoraActivity.this,"Error en el mes no puede ser  : "+nombreMesValido,Toast.LENGTH_LONG).show();
                    return;
                }else if(dia < cal.get(Calendar.DAY_OF_MONTH)){
                    Toast.makeText(AgregarHoraActivity.this,"Error en el dia no puede ser menor : "+dia,Toast.LENGTH_LONG).show();
                    return;
                }
                fechatermino.setText("   "+datef);
                Toast.makeText(AgregarHoraActivity.this,dias+" / "+nombreMesValido+" / "+agnos+"  ",Toast.LENGTH_LONG).show();
            }
        };








        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fechai = fechainicio.getText().toString();
                String fechaf = fechatermino.getText().toString();
                String alarm = eHora.getText().toString();

                //donde recibimos el nombre del medicamento con Bundle
                Bundle extras = getIntent().getExtras();
                String nombremed = extras.getString("Nombremedi");

                //la lista donde colocaremos los datos para el recyclerview
                lista listadatos = new lista(fechaf,fechai,alarm,nombremed);
                ActivityMenu.Arraydatos.add(listadatos);

                //Toast.makeText(AgregarHoraActivity.this,"nombre medicina : "+nombremed,Toast.LENGTH_SHORT).show();




                String tag = generatekey();

               // Long Alertime = calendar.getTimeInMillis() - System.currentTimeMillis();
                Long Alerttime = calendar.getTimeInMillis() - System.currentTimeMillis();
                int random = (int)(Math.random()*50+1);
                Data data = guardardata("Recuerda Facil uwu","Detalle : "+nombremed,random);
                Workmanagernot.guardarnoti(Alerttime,data,tag);
                Toast.makeText(AgregarHoraActivity.this,"Alarma Guardada",Toast.LENGTH_SHORT).show();



                Intent irMenu = new Intent(AgregarHoraActivity.this,ActivityMenu.class);
                startActivity(irMenu);

            }
        });
    }


    private String generatekey(){
        return UUID.randomUUID().toString();

    }



    private Data guardardata(String titulo,String detalle, int id){

        return new Data.Builder().putString("Titulo",titulo).putString("Detalle",detalle).putInt("id",id).build();

    }



    public void ConvertirNombreMes(String x){
         String mes = x;
        switch (x){
            case "1":{
                mes="Enero";
                nombreMesValido = mes;
                break;
            }
            case "2":{
                mes = "Febrero";
                nombreMesValido = mes;
                break;
            }
            case "3":{
                mes = "Marzo";
                nombreMesValido = mes;
                break;
            }
            case "4":{
                mes = "Abril";
                nombreMesValido = mes;
                break;
            }
            case "5":{
                mes = "Mayo";
                nombreMesValido = mes;
                break;
            }
            case "6":{
                mes = "Junio";
                nombreMesValido = mes;
                break;
            }
            case "7":{
                mes = "Julio";
                nombreMesValido = mes;
                break;
            }
            case "8":{
                mes="Agosto";
                nombreMesValido = mes;
                break;
            }
            case "9":{
                mes = "Septiembre";
                nombreMesValido = mes;
                break;
            }
            case "10":{
                mes="Octubre";
                nombreMesValido = mes;
                break;
            }
            case "11":{
                mes ="Noviembre";
                nombreMesValido = mes;
                break;
            }
            case "12":{
                mes = "Diciembre";
                nombreMesValido = mes;
                break;
            }
            default:{
                mes = "Sin mes";
                nombreMesValido = mes;
            }
        }
    }




}