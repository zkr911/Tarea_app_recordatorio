package com.nilson.apptres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ActivityMenu extends AppCompatActivity {

    private Button btnagregarhora;
    private  Button btnverhora;

   public static ArrayList<lista> Arraydatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnagregarhora = findViewById(R.id.btnagregarhora);
        btnverhora = findViewById(R.id.btnverhora);



        btnagregarhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });


        btnverhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });



    }
}