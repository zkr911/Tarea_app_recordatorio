package com.nilson.apptres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ActivityLista extends AppCompatActivity {


    private RecyclerView recyclerlista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerlista = findViewById(R.id.recyclerlista);
        recyclerlista.setLayoutManager(new LinearLayoutManager(this));

        adaptadorlista adaptadores = new adaptadorlista(ActivityMenu.Arraydatos);
        recyclerlista.setAdapter(adaptadores);


    }
}